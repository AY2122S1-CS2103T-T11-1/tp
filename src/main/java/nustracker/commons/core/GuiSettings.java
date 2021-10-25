package nustracker.commons.core;

import java.awt.Point;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Serializable class that contains the GUI settings.
 * Guarantees: immutable.
 */
public class GuiSettings implements Serializable {

    private static final double DEFAULT_HEIGHT = 600;
    private static final double DEFAULT_WIDTH = 740;
    private static final String DEFAULT_GLOW_HEX_CODE = "#E9AFFF";

    private final double windowWidth;
    private final double windowHeight;
    private final Point windowCoordinates;
    private final boolean isLightTheme;
    private final String glowHexCode;

    /**
     * Constructs a {@code GuiSettings} with the default height, width and position.
     */
    public GuiSettings() {
        windowWidth = DEFAULT_WIDTH;
        windowHeight = DEFAULT_HEIGHT;
        glowHexCode = DEFAULT_GLOW_HEX_CODE;
        isLightTheme = true;
        windowCoordinates = null; // null represent no coordinates
    }

    /**
     * Constructs a {@code GuiSettings} with the specified height, width and position.
     */
    public GuiSettings(double windowWidth, double windowHeight, int xPosition, int yPosition, boolean isLightMode,
                       String glowHexCode) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.glowHexCode = glowHexCode;
        this.isLightTheme = isLightMode;
        windowCoordinates = new Point(xPosition, yPosition);
    }

    public double getWindowWidth() {
        return windowWidth;
    }

    public double getWindowHeight() {
        return windowHeight;
    }

    public Point getWindowCoordinates() {
        return windowCoordinates != null ? new Point(windowCoordinates) : null;
    }

    public String getGlowHexCode() {
        return glowHexCode;
    }

    public boolean getIsLightTheme() {
        return isLightTheme;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof GuiSettings)) { //this handles null as well.
            return false;
        }

        GuiSettings o = (GuiSettings) other;

        return windowWidth == o.windowWidth
                && windowHeight == o.windowHeight
                && isLightTheme == o.isLightTheme
                && Objects.equals(glowHexCode, o.getGlowHexCode())
                && Objects.equals(windowCoordinates, o.windowCoordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(windowWidth, windowHeight, windowCoordinates, glowHexCode, isLightTheme);
    }

    @Override
    public String toString() {
        String sb = "Width : " + windowWidth + "\n"
                    + "Height : " + windowHeight + "\n"
                    + "Position : " + windowCoordinates + "\n"
                    + "Using light theme?: " + isLightTheme + "\n"
                    + "Color: " + glowHexCode;
        return sb;
    }
}
