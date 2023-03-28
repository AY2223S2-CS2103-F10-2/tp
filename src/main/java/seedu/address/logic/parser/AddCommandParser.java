package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LECTURE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MODULE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_WATCH;

import java.util.ArrayList;
import java.util.Set;

import seedu.address.logic.commands.add.AddCommand;
import seedu.address.logic.commands.add.AddLectureCommand;
import seedu.address.logic.commands.add.AddModuleCommand;
import seedu.address.logic.commands.add.AddVideoCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.lecture.Lecture;
import seedu.address.model.lecture.LectureName;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.module.ModuleName;
import seedu.address.model.tag.Tag;
import seedu.address.model.video.Video;
import seedu.address.model.video.VideoName;

/**
 * Parses input arguments and creates a new {@code AddCommand} object.
 */
public class AddCommandParser implements Parser<AddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an {@code AddCommand} object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(
                args, PREFIX_NAME, PREFIX_MODULE, PREFIX_LECTURE, PREFIX_TAG, PREFIX_WATCH);

        if (isAddModule(argMultimap)) {
            return parseAddModuleCommand(argMultimap);
        } else if (isAddLecture(argMultimap)) {
            return parseAddLectureCommand(argMultimap);
        } else if (isAddVideo(argMultimap)) {
            return parseAddVideoCommand(argMultimap);
        } else {
            throw createInvalidCommandFormatException();
        }
    }

    private boolean isAddModule(ArgumentMultimap argMultimap) {
        return !argMultimap.getPreamble().isEmpty()
                && argMultimap.getValue(PREFIX_MODULE).isEmpty()
                && argMultimap.getValue(PREFIX_LECTURE).isEmpty();
    }

    private AddCommand parseAddModuleCommand(ArgumentMultimap argMultimap) throws ParseException {
        String moduleCodeStr = argMultimap.getPreamble();
        String moduleNameStr = argMultimap.getValue(PREFIX_NAME).orElse("");
        String tagsStr = argMultimap.getValue(PREFIX_TAG).orElse("");

        ModuleCode moduleCode = ParserUtil.parseModuleCode(moduleCodeStr);
        ModuleName moduleName = ParserUtil.parseModuleName(moduleNameStr);
        Set<Tag> tags = ParserUtil.parseMultiTags(tagsStr);

        Module module = new Module(moduleCode, moduleName, tags, new ArrayList<>());

        return new AddModuleCommand(module);
    }

    private boolean isAddLecture(ArgumentMultimap argMultimap) {
        return !argMultimap.getPreamble().isEmpty()
                && argMultimap.getValue(PREFIX_MODULE).isPresent()
                && argMultimap.getValue(PREFIX_LECTURE).isEmpty();
    }

    private AddCommand parseAddLectureCommand(ArgumentMultimap argMultimap) throws ParseException {
        String moduleCodeStr = argMultimap.getValue(PREFIX_MODULE).get();
        String lectureNameStr = argMultimap.getPreamble();
        String tagsStr = argMultimap.getValue(PREFIX_TAG).orElse("");

        ModuleCode moduleCode = ParserUtil.parseModuleCode(moduleCodeStr);
        LectureName lectureName = ParserUtil.parseLectureName(lectureNameStr);
        Set<Tag> tags = ParserUtil.parseMultiTags(tagsStr);

        Lecture lecture = new Lecture(lectureName, tags, new ArrayList<>());

        return new AddLectureCommand(moduleCode, lecture);
    }

    private boolean isAddVideo(ArgumentMultimap argMultimap) {
        return !argMultimap.getPreamble().isEmpty()
                && argMultimap.getValue(PREFIX_MODULE).isPresent()
                && argMultimap.getValue(PREFIX_LECTURE).isPresent();
    }

    private AddCommand parseAddVideoCommand(ArgumentMultimap argMultimap) throws ParseException {
        String moduleCodeStr = argMultimap.getValue(PREFIX_MODULE).get();
        String lectureNameStr = argMultimap.getValue(PREFIX_LECTURE).get();
        String videoNameStr = argMultimap.getPreamble();
        String tagsStr = argMultimap.getValue(PREFIX_TAG).orElse("");

        ModuleCode moduleCode = ParserUtil.parseModuleCode(moduleCodeStr);
        LectureName lectureName = ParserUtil.parseLectureName(lectureNameStr);
        VideoName videoName = ParserUtil.parseVideoName(videoNameStr);
        Set<Tag> tags = ParserUtil.parseMultiTags(tagsStr);

        boolean hasWatched = argMultimap.getValue(PREFIX_WATCH).isPresent();

        Video video = new Video(videoName, hasWatched, tags);
        return new AddVideoCommand(moduleCode, lectureName, video);
    }

    private ParseException createInvalidCommandFormatException() {
        return new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
    }

}
