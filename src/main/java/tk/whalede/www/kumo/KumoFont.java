package tk.whalede.www.kumo;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.kennycason.kumo.exception.KumoException;
import com.kennycason.kumo.font.FontWeight;

public class KumoFont {
    private static final int DEFAULT_WEIGHT = 10;

    private final Font font;

    public KumoFont(final String type, final FontWeight weight) {
        this.font = new Font("ProggyClean",Font.BOLD,14);
    }

    public KumoFont(final Font font) {
        this.font = font;
    }

    public KumoFont(final File file) throws FontFormatException {
        this(buildAndRegisterFont(file));
    }

    public KumoFont(final InputStream inputStream) throws FontFormatException {
        this(buildAndRegisterFont(inputStream));
    }

    private static Font buildAndRegisterFont(final File file) throws FontFormatException {
        try {
            final Font font = Font.createFont(Font.TRUETYPE_FONT, file);
            registerFont(font);
            return font;

        } catch (IOException e) {
            throw new KumoException(e.getMessage(), e);
        }
    }

    private static Font buildAndRegisterFont(final InputStream inputStream) throws FontFormatException {
        try {
            final Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            registerFont(font);
            return font;

        } catch (IOException e) {
            throw new KumoException(e.getMessage(), e);
        }
    }

    private static void registerFont(final Font font) {
        final GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsEnvironment.registerFont(font);
    }

    public Font getFont() {
        return this.font;
    }

}