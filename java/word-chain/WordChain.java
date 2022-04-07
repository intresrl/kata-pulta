import java.io.BufferedReader;
import java.io.FileReader;

public class WordChain {
    String firstWord="cat";
    String lastWord="dog";
    public static void main(String []args) throws Exception{
        try(BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
        }

        System.out.println("ciao");
    }
}
