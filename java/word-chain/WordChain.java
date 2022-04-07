


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class WordChain {
    static String firstWord="cat";
    static String lastWord="dog";
    
    public static void main(String []args) throws Exception{

        String everything;

        extracted(firstWord.length());


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

    private static List<String> getGraph(List<String> words, String startingWord) {
        words.forEach(word -> {
            int mismatchCount = 0;

            for (int i = 0; i < word.length(); i++) {
                mismatchCount = word.charAt(i) != startingWord.charAt(i) ? mismatchCount++ : mismatchCount;
                if (mismatchCount > 1) {

                }
            }
        });
    }
}
