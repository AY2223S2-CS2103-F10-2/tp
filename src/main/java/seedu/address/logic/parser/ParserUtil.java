package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.lecture.Lecture;
import seedu.address.model.lecture.LectureName;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.module.ModuleName;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.video.VideoName;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

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
        List<Tag> listOfTags = tags.stream()
                .map(tag -> tag.trim())
                .map(trimmedtag -> new Tag(trimmedtag))
                .collect(Collectors.toList());

        for (Tag tag : listOfTags) {
            if (!Tag.isValidTagName(tag.tagName)) {
                throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
            }
        }
        return new HashSet<>(listOfTags);
    }

    // TODO: Consider removing this
    /**
     * Parses a {@code String moduleCode} into a {@code module}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code moduleCode} is invalid.
     */
    public static Module parseModule(String moduleCode) throws ParseException {
        ModuleCode parsedModuleCode = parseModuleCode(moduleCode);
        return new Module(parsedModuleCode);
    }

    // TODO: Consider removing this
    /**
     * Parses a {@code String lectureName} into a {@code lecture}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code lectureName} is invalid.
     */
    public static Lecture parseLecture(String lectureName) throws ParseException {
        requireNonNull(lectureName);
        String trimmedLecture = lectureName.trim();
        if (!LectureName.isValidName(trimmedLecture)) {
            throw new ParseException(LectureName.MESSAGE_CONSTRAINTS);
        }
        return new Lecture(new LectureName(trimmedLecture));
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
     */
    public static ModuleName parseModuleName(String moduleName) {
        requireNonNull(moduleName);
        String trimmedModuleName = moduleName.trim();
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
}
