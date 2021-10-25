package nustracker.logic.commands;

import nustracker.model.Model;

/**
 * Format full help instructions for every command for display.
 */
public class SettingsCommand extends Command {

    public static final String COMMAND_WORD = "settings";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program settings.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_SETTINGS_MESSAGE = "Opened settings window.";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(SHOWING_SETTINGS_MESSAGE, false, false, true, false, false);
    }
}
