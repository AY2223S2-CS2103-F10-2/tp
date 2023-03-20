package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.lecture.Lecture;
import seedu.address.model.lecture.LectureName;
import seedu.address.model.lecture.ReadOnlyLecture;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.module.ReadOnlyModule;
import seedu.address.model.tag.Tag;
import seedu.address.model.video.Video;
import seedu.address.model.video.VideoName;
import seedu.address.testutil.ModelStub;
import seedu.address.testutil.TypicalLectures;
import seedu.address.testutil.TypicalModules;
import seedu.address.testutil.TypicalTags;
import seedu.address.testutil.TypicalVideos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.testutil.Assert.assertThrows;

public class TagCommandTest {
    private static final String VALID_TAG_1 = "cool";
    private static final String VALID_TAG_2 = "hard";

    /**
     * A {@code Model} stub that contains a single module.
     */
    private class ModelStubWithModule extends ModelStub {
        private Module module;

        public ModelStubWithModule(Module module) {
            requireNonNull(module);
            this.module = module;
        }

        @Override
        public boolean hasModule(ModuleCode module) {
            requireNonNull(module);
            return this.module.getCode().equals(module);
        }

        @Override
        public boolean hasLecture(ModuleCode module, LectureName lecture) {
            requireAllNonNull(module, lecture);
            return this.module.getLecture(lecture) != null;
        }

        public boolean hasVideo(ReadOnlyLecture lecture, VideoName video) {
            requireAllNonNull(module, lecture, video);
            return lecture.hasVideo(video);
        }


        public ReadOnlyModule getModule(ModuleCode moduleCode) {
            return module;
        }

        @Override
        public void setModule(ReadOnlyModule target, Module editedModule) {
            this.module = editedModule;
        }

        @Override
        public void setLecture(ReadOnlyModule module, ReadOnlyLecture target, Lecture editedLecture) {
            this.module.setLecture(target, editedLecture);
        }

        @Override
        public void setVideo(ReadOnlyLecture lecture, Video target, Video editedVideo) {
            ReadOnlyLecture lec = this.module.getLecture(lecture.getName());
            ((Lecture) lec).setVideo(target, editedVideo);
        }
    }

    @Test
    public void execute_nullModel_throwsNullPointerException() {
        ModuleCode moduleCode = TypicalModules.CS2040S.getCode();
        Set<Tag> tagSet = new HashSet<>(List.of(TypicalTags.CS2040S_1, TypicalTags.CS2040S_2));
        TagCommand command = new TagCommand(tagSet,moduleCode);
        assertThrows(NullPointerException.class, () -> command.execute(null));
    }

    @Test
    public void equals() {
        ModuleCode firstModuleCode = TypicalModules.CS2040S.getCode();
        Set<Tag> firstTagSet = new HashSet<>(List.of(TypicalTags.CS2040S_1,TypicalTags.CS2040S_2,
                TypicalTags.CS2040S_3));

        ModuleCode secondModuleCode = TypicalModules.CS2107.getCode();
        LectureName lectureName = TypicalLectures.CS2107_LECTURE_1.getName();
        Set<Tag> secondTagSet = new HashSet<>(List.of(TypicalTags.CS2107_LECTURE_1));

        TagCommand tagModule = new TagCommand(firstTagSet, firstModuleCode);
        TagCommand tagModuleCopy = new TagCommand(firstTagSet, firstModuleCode);
        TagCommand tagLecture = new TagCommand(secondTagSet, secondModuleCode, lectureName);

        assertTrue(tagModule.equals(tagModule));
        assertTrue(tagModule.equals(tagModuleCopy));
        assertFalse(tagModule.equals(1));
        assertFalse(tagModule.equals(tagLecture));
    }

