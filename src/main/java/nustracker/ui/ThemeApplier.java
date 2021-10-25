package nustracker.ui;

/**
 * A component that is responsible for applying themes to the various UI components.
 */
public class ThemeApplier {

    private final MainWindow mainWindow;
    private final HelpWindow helpWindow;
    private final SettingsWindow settingsWindow;
    private Theme currentTheme;

    /**
     * An enum that represents the themes of the application.
     */
    public enum Theme {
        DARK {
            @Override
            public String toString() {
                return "view/DarkTheme.css";
            }
        },
        LIGHT {
            @Override
            public String toString() {
                return "view/LightTheme.css";
            }
        }
    }

    /***
     * Instantiates a new ThemeApplier instance.
     */
    public ThemeApplier(MainWindow mainWindow, HelpWindow helpWindow, SettingsWindow settingsWindow,
                        boolean isLightTheme) {
        this.mainWindow = mainWindow;
        this.helpWindow = helpWindow;
        this.settingsWindow = settingsWindow;
        currentTheme = isLightTheme ? Theme.LIGHT : Theme.DARK;
    }

    /**
     * Applies a theme on startup, as defined in the preferences.json file.
     */
    public void applyOnStartUp() {
        if (currentTheme == Theme.DARK) {
            applyDarkTheme();
        }
    }

    /**
     * Applies the Light Theme to the application.
     */
    private void applyLightTheme() {
        currentTheme = Theme.LIGHT;

        removeTheme(Theme.DARK);
        applyTheme(Theme.LIGHT);
    }

    /**
     * Applies the Dark Theme to the application.
     */
    private void applyDarkTheme() {
        currentTheme = Theme.DARK;

        removeTheme(Theme.LIGHT);
        applyTheme(Theme.DARK);
    }

    /**
     * Removes the theme that corresponds to the enum passed as an argument.
     *
     * @param removeTheme The theme to be removed
     */
    private void removeTheme(Theme removeTheme) {
        mainWindow.getRoot().getScene().getStylesheets().remove(removeTheme.toString());
        helpWindow.getRoot().getScene().getStylesheets().remove(removeTheme.toString());
        settingsWindow.getRoot().getScene().getStylesheets().remove(removeTheme.toString());
    }

    /**
     * Applies the theme that corresponds to the enum passed as an argument.
     *
     * @param addTheme The Theme to be applied
     */
    private void applyTheme(Theme addTheme) {
        mainWindow.getRoot().getScene().getStylesheets().add(addTheme.toString());
        helpWindow.getRoot().getScene().getStylesheets().add(addTheme.toString());
        settingsWindow.getRoot().getScene().getStylesheets().add(addTheme.toString());
    }

    /**
     * Switches the current theme of the application.
     */
    public void switchTheme() {
        switch (currentTheme) {
        case LIGHT:
            applyDarkTheme();
            break;
        case DARK:
            applyLightTheme();
            break;
        default:
            //Don't do anything here
        }
    }

    /**
     * Returns a boolean that corresponds to whether the application is using the light theme or not.
     *
     * @return True if using Light Theme, false if using Dark Theme.
     */
    public boolean isLightTheme() {
        return currentTheme == Theme.LIGHT;
    }

}
