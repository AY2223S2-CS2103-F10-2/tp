package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.lecture.Lecture;
import seedu.address.model.lecture.LectureName;
import seedu.address.model.lecture.ReadOnlyLecture;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.module.ReadOnlyModule;
import seedu.address.model.tag.Tag;
import seedu.address.model.video.Video;
import seedu.address.model.video.VideoName;

/**
 * Tag a video, a lecture, or a module.
 */

public class UntagCommand extends Command {
    public static final String COMMAND_WORD = "untag";

    //TODO: MODIFY THIS
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Untag a specified video, module, or lecture ";
    //TODO: MODIFY THIS
    public static final String MESSAGE_SUCCESS = "%1$s untagged";
    private final Set<Tag> deletingTags;
    private final VideoName videoName;
    private final LectureName lectureName;
    private final ModuleCode moduleCode;
    private final boolean isUntaggingMod;
    private final boolean isUntaggingLec;
    private final boolean isUntaggingVid;

    /**
     * Creates an UntagCommand to untag the specified {@code Module}
     */


    public UntagCommand(Set<Tag> deletingTags, ModuleCode moduleCode) {
        requireAllNonNull(deletingTags, moduleCode);

        this.deletingTags = deletingTags;
        this.videoName = new VideoName("dummy");
        this.lectureName = new LectureName("dummy");
        this.moduleCode = moduleCode;
        this.isUntaggingMod = true;
        this.isUntaggingLec = false;
        this.isUntaggingVid = false;
    }

    /**
     * Creates an UntagCommand to untag the specified {@code Lecture}
     */

    public UntagCommand(Set<Tag> deletingTags, ModuleCode moduleCode, LectureName lectureName) {
        requireAllNonNull(deletingTags, moduleCode, lectureName);

        this.deletingTags = deletingTags;
        this.videoName = new VideoName("dummy");
        this.lectureName = lectureName;
        this.moduleCode = moduleCode;
        this.isUntaggingMod = false;
        this.isUntaggingLec = true;
        this.isUntaggingVid = false;
    }

    /**
     * Creates an UntagCommand to untag the specified {@code Video}
     */
    public UntagCommand(Set<Tag> deletingTags, ModuleCode moduleCode, LectureName lectureName, VideoName videoName) {
        requireAllNonNull(deletingTags, moduleCode, lectureName, videoName);

        this.deletingTags = deletingTags;
        this.videoName = videoName;
        this.lectureName = lectureName;
        this.moduleCode = moduleCode;
        this.isUntaggingMod = false;
        this.isUntaggingLec = false;
        this.isUntaggingVid = true;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (this.deletingTags.isEmpty()) {
            throw new CommandException(Messages.MESSAGE_EMPTY_TAGS);
        }

        if (this.isUntaggingMod) {
            return untagModule(model);
        } else if (this.isUntaggingLec) {
            return untagLecture(model);
        } else {
            return untagVideo(model);
        }
    }

    private CommandResult untagModule(Model model) throws CommandException {
        if (!model.hasModule(moduleCode)) {
            throw new CommandException(String.format(Messages.MESSAGE_MODULE_DOES_NOT_EXIST, moduleCode));
        }

        ReadOnlyModule untaggingModule = model.getModule(this.moduleCode);

        Set<Tag> currentTags = untaggingModule.getTags();

        List<String> listOfUnfoundTags = deletingTags.stream()
                .filter(tag -> !currentTags.contains(tag)).map(tag -> tag.getTagName()).collect(Collectors.toList());

        if (listOfUnfoundTags.size() > 0) {
            throw new CommandException(String.format(Messages.MESSAGE_MODULE_TAG_DOES_NOT_EXIST,
                    String.join(", ", listOfUnfoundTags),
                    moduleCode));
        }

        Set<Tag> newTags = new HashSet<>();
        newTags.addAll(currentTags);

        newTags = newTags.stream().filter(tag -> !deletingTags.contains(tag))
                .collect(Collectors.toSet());

        List<Lecture> currentLectureList = (List<Lecture>) untaggingModule.getLectureList();

        Module untaggedModule = new Module(untaggingModule.getCode(),
                untaggingModule.getName(), newTags, currentLectureList);
        model.setModule(untaggingModule, untaggedModule);
        return new CommandResult(String.format(MESSAGE_SUCCESS, moduleCode));
    }

