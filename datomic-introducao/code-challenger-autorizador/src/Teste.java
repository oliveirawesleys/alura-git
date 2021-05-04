import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Teste {

    public static void main(String[] args) {
        String path = "C:/Users/olive/Desktop/operations.json";
        try {
            System.out.println(readJson(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readJson(String path) throws IOException {
        String json = String.join(" ",
                Files.readAllLines(
                        Paths.get(path),
                        StandardCharsets.UTF_8)
        );
        return json;
    }
}
