package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalVideos.ANALYSIS_VIDEO;
import static seedu.address.testutil.TypicalVideos.INTRO_VIDEO;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.delete.DeleteCommand;
import seedu.address.logic.commands.delete.DeleteLectureCommand;
import seedu.address.logic.commands.delete.DeleteModuleCommand;
import seedu.address.logic.commands.delete.DeleteVideoCommand;
import seedu.address.model.module.ModuleCode;
import seedu.address.testutil.TypicalLectures;
import seedu.address.testutil.TypicalModules;

/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the DeleteCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the DeleteCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class DeleteCommandParserTest {

    private DeleteCommandParser parser = new DeleteCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteModuleCommand() {
        assertParseSuccess(parser, "ST2334",
                new DeleteModuleCommand(TypicalModules.getSt2334().getCode()));
        assertParseSuccess(parser, "CS2040S",
                new DeleteModuleCommand(TypicalModules.getCs2040s().getCode()));
    }

    @Test
    public void parse_validArgs_returnsDeleteLectureCommand() {
        assertParseSuccess(parser, "Topic 1 /mod ST2334",
                new DeleteLectureCommand(TypicalLectures.getSt2334Topic1().getName(),
                        TypicalModules.getSt2334().getCode()));
        assertParseSuccess(parser, "Week 7 /mod CS2040S",
                new DeleteLectureCommand(TypicalLectures.getCs2040sWeek7().getName(),
                        TypicalModules.getCs2040s().getCode()));
    }

    @Test
    public void parse_validArgs_returnsDeleteVideoCommand() {
        assertParseSuccess(parser, "Vid 3 /mod ST2334 /lec Topic 1",
                new DeleteVideoCommand(INTRO_VIDEO.getName(),
                        TypicalModules.getSt2334().getCode(),
                        TypicalLectures.getSt2334Topic1().getName()));
        assertParseSuccess(parser, "Vid 2 /lec Week 3 /mod CS2040S",
                new DeleteVideoCommand(ANALYSIS_VIDEO.getName(),
                        TypicalModules.getCs2040s().getCode(),
                        TypicalLectures.getCs2040sWeek3().getName()));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE));
        assertParseFailure(parser, "name /lec lectureName", // specifies /lec without /mod
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidModuleCode_throwsParseException() {
        assertParseFailure(parser, "Week 1 /mod a",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                        ModuleCode.MESSAGE_CONSTRAINTS + "\n" + DeleteCommand.MESSAGE_USAGE));
        assertParseFailure(parser, "Week 1 /mod a /lec Some Lecture",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                        ModuleCode.MESSAGE_CONSTRAINTS + "\n" + DeleteCommand.MESSAGE_USAGE));
        assertParseFailure(parser, "Week 1 /lec Some Lecture /mod a",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                        ModuleCode.MESSAGE_CONSTRAINTS + "\n" + DeleteCommand.MESSAGE_USAGE));
    }
    //     @Test
    //     public void parse_blankNameArgs_throwsParseException() {
    //         String messageBlank = "Names should only contain"
    //                 + " alphanumeric characters and spaces,"
    //                 + " and it should not be blank";
    //         assertParseFailure(parser, " /mod CS2040S",
    //                 String.format(MESSAGE_INVALID_COMMAND_FORMAT,
    //                         messageBlank + "\n" + DeleteCommand.MESSAGE_USAGE));
    //         assertParseFailure(parser, "videoName /mod CS2040S /lec",
    //                 String.format(MESSAGE_INVALID_COMMAND_FORMAT,
    //                         messageBlank + "\n" + DeleteCommand.MESSAGE_USAGE));
    //         assertParseFailure(parser, " /mod CS2040S /lec lectureName",
    //                 String.format(MESSAGE_INVALID_COMMAND_FORMAT,
    //                         messageBlank + "\n" + DeleteCommand.MESSAGE_USAGE));
    //     }
}