    private CommandResult untagLecture(Model model) throws CommandException {
        if (!model.hasModule(moduleCode)) {
            throw new CommandException(String.format(Messages.MESSAGE_MODULE_DOES_NOT_EXIST, moduleCode));
        }

        if (!model.hasLecture(this.moduleCode, this.lectureName)) {
            throw new CommandException(String.format(Messages.MESSAGE_LECTURE_DOES_NOT_EXIST, this.lectureName,
                    moduleCode));
        }

        ReadOnlyModule targetModule = model.getModule(this.moduleCode);
        ReadOnlyLecture untaggingLecture = targetModule.getLecture(this.lectureName);

        Set<Tag> currentTags = untaggingLecture.getTags();

        List<String> listOfUnfoundTags = deletingTags.stream()
                .filter(tag -> !currentTags.contains(tag)).map(tag -> tag.getTagName()).collect(Collectors.toList());

        if (listOfUnfoundTags.size() > 0) {
            throw new CommandException(String.format(Messages.MESSAGE_LECTURE_TAG_DOES_NOT_EXIST,
                    String.join(", ", listOfUnfoundTags), lectureName,
                    moduleCode));
        }

        Set<Tag> newTags = new HashSet<>();
        newTags.addAll(currentTags);
        newTags = newTags.stream().filter(tag -> !deletingTags.contains(tag))
                .collect(Collectors.toSet());

        Lecture untaggedLecture = new Lecture(untaggingLecture.getName(), newTags, untaggingLecture.getVideoList());
        model.setLecture(targetModule, untaggingLecture, untaggedLecture);
        return new CommandResult(String.format(MESSAGE_SUCCESS, lectureName));
    }

    private CommandResult untagVideo(Model model) throws CommandException {
        if (!model.hasModule(moduleCode)) {
            throw new CommandException(String.format(Messages.MESSAGE_MODULE_DOES_NOT_EXIST, moduleCode));
        }

        if (!model.hasLecture(this.moduleCode, this.lectureName)) {
            throw new CommandException(String.format(Messages.MESSAGE_LECTURE_DOES_NOT_EXIST, this.lectureName,
                    this.moduleCode));
        }

        ReadOnlyModule targetModule = model.getModule(this.moduleCode);
        ReadOnlyLecture targetLecture = targetModule.getLecture(this.lectureName);

        if (!model.hasVideo(targetLecture, this.videoName)) {
            throw new CommandException(String.format(Messages.MESSAGE_VIDEO_TAG_DOES_NOT_EXIST, this.videoName,
                    this.lectureName,
                    this.moduleCode));
        }

        Video untaggingVideo = targetLecture.getVideo(this.videoName);

        Set<Tag> currentTags = untaggingVideo.getTags();
        List<String> listOfUnfoundTags = deletingTags.stream()
                .filter(tag -> !currentTags.contains(tag)).map(tag -> tag.getTagName()).collect(Collectors.toList());

        if (listOfUnfoundTags.size() > 0) {
            throw new CommandException(String.format(Messages.MESSAGE_MODULE_TAG_DOES_NOT_EXIST,
                    String.join(", ", listOfUnfoundTags),
                    moduleCode));
        }

        Set<Tag> newTags = new HashSet<>();
        newTags.addAll(currentTags);
        newTags = newTags.stream().filter(tag -> !deletingTags.contains(tag))
                .collect(Collectors.toSet());

        Video taggedVideo = new Video(untaggingVideo.getName(), untaggingVideo.hasWatched(), newTags);
        model.setVideo(targetLecture, untaggingVideo, taggedVideo);
        return new CommandResult(String.format(MESSAGE_SUCCESS, videoName));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof UntagCommand)) {
            return false;
        }

        UntagCommand otherCommand = (UntagCommand) other;

        return deletingTags.equals(otherCommand.deletingTags)
                && videoName.equals(otherCommand.videoName)
                && lectureName.equals(otherCommand.lectureName)
                && moduleCode.equals(otherCommand.moduleCode)
                && (isUntaggingVid == otherCommand.isUntaggingVid)
                && (isUntaggingLec == otherCommand.isUntaggingLec)
                && (isUntaggingMod == otherCommand.isUntaggingMod);
    }
}
