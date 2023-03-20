package seedu.address.commons.core;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
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

    public static final String EMPTY_TAGS = "No tag is provided";
}
