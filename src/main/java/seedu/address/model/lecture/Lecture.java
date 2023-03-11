package seedu.address.model.lecture;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javafx.collections.ObservableList;
import seedu.address.model.tag.Tag;
import seedu.address.model.video.UniqueVideoList;
import seedu.address.model.video.Video;
import seedu.address.model.video.VideoName;

/**
 * Represents a lecture of a module that is in the tracker..
 * Guarantees: details are present and not null, field values are validated, immutable with the exception of video list.
 */
public class Lecture implements ReadOnlyLecture {

    private final LectureName name;

    private final Set<Tag> tags = new HashSet<>();

    private final UniqueVideoList videos = new UniqueVideoList();

    /**
     * Constructs a {@code Lecture}.
     *
     * @param name The name of the lecture.
     * @param tags The tags applied to the module.
     */
    public Lecture(LectureName name, Set<Tag> tags, List<Video> videos) {
        requireAllNonNull(name, tags, videos);
        this.name = name;
        this.tags.addAll(tags);
        this.videos.setVideos(videos);
    }

    @Override
    public LectureName getName() {
        return name;
    }

    @Override
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    @Override
    public ObservableList<Video> getVideoList() {
        return videos.asUnmodifiableObservableList();
    }

    @Override
    public Video getVideo(VideoName name) {
        return getVideoList()
                .stream()
                .filter((v) -> v.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean hasVideo(Video video) {
        requireNonNull(video);
        return videos.contains(video);
    }

    @Override
    public boolean isSameLecture(Lecture other) {
        if (other == this) {
            return true;
        }

        return other != null
                && other.getName().equals(getName());
    }

    /**
     * Adds a video to the lecture.
     * The video must not already exist in the lecture.
     */
    public void addVideo(Video video) {
        videos.add(video);
    }

    /**
     * Replaces the given video {@code target} in the list with {@code editedVideo}.
     * {@code target} must exist in the lecture.
     * The video of {@code editedVideo} must not be the same as another existing video in the lecture.
     */
    public void setVideo(Video target, Video editedVideo) {
        requireNonNull(editedVideo);

        videos.setVideo(target, editedVideo);
    }

    /**
     * Removes {@code key} from this {@code Lecture}.
     * {@code key} must exist in the lecture.
     * @param key
     */
    public void removeVideo(Video key) {
        videos.remove(key);
    }

    /**
     * Returns true if both lectures have the same fields.
     * This defines a stronger notion of equality between two lectures.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Lecture)) {
            return false;
        }

        Lecture otherLecture = (Lecture) other;
        return otherLecture.getName().equals(getName())
                && otherLecture.getTags().equals(getTags())
                && otherLecture.getVideoList().equals(getVideoList());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, tags, videos);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }

        List<Video> videos = getVideoList();
        if (!videos.isEmpty()) {
            builder.append("; Videos: ");
            videos.forEach(builder::append);
        }

        return builder.toString();
    }
}
