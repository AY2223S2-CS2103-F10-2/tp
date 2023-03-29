package seedu.address.commons.core;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command\n";
    public static final String MESSAGE_KNOWN_COMMANDS = "The known commands are:\n"
            + "nav, add, edit, delete, tag, list, find, mark, unmark, help and exit";

    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";

    public static final String MESSAGE_MODULES_LISTED_OVERVIEW = "%1$d modules listed!";
    public static final String MESSAGE_LECTURES_LISTED_OVERVIEW = "%1$d lectures listed!";
    public static final String MESSAGE_VIDEOS_LISTED_OVERVIEW = "%1$d videos listed!";

    public static final String MESSAGE_DOES_NOT_EXIST = "%1$s does not exist";
    public static final String MESSAGE_MODULE_DOES_NOT_EXIST = "Module "
            + String.format(MESSAGE_DOES_NOT_EXIST, "%1$s");
    public static final String MESSAGE_LECTURE_DOES_NOT_EXIST = "Lecture %1$s of "
            + String.format(MESSAGE_MODULE_DOES_NOT_EXIST, "%2$s");
    public static final String MESSAGE_VIDEO_DOES_NOT_EXIST = "Video %1$s of "
            + String.format(MESSAGE_LECTURE_DOES_NOT_EXIST, "%2$s", "%3$s");

    public static final String MESSAGE_MODULE_TAG_DOES_NOT_EXIST = "Tag %1$s of "
            + String.format(MESSAGE_MODULE_DOES_NOT_EXIST, "%2$s");
    public static final String MESSAGE_LECTURE_TAG_DOES_NOT_EXIST = "Tag %1$s of "
            + String.format(MESSAGE_LECTURE_DOES_NOT_EXIST, "%2$s", "%3$s");
    public static final String MESSAGE_VIDEO_TAG_DOES_NOT_EXIST = "Tag %1$s of "
            + String.format(MESSAGE_VIDEO_DOES_NOT_EXIST, "%2$s", "%3$s", "%4$s");

    public static final String MESSAGE_EMPTY_TAGS = "No tag is provided";
    public static final String MESSAGE_EMPTY_MODULE = "No module is provided";
    public static final String MESSAGE_ARCHIVE_FILE_ALREADY_EXIST = "File %1$s already exist. If you want to "
            + "overwrite this file, insert /overwrite true in the command";
    public static final String MESSAGE_FILE_DOES_NOT_EXIST = "File %1$s does not exist";
    public static final String MESSAGE_MODULE_ALREADY_EXIST_IN_TRACKER = "%1$s already exist in tracker. If you want "
            + "to overwrite data in this module, insert /overwrite true in the command";
    public static final String MESSAGE_MODULE_DOES_NOT_EXIST_IN_ARCHIVE = "%1$s not found in %2$s";
}
