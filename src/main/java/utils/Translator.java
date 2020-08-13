package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Translator {
    private static final String TRANSLATED_RESOURCE = "translations.properties";
    private static Properties translations = new Properties();

    public Translator() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(TRANSLATED_RESOURCE)) {
            translations.load(is);
        } catch (final IOException e) {
            throw new RuntimeException("Could not read: " + TRANSLATED_RESOURCE, e);
        }
    }

    public String translate(String toTranslate) {
        Object value = translations.get(toTranslate);
        String translatedWord;
        if (value != null) {
            translatedWord = String.valueOf(value);
        }
        else {
            translatedWord = toTranslate;
        }
        return translatedWord;
    }
}
