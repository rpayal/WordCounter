import exceptions.NotAValidWordException;
import utils.Translator;
import utils.Validator;

import java.util.*;

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
        String translatedWord = translator.translate(wordToAdd);
        if (! wordStore.containsKey(translatedWord))
            wordStore.put(translatedWord, new ArrayList<String>());

        wordStore.get(translatedWord).add(wordToAdd);
    }

    public int countWord(String countForWord) {
        Set<Map.Entry<String, List<String>>> entries = wordStore.entrySet();
        Optional<List<String>> mayFoundWord = wordStore.entrySet().stream()
                .filter(e -> countForWord.equals(e.getKey()))
                .map(Map.Entry::getValue)
                .findFirst();

        if (mayFoundWord.isPresent()) {
            return mayFoundWord.get().size();
        } else {
            return 0;
            //throw new WordNotExistException("Word " + countForWord + " not exist.");
        }
    }

    public static void main(String[] args) throws NotAValidWordException {
        String countForWord;
        if (args.length == 0) {
            System.out.println("No arguments found. Use bellow syntax;");
            System.out.println("java WordApp <list of words to add> <word to found count, last word in list used for count>");
            System.out.println("java WordApp flower flor blume hello flower");
            return;
        } else {
            countForWord = args[args.length - 1];
        }

        WordApp wordApp = new WordApp(new Translator());
        for (String word : args) {
            wordApp.addWord(word);
        }
        System.out.println("Count for word ["+countForWord+"] - " + wordApp.countWord(countForWord));
        return;
    }
}
