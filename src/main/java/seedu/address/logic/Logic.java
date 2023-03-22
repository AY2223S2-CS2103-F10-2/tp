package seedu.address.logic;

import java.nio.file.Path;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Level;
import seedu.address.model.ReadOnlyTracker;
import seedu.address.model.lecture.ReadOnlyLecture;
import seedu.address.model.module.ReadOnlyModule;
import seedu.address.model.video.Video;

/**
 * API of the Logic component
 */
public interface Logic {

    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the Tracker.
     *
     * @see seedu.address.model.Model#getTracker()
     */
    ReadOnlyTracker getTracker();

    /** Returns an unmodifiable view of the filtered list of modules */
    ObservableList<? extends ReadOnlyModule> getFilteredModuleList();

    /**
     * Returns an unmodifiable view of the filtered list of lectures if a lecture list is selected. Otherwise,
     * returns null.
     */
    ObservableList<? extends ReadOnlyLecture> getFilteredLectureList();

    /**
     * Returns an unmodifiable view of the filtered list of videos if a video list is selected. Otherwise,
     * returns null.
     */
    ObservableList<? extends Video> getFilteredVideoList();

    /**
     * Returns the user prefs' tracker file path.
     */
    Path getTrackerFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the last list type to displayed to user.
     */
    Level getLastListLevel();

}
