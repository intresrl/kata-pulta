import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordChain {
    static String firstWord="cat";
    static String lastWord="dog";

    public boolean subword(String first, String second) {
        int mismatchCount = 0;
        for (int i = 0; i < first.length(); i++) {
            mismatchCount = first.charAt(i) != second.charAt(i) ? mismatchCount + 1 : mismatchCount;
            if (mismatchCount > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String []args) throws Exception{

        String everything;
        List<String> words = List.of("ciao", "mondo");
        extracted(firstWord.length(), words);

    }

    private static void extracted(int lenght, List<String> words) throws IOException {
        String everything;
        try(BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            for (String word : words) {
                if (word.length() == lenght) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
            }
            everything = sb.toString();
        }
    }

    private Tree getGraph(List<String> words, String startingWord) {
        Tree newTree = new Tree(startingWord);
        Node root = newTree.getRoot();
        words.forEach(word -> {
            int mismatchCount = 0;

            if (subword(startingWord, word)) {
                Node childNode = new Node(word);
                root.addChild(childNode);
            }
        });
        return newTree;
    }
}