    @Test
    public void execute_emptyTags_throwCommandException() {
        ModelStubWithModule moduleStub = new ModelStubWithModule(TypicalModules.CS2107);
        Set<Tag> tagSet = new HashSet<>();
        VideoName videoName = TypicalVideos.INTRO_VIDEO.getName();
        LectureName lectureName = TypicalLectures.CS2040S_WEEK_1.getName();
        ModuleCode moduleCode = TypicalModules.CS2040S.getCode();
        TagCommand tagCommandModule = new TagCommand(tagSet, moduleCode);
        TagCommand tagCommandLecture = new TagCommand(tagSet, moduleCode, lectureName);
        TagCommand tagCommandVideo = new TagCommand(tagSet, moduleCode, lectureName, videoName);
        assertThrows(CommandException.class, () -> tagCommandModule.execute(moduleStub));
        assertThrows(CommandException.class, () -> tagCommandLecture.execute(moduleStub));
        assertThrows(CommandException.class, () -> tagCommandVideo.execute(moduleStub));
    }

    @Test
    public void execute_tagModule_moduleNotFound() {
        ModelStubWithModule moduleStub = new ModelStubWithModule(TypicalModules.CS2107);
        Set<Tag> tagSet = new HashSet<>(List.of(TypicalTags.CS2040S_1,TypicalTags.CS2040S_2,
                TypicalTags.CS2040S_3));
        ModuleCode moduleCode = TypicalModules.CS2040S.getCode();
        TagCommand tagCommand = new TagCommand(tagSet, moduleCode);
        assertThrows(CommandException.class, () -> tagCommand.execute(moduleStub));
    }

    @Test
    public void execute_tagLecture_ModuleNotFound() {
        ModelStubWithModule moduleStub = new ModelStubWithModule(TypicalModules.CS2107);
        Set<Tag> tagSet = new HashSet<>(List.of(TypicalTags.CS2040S_WEEK_1_TAG));
        LectureName lectureName = TypicalLectures.CS2040S_WEEK_1.getName();
        ModuleCode moduleCode = TypicalModules.CS2040S.getCode();
        TagCommand tagCommand = new TagCommand(tagSet, moduleCode, lectureName);
        assertThrows(CommandException.class, () -> tagCommand.execute(moduleStub));
    }
    @Test
    public void execute_tagLecture_LectureNotFound() {
        ModelStubWithModule moduleStub = new ModelStubWithModule(TypicalModules.CS2040S);
        Set<Tag> tagSet = new HashSet<>(List.of(TypicalTags.CS2040S_WEEK_1_TAG));
        LectureName lectureName = TypicalLectures.CS2107_LECTURE_1.getName();
        ModuleCode moduleCode = TypicalModules.CS2040S.getCode();
        TagCommand tagCommand = new TagCommand(tagSet, moduleCode, lectureName);
        assertThrows(CommandException.class, () -> tagCommand.execute(moduleStub));
    }

    @Test
    public void execute_tagVideo_ModuleNotFound() {
        ModelStubWithModule moduleStub = new ModelStubWithModule(TypicalModules.CS2107);
        Set<Tag> tagSet = new HashSet<>(List.of(TypicalTags.CS2040S_WEEK_1_TAG));
        LectureName lectureName = TypicalLectures.CS2040S_WEEK_1.getName();
        ModuleCode moduleCode = TypicalModules.CS2040S.getCode();
        VideoName videoName = new VideoName("Probability");
        TagCommand tagCommand = new TagCommand(tagSet, moduleCode, lectureName, videoName);
        assertThrows(CommandException.class, () -> tagCommand.execute(moduleStub));
    }
    @Test
    public void execute_tagVideo_LectureNotFound() {
        ModelStubWithModule moduleStub = new ModelStubWithModule(TypicalModules.CS2040S);
        Set<Tag> tagSet = new HashSet<>(List.of(TypicalTags.CS2040S_WEEK_1_TAG));
        LectureName lectureName = TypicalLectures.CS2107_LECTURE_1.getName();
        ModuleCode moduleCode = TypicalModules.CS2040S.getCode();
        VideoName videoName = new VideoName("Probability");
        TagCommand tagCommand = new TagCommand(tagSet, moduleCode, lectureName, videoName);
        assertThrows(CommandException.class, () -> tagCommand.execute(moduleStub));
    }

    @Test
    public void execute_tagVideo_VideoNotFound() {
        ModelStubWithModule moduleStub = new ModelStubWithModule(TypicalModules.CS2040S);
        Set<Tag> tagSet = new HashSet<>(List.of(TypicalTags.CS2040S_WEEK_1_TAG));
        LectureName lectureName = TypicalLectures.CS2040S_WEEK_1.getName();
        ModuleCode moduleCode = TypicalModules.CS2040S.getCode();
        VideoName videoName = new VideoName("Probability");
        TagCommand tagCommand = new TagCommand(tagSet, moduleCode, lectureName, videoName);
        assertThrows(CommandException.class, () -> tagCommand.execute(moduleStub));
    }

    @Test
    public void execute_tagModule_success() throws CommandException {
        ModelStubWithModule moduleStub = new ModelStubWithModule(TypicalModules.CS2040S);
        Tag firstTag = new Tag(VALID_TAG_1);
        Tag secondTag = new Tag(VALID_TAG_2);
        Set<Tag> tagSet = new HashSet<>(List.of(firstTag, secondTag));
        ModuleCode moduleCode = TypicalModules.CS2040S.getCode();
        TagCommand tagCommand = new TagCommand(tagSet, moduleCode);

        CommandResult commandResult = tagCommand.execute(moduleStub);
        assertEquals(String.format(TagCommand.MESSAGE_SUCCESS, moduleCode),
                commandResult.getFeedbackToUser());

        Set<Tag> updatedTagSet = moduleStub.getModule(moduleCode).getTags();
        assertTrue(updatedTagSet.contains(firstTag));
        assertTrue(updatedTagSet.contains(secondTag));
    }
    @Test
    public void execute_tagLecture_success() throws CommandException {
        ModelStubWithModule moduleStub = new ModelStubWithModule(TypicalModules.CS2040S);
        Tag firstTag = new Tag(VALID_TAG_1);
        Tag secondTag = new Tag(VALID_TAG_2);
        Set<Tag> tagSet = new HashSet<>(List.of(firstTag, secondTag));
        ModuleCode moduleCode = TypicalModules.CS2040S.getCode();
        LectureName lectureName = TypicalLectures.CS2040S_WEEK_1.getName();
        TagCommand tagCommand = new TagCommand(tagSet, moduleCode, lectureName);

        CommandResult commandResult = tagCommand.execute(moduleStub);
        assertEquals(String.format(TagCommand.MESSAGE_SUCCESS, lectureName),
                commandResult.getFeedbackToUser());

        Set<Tag> updatedTagSet = moduleStub.getModule(moduleCode).getLecture(lectureName).getTags();
        assertTrue(updatedTagSet.contains(firstTag));
        assertTrue(updatedTagSet.contains(secondTag));
    }
    @Test
    public void execute_tagVideo_success() throws CommandException {
        ModelStubWithModule moduleStub = new ModelStubWithModule(TypicalModules.CS2040S);
        Tag firstTag = new Tag(VALID_TAG_1);
        Tag secondTag = new Tag(VALID_TAG_2);
        Set<Tag> tagSet = new HashSet<>(List.of(firstTag, secondTag));
        ModuleCode moduleCode = TypicalModules.CS2040S.getCode();
        LectureName lectureName = TypicalLectures.CS2040S_WEEK_1.getName();
        VideoName videoName = TypicalVideos.INTRO_VIDEO.getName();
        TagCommand tagCommand = new TagCommand(tagSet, moduleCode, lectureName, videoName);

        CommandResult commandResult = tagCommand.execute(moduleStub);
        assertEquals(String.format(TagCommand.MESSAGE_SUCCESS, videoName),
                commandResult.getFeedbackToUser());

        Set<Tag> updatedTagSet = moduleStub.getModule(moduleCode).getLecture(lectureName).getVideo(videoName).getTags();
        assertTrue(updatedTagSet.contains(firstTag));
        assertTrue(updatedTagSet.contains(secondTag));
    }
}