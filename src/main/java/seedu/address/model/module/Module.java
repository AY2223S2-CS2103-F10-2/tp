package seedu.address.model.module;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javafx.collections.ObservableList;
import seedu.address.model.lecture.Lecture;
import seedu.address.model.lecture.LectureName;
import seedu.address.model.lecture.ReadOnlyLecture;
import seedu.address.model.lecture.UniqueLectureList;
import seedu.address.model.tag.Tag;

/**
 * Represents a module in the tracker.
 * Guarantees: details are not null, field values are validated, immutable with exception of lecture list.
 */
public class Module implements ReadOnlyModule {

    private final ModuleCode code;

    private final ModuleName name;

    private final Set<Tag> tags = new HashSet<>();

    private final UniqueLectureList lectures = new UniqueLectureList();

    /**
     * Every field must be not null.
     *
     * @param code The module's code.
     */
    public Module(ModuleCode code) {
        requireAllNonNull(code);
        this.code = code;
        this.name = new ModuleName(null);
    }

    /**
     * Every field must be not null.
     *
     * @param code The module's code.
     * @param name The name of the module.
     * @param tags The tags applied to the module.
     * @param lectures The lectures of the module.
     */
    public Module(ModuleCode code, ModuleName name, Set<Tag> tags, List<Lecture> lectures) {
        requireAllNonNull(code, name, tags, lectures);
        this.code = code;
        this.name = name;
        this.tags.addAll(tags);
        this.lectures.setLectures(lectures);
    }

    @Override
    public ModuleCode getCode() {
        return code;
    }

    @Override
    public ModuleName getName() {
        return name;
    }

    @Override
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    @Override
    public ObservableList<? extends ReadOnlyLecture> getLectureList() {
        return lectures.asUnmodifiableObservableList();
    }

    @Override
    public ReadOnlyLecture getLecture(LectureName name) {
        return getLectureList()
                .stream()
                .filter((l) -> l.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean hasLecture(ReadOnlyLecture lecture) {
        requireNonNull(lecture);
        return lectures.contains((Lecture) lecture);
    }

    @Override
    public boolean isSameModule(Module other) {
        if (other == this) {
            return true;
        }

        return other != null
                && other.getCode().equals(getCode());
    }

    /**
     * Adds a lecture to the module.
     * The lecture must not already exist in the module.
     */
    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
    }

    /**
     * Replaces the given lecture {@code target} in the list with {@code editedLecture}.
     * {@code target} must exist in the module.
     * The lecture of {@code editedLecture} must not be the same as another existing lecture in the module.
     */
    public void setLecture(ReadOnlyLecture target, Lecture editedLecture) {
        requireNonNull(editedLecture);

        lectures.setLecture((Lecture) target, editedLecture);
    }

    /**
     * Removes {@code key} from this {@code Module}.
     * {@code key} must exist in the module.
     * @param key
     */
    public void removeLecture(ReadOnlyLecture key) {
        lectures.remove((Lecture) key);
    }

    /**
     * Returns true if both modules have the same fields.
     * This defines a stronger notion of equality between two modules.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Module)) {
            return false;
        }

        Module otherModule = (Module) other;
        return otherModule.getCode().equals(getCode())
                && otherModule.getName().equals(getName())
                && otherModule.getTags().equals(getTags())
                && otherModule.getLectureList().equals(getLectureList());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(code, name, tags, lectures);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getCode());

        if (!name.isEmpty()) {
            builder.append("; Name: ")
                .append(getName());
        }

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }

        ObservableList<? extends ReadOnlyLecture> lectures = getLectureList();
        if (!lectures.isEmpty()) {
            builder.append("; Lectures: ");
            lectures.forEach(builder::append);
        }

        return builder.toString();
    }
}
