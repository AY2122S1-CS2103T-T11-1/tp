package nustracker.ui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.TitledPane;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import nustracker.commons.core.LogsCenter;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {

    public static final String USER_GUIDE_URL = "https://ay2122s1-cs2103t-t11-1.github.io/tp/UserGuide.html";
    public static final String HELP_MESSAGE = "Refer to the user guide: ";
    public static final String COPY_LINK_TEXT = "Open User Guide";

    // STUDENT COMMANDS
    public static final String ADD_COMMAND = "add";
    public static final String ADD_COMMAND_EXAMPLE = " " + ADD_COMMAND
            + " n/STUDENT_NAME m/MAJOR id/STUDENT_ID y/YEAR p/NUMBER e/EMAIL";

    public static final String STUDENTS_COMMAND = "students";
    public static final String STUDENTS_COMMAND_EXAMPLE = " " + STUDENTS_COMMAND;

    public static final String EDIT_COMMAND = "edit";
    public static final String EDIT_COMMAND_EXAMPLE = " " + EDIT_COMMAND
            + " [id/ID_OF_STUDENT_TO_EDIT] [n/NAME] [m/MAJOR] [id/NEW_STUDENT_ID] [y/YEAR] [p/PHONE] [e/EMAIL]";

    public static final String DELETE_COMMAND = "delete";
    public static final String DELETE_COMMAND_EXAMPLE1 = " " + DELETE_COMMAND + " id/STUDENT_ID";

    public static final String FILTER_COMMAND = "filter";
    public static final String FILTER_COMMAND_EXAMPLE1 = " " + FILTER_COMMAND
            + " n/STUDENT_NAME [MORE_STUDENT_NAMES]...";
    public static final String FILTER_COMMAND_EXAMPLE2 = " " + FILTER_COMMAND
            + " id/STUDENT_ID [MORE_STUDENT_IDS]...";
    public static final String FILTER_COMMAND_EXAMPLE3 = " " + FILTER_COMMAND
            + " m/MAJOR [MORE_MAJORS]...";
    public static final String FILTER_COMMAND_EXAMPLE4 = " " + FILTER_COMMAND
            + " y/YEAR [MORE_YEARS]...";
    public static final String FILTER_COMMAND_EXAMPLE5 = " " + FILTER_COMMAND
            + " ev/EVENT_NAME";
    public static final String BLACKLIST_COMMAND = "blacklist";
    public static final String BLACKLIST_COMMAND_EXAMPLE = " " + BLACKLIST_COMMAND
            + " id/STUDENT_ID ev/EVENT";

    public static final String WHITELIST_COMMAND = "whitelist";
    public static final String WHITELIST_COMMAND_EXAMPLE = " " + WHITELIST_COMMAND
            + " id/STUDENT_ID ev/EVENT";

    // EVENT COMMANDS
    public static final String CREATE_COMMAND = "create";
    public static final String CREATE_COMMAND_EXAMPLE = " " + CREATE_COMMAND
            + " n/EVENT_NAME d/EVENT_DATE t/EVENT_TIME";

    public static final String EVENTS_COMMAND = "events";
    public static final String EVENTS_COMMAND_EXAMPLE = " " + EVENTS_COMMAND;

    public static final String ENROLL_COMMAND = "enroll";
    public static final String ENROLL_COMMAND_EXAMPLE = " " + ENROLL_COMMAND
            + " id/STUDENT_ID ev/EVENT_NAME";

    public static final String REMOVE_COMMAND = "remove";
    public static final String REMOVE_COMMAND_EXAMPLE = " " + REMOVE_COMMAND
            + " id/STUDENT_ID ev/EVENT_NAME";

    public static final String DELETE_COMMAND_EXAMPLE2 = " " + DELETE_COMMAND
            + " ev/EVENT_NAME";

    // OTHER COMMANDS
    public static final String HELP_COMMAND = "help";
    public static final String HELP_COMMAND_EXAMPLE = " " + HELP_COMMAND;

    public static final String SETTINGS_COMMAND = "settings";
    public static final String SETTINGS_COMMAND_EXAMPLE = " " + SETTINGS_COMMAND;

    public static final String EXPORT_COMMAND = "export";
    public static final String EXPORT_COMMAND_EXAMPLE = " " + EXPORT_COMMAND
            + " fn/FILE_NAME;";

    public static final String EXIT_COMMAND = "exit";
    public static final String EXIT_COMMAND_EXAMPLE = " " + EXIT_COMMAND;


    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";

    //Main components
    @FXML
    private VBox helpWindow;
    @FXML
    private TitledPane titledPane;
    @FXML
    private GridPane firstGridPane;
    @FXML
    private GridPane secondGridPane;
    @FXML
    private GridPane thirdGridPane;
    @FXML
    private Text helpMessage;

    //Student Commands
    @FXML
    private Text addCommandExample;
    @FXML
    private Text studentsCommandExample;
    @FXML
    private Text editCommandExample;
    @FXML
    private Text deleteCommandExample1;
    @FXML
    private Text filterCommandExample1;
    @FXML
    private Text filterCommandExample2;
    @FXML
    private Text filterCommandExample3;
    @FXML
    private Text filterCommandExample4;
    @FXML
    private Text filterCommandExample5;
    @FXML
    private Text blacklistCommandExample;
    @FXML
    private Text whitelistCommandExample;

    // EVENT COMMANDS
    @FXML
    private Text createCommandExample;
    @FXML
    private Text eventsCommandExample;
    @FXML
    private Text enrollCommandExample;
    @FXML
    private Text removeCommandExample;
    @FXML
    private Text deleteCommandExample2;

    // OTHER COMMANDS
    @FXML
    private Text helpCommandExample;
    @FXML
    private Text settingsCommandExample;
    @FXML
    private Text exportCommandExample;
    @FXML
    private Text exitCommandExample;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);

        helpMessage.setText(HELP_MESSAGE);

        // STUDENTS COMMANDS
        addCommandExample.setText(ADD_COMMAND_EXAMPLE);
        studentsCommandExample.setText(STUDENTS_COMMAND_EXAMPLE);
        editCommandExample.setText(EDIT_COMMAND_EXAMPLE);
        deleteCommandExample1.setText(DELETE_COMMAND_EXAMPLE1);
        filterCommandExample1.setText(FILTER_COMMAND_EXAMPLE1);
        filterCommandExample2.setText(FILTER_COMMAND_EXAMPLE2);
        filterCommandExample3.setText(FILTER_COMMAND_EXAMPLE3);
        filterCommandExample4.setText(FILTER_COMMAND_EXAMPLE4);
        filterCommandExample5.setText(FILTER_COMMAND_EXAMPLE5);
        blacklistCommandExample.setText(BLACKLIST_COMMAND_EXAMPLE);
        whitelistCommandExample.setText(WHITELIST_COMMAND_EXAMPLE);

        // EVENT COMMANDS
        createCommandExample.setText(CREATE_COMMAND_EXAMPLE);
        eventsCommandExample.setText(EVENTS_COMMAND_EXAMPLE);
        enrollCommandExample.setText(ENROLL_COMMAND_EXAMPLE);
        removeCommandExample.setText(REMOVE_COMMAND_EXAMPLE);
        deleteCommandExample2.setText(DELETE_COMMAND_EXAMPLE2);

        // OTHER COMMANDS
        helpCommandExample.setText(HELP_COMMAND_EXAMPLE);
        settingsCommandExample.setText(SETTINGS_COMMAND_EXAMPLE);
        exportCommandExample.setText(EXPORT_COMMAND_EXAMPLE);
        exitCommandExample.setText(EXIT_COMMAND_EXAMPLE);

    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void openUserGuide() {
        Desktop desktop = java.awt.Desktop.getDesktop();

        try {
            URI url = new URI(USER_GUIDE_URL);
            desktop.browse(url);
        } catch (IOException | URISyntaxException e) {
            logger.log(Level.INFO, "The user guide could not be opened!");
        }
    }

    // STUDENT COMMANDS ================================================================================================
    /**
     * Copies the AddCommand to the user guide to the clipboard.
     */
    @FXML
    private void copyAddCommand() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(ADD_COMMAND_EXAMPLE);
        clipboard.setContent(url);
    }

    /**
     * Copies the StudentsCommand to the user guide to the clipboard.
     */
    @FXML
    private void copyStudentsCommand() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(STUDENTS_COMMAND_EXAMPLE);
        clipboard.setContent(url);
    }

    /**
     * Copies the EditCommand to the user guide to the clipboard.
     */
    @FXML
    private void copyEditCommand() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(EDIT_COMMAND_EXAMPLE);
        clipboard.setContent(url);
    }

    /**
     * Copies the DeleteCommand1 to the user guide to the clipboard.
     */
    @FXML
    private void copyDeleteCommand1() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(DELETE_COMMAND_EXAMPLE1);
        clipboard.setContent(url);
    }

    /**
     * Copies the FilterCommand1 to the user guide to the clipboard.
     */
    @FXML
    private void copyFilterCommand1() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(FILTER_COMMAND_EXAMPLE1);
        clipboard.setContent(url);
    }

    /**
     * Copies the FilterCommand2 to the user guide to the clipboard.
     */
    @FXML
    private void copyFilterCommand2() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(FILTER_COMMAND_EXAMPLE2);
        clipboard.setContent(url);
    }

    /**
     * Copies the FilterCommand3 to the user guide to the clipboard.
     */
    @FXML
    private void copyFilterCommand3() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(FILTER_COMMAND_EXAMPLE3);
        clipboard.setContent(url);
    }

    /**
     * Copies the FilterCommand4 to the user guide to the clipboard.
     */
    @FXML
    private void copyFilterCommand4() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(FILTER_COMMAND_EXAMPLE4);
        clipboard.setContent(url);
    }

    /**
     * Copies the FilterCommand5 to the user guide to the clipboard.
     */
    @FXML
    private void copyFilterCommand5() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(FILTER_COMMAND_EXAMPLE5);
        clipboard.setContent(url);
    }

    /**
     * Copies the BlackListCommand to the user guide to the clipboard.
     */
    @FXML
    private void copyBlacklistCommand() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(BLACKLIST_COMMAND_EXAMPLE);
        clipboard.setContent(url);
    }

    /**
     * Copies the WhiteListCommand to the user guide to the clipboard.
     */
    @FXML
    private void copyWhitelistCommand() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(WHITELIST_COMMAND_EXAMPLE);
        clipboard.setContent(url);
    }

    // EVENT COMMANDS ================================================================================================
    /**
     * Copies the CreateCommand to the user guide to the clipboard.
     */
    @FXML
    private void copyCreateCommand() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(CREATE_COMMAND_EXAMPLE);
        clipboard.setContent(url);
    }

    /**
     * Copies the EventsCommand to the user guide to the clipboard.
     */
    @FXML
    private void copyEventsCommand() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(EVENTS_COMMAND);
        clipboard.setContent(url);
    }

    /**
     * Copies the EnrollCommand to the user guide to the clipboard.
     */
    @FXML
    private void copyEnrollCommand() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(ENROLL_COMMAND_EXAMPLE);
        clipboard.setContent(url);
    }

    /**
     * Copies the RemoveCommand to the user guide to the clipboard.
     */
    @FXML
    private void copyRemoveCommand() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(REMOVE_COMMAND_EXAMPLE);
        clipboard.setContent(url);
    }

    /**
     * Copies the DeleteCommand2 to the user guide to the clipboard.
     */
    @FXML
    private void copyDeleteCommand2() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(DELETE_COMMAND_EXAMPLE2);
        clipboard.setContent(url);
    }

    // OTHER COMMANDS ================================================================================================

    /**
     * Copies the HelpCommand to the user guide to the clipboard.
     */
    @FXML
    private void copyHelpCommand() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(HELP_COMMAND_EXAMPLE);
        clipboard.setContent(url);
    }

    /**
     * Copies the SettingsCommand to the user guide to the clipboard.
     */
    @FXML
    private void copySettingsCommand() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(SETTINGS_COMMAND_EXAMPLE);
        clipboard.setContent(url);
    }

    /**
     * Copies the ExportCommand to the user guide to the clipboard.
     */
    @FXML
    private void copyExportCommand() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(EXPORT_COMMAND_EXAMPLE);
        clipboard.setContent(url);
    }


    /**
     * Copies the ExitCommand to the user guide to the clipboard.
     */
    @FXML
    private void copyExitCommand() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(EXIT_COMMAND_EXAMPLE);
        clipboard.setContent(url);
    }

}
