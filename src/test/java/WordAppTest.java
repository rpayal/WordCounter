import exceptions.NotAValidWordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import utils.Translator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("A test case for word app")
public class WordAppTest {
    WordApp wordApp;

    @BeforeEach
    public void setup() {
        wordApp = new WordApp(new Translator());
    }

    @Test
    @DisplayName("throws NotAValidWordException for words containing non alphanumeric.")
    @Order(1)
    public void notAValidWord() {
        NotAValidWordException thrown = assertThrows(
                NotAValidWordException.class,
                () -> wordApp.addWord("hello 1-"),
                "Expected exception, but it didn't"
        );

        assertTrue(thrown.getMessage().contains(wordApp.WORD_CAN_ONLY_CONTAIN_ALPHANUMERIC_CHARACTERS));
    }
}