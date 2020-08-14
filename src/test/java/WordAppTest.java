import exceptions.NotAValidWordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import utils.Translator;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("return 0 for a non existing word on finding it's count.")
    @Order(2)
    public void checkWordApp_count_wrong_word_scenario() {
        assertEquals(0, wordApp.countWord("Hello"));
    }

    @Test
    @DisplayName("adding words and then find count for a word.")
    @Order(3)
    public void checkWordApp_ideal_scenario() throws NotAValidWordException {
        wordApp.addWord("flower");
        wordApp.addWord("flor");
        wordApp.addWord("blume");

        assertEquals(3, wordApp.countWord("flower"));
    }

    @Test
    @DisplayName("do not allow duplicate words in word store.")
    @Order(3)
    public void checkWordApp_no_duplicate_scenario() throws NotAValidWordException {
        wordApp.addWord("flower");
        wordApp.addWord("flor");
        wordApp.addWord("blume");
        wordApp.addWord("flower");

        assertEquals(3, wordApp.countWord("flower"));
    }
}