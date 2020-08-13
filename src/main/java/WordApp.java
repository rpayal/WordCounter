import exceptions.NotAValidWordException;
import utils.Translator;
import utils.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordApp {
    public static final String WORD_CAN_ONLY_CONTAIN_ALPHANUMERIC_CHARACTERS = "Word can only contain alphanumeric characters.";
    private static Map<String, List<String>> wordStore = new HashMap<>();

    private Translator translator;

    public  WordApp(Translator translator) {
        this.translator = translator;
    }

    public void addWord(String wordToAdd) throws NotAValidWordException {
        if (! Validator.checkOnlyContainAlphanumeric(wordToAdd)) {
            throw new NotAValidWordException(WORD_CAN_ONLY_CONTAIN_ALPHANUMERIC_CHARACTERS);
        }
    }
}
