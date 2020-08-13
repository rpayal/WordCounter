package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("A test case for translator")
public class TranslatorTest {

    Translator translator = new Translator();

    @Test
    @DisplayName("test word translation")
    public void translate() {
        assertEquals("hello", translator.translate("hello"));
        assertEquals("hello", translator.translate("holla"));

        // word not in store
        assertEquals("Park", translator.translate("Park"));
    }
}