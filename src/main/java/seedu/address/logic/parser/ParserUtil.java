package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.FLAG_TAG;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.lecture.LectureName;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.module.ModuleName;
import seedu.address.model.tag.Tag;
import seedu.address.model.video.VideoName;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Tag parseSingleTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(String.format(Tag.MESSAGE_CONSTRAINTS, trimmedTag));
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses a {@code String} of comma-separated tags into a {@code Set} of {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Set<Tag> parseMultiTags(String tags) throws ParseException {
        requireNonNull(tags);
        if (tags.trim().equals("")) {
            return new HashSet<>();
        }

        String[] arrayOfTags = tags.split(",");

        List<String> listOfUnvalidTagName = Arrays.stream(arrayOfTags)
                .map(tag -> tag.trim())
                .filter(trimmedTag -> !Tag.isValidTagName(trimmedTag))
                .collect(Collectors.toList());

        if (listOfUnvalidTagName.size() > 0) {
            throw new ParseException(String.format(Tag.MESSAGE_CONSTRAINTS,
                    String.join(", ", listOfUnvalidTagName)));
        }

        List<Tag> listOfTags = Arrays.stream(arrayOfTags)
                .map(tag -> tag.trim())
                .map(trimmedtag -> new Tag(trimmedtag))
                .collect(Collectors.toList());

        return new HashSet<>(listOfTags);
    }

    /**
     * Parses a {@code List<String>} of tag descriptions into a {@code Set} of {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Set<Tag> parseMultiTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);

        List<String> listOfUnvalidTagName = tags.stream()
                .map(tag -> tag.trim())
                .filter(trimmedTag -> !Tag.isValidTagName(trimmedTag))
                .collect(Collectors.toList());

        if (listOfUnvalidTagName.size() > 0) {
            throw new ParseException(String.format(Tag.MESSAGE_CONSTRAINTS,
                    String.join(", ", listOfUnvalidTagName)));
        }

        List<Tag> listOfTags = tags.stream()
                .map(tag -> tag.trim())
                .map(trimmedtag -> new Tag(trimmedtag))
                .collect(Collectors.toList());

        return new HashSet<>(listOfTags);
    }

    /**
     * Parses a {@code String moduleCode} into a {@code ModuleCode}.<p>
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code moduleCode} is invalid.
     */
    public static ModuleCode parseModuleCode(String moduleCode) throws ParseException {
        requireNonNull(moduleCode);
        String trimmedModuleCode = moduleCode.trim();
        if (!ModuleCode.isValidCode(trimmedModuleCode)) {
            throw new ParseException(ModuleCode.MESSAGE_CONSTRAINTS);
        }
        return new ModuleCode(trimmedModuleCode);
    }

    /**
     * Parses a {@code String moduleName} into a {@code ModuleName}.<p>
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code moduleName} is invalid.
     */
    public static ModuleName parseModuleName(String moduleName) throws ParseException {
        requireNonNull(moduleName);
        String trimmedModuleName = moduleName.trim();
        if (!ModuleName.isValidName(trimmedModuleName)) {
            throw new ParseException(ModuleName.MESSAGE_CONSTRAINTS);
        }
        return new ModuleName(trimmedModuleName);
    }

    /**
     * Parses a {@code String lectureName} into a {@code LectureName}.<p>
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code lectureName} is invalid.
     */
    public static LectureName parseLectureName(String lectureName) throws ParseException {
        requireNonNull(lectureName);
        String trimmedLectureName = lectureName.trim();
        if (!LectureName.isValidName(trimmedLectureName)) {
            throw new ParseException(LectureName.MESSAGE_CONSTRAINTS);
        }
        return new LectureName(trimmedLectureName);
    }

    /**
     * Parses a {@code String videoName} into a {@code VideoName}.<p>
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code videoName} is invalid.
     */
    public static VideoName parseVideoName(String videoName) throws ParseException {
        requireNonNull(videoName);
        String trimmedVideoName = videoName.trim();
        if (!VideoName.isValidName(trimmedVideoName)) {
            throw new ParseException(VideoName.MESSAGE_CONSTRAINTS);
        }
        return new VideoName(trimmedVideoName);
    }

    /**
     * Parses a {@code String args} into a {@code Flag} if any.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static Flag parseFlag(String args) {
        requireNonNull(args);
        String trimmedArgs = args.trim();
        String[] argsArr = trimmedArgs.split(" ");
        if (hasFlag(argsArr)) {
            return new Flag(argsArr[argsArr.length - 1]);
        }
        return null;
    }

    private static boolean hasFlag(String[] argsArr) {
        return new Flag(argsArr[argsArr.length - 1]).equals(FLAG_TAG);
    }

}
