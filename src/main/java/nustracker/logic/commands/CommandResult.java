package nustracker.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;

    /** Help window should be shown to the user. */
    private final boolean showHelp;

    /** Settings window should be shown to the user */
    private final boolean showSettings;

    /** The application should exit. */
    private final boolean exit;

    /** The student list should be displayed. */
    private final boolean toggleStudents;

    /** The event list should be displayed. */
    private final boolean toggleEvents;
    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit,
                         boolean showSettings, boolean toggleStudents, boolean toggleEvents) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.showSettings = showSettings;
        this.exit = exit;

        // Cannot toggle both the student and event list at the same time.
        if (toggleStudents || toggleEvents) {
            assert toggleStudents != toggleEvents;
        }

        this.toggleStudents = toggleStudents;
        this.toggleEvents = toggleEvents;
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser,
                false, false, false, false, false);
    }

    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    public boolean isShowHelp() {
        return showHelp;
    }

    public boolean isShowSettings() {
        return showSettings;
    }

    public boolean isExit() {
        return exit;
    }

    public boolean isToggleStudents() {
        return toggleStudents;
    }

    public boolean isToggleEvents() {
        return toggleEvents;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CommandResult)) {
            return false;
        }

        CommandResult otherCommandResult = (CommandResult) other;
        return feedbackToUser.equals(otherCommandResult.feedbackToUser)
                && showHelp == otherCommandResult.showHelp
                && showSettings == otherCommandResult.showSettings
                && exit == otherCommandResult.exit
                && toggleStudents == otherCommandResult.toggleStudents
                && toggleEvents == otherCommandResult.toggleEvents;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, showHelp, showSettings, exit, toggleStudents, toggleEvents);
    }

}
