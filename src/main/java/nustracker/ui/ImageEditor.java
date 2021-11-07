package nustracker.ui;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 * A UI class that behaves like a formatter and editor for student profile pictures.
 */
class ImageEditor {

    public static final Color DEFAULT_COLOR = Color.web("#e9afff");
    private final Circle profilePictureHolder;

    /**
     * Instantiates a ImageEditor instance.
     *
     * @param profilePictureHolder The holder to be modified.
     */
    public ImageEditor(Circle profilePictureHolder) {
        this.profilePictureHolder = profilePictureHolder;
    }

    /**
     * Sets up the profile picture holder by settings its properties (like border radius) and border
     * glow.
     *
     * @param hexCode The color hex code of the glow.
     */
    public void setUpHolder(String hexCode) {
        formattingHolder(hexCode);
        setGlowEffect(hexCode);
    }

    /**
     * Formats the properties of the circle: radius width, stroke color, and stroke width.
     *
     * @param hexCode The color hex code of the stroke color.
     */
    public void formattingHolder(String hexCode) {
        profilePictureHolder.setRadius(60);
        profilePictureHolder.setStrokeWidth(4);

        if (ImageEditor.isValidColorHexCode(hexCode)) {
            profilePictureHolder.setStroke(Color.web(hexCode));
        } else {
            profilePictureHolder.setStroke(DEFAULT_COLOR);
        }
    }

    /**
     * Creates the glow effect, that surrounds the profile picture.
     *
     * @param hexCode The color hex code of the glow.
     */
    private void setGlowEffect(String hexCode) {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setWidth(100);
        borderGlow.setHeight(100);

        if (ImageEditor.isValidColorHexCode(hexCode)) {
            borderGlow.setColor(Color.web(hexCode));
        } else {
            borderGlow.setColor(DEFAULT_COLOR);
        }

        profilePictureHolder.setEffect(borderGlow);
    }

    /**
     * Fills the profile picture holder, with the {@code ImagePattern} that contains the image of the student.
     *
     * @param profilePicture The image (profile picture) of the student.
     */
    public void fillImage(Image profilePicture) throws NullPointerException {
        assert profilePicture != null;

        profilePictureHolder.setFill(new ImagePattern(profilePicture));
    }

    /**
     * Checks if the given string color hex code is a valid one or not.
     *
     * @param colorHexCode The string color hex code
     * @return True if valid, false if not.
     */
    public static boolean isValidColorHexCode(String colorHexCode) {
        if (colorHexCode == null) {
            return false;
        }

        return colorHexCode.matches("[#][0-9a-fA-F]{6}");
    }

}
