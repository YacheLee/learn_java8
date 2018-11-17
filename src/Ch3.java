import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ch3 {
    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }
    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("learn_java8.iml"))) {
            return p.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println(oneLine);
        System.out.println(twoLine);
    }
}