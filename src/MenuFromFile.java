import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MenuFromFile {

    public static StringBuilder readTextFromFile(String fileName) {

        Path filePath = Paths.get(fileName);

        File menuItems = filePath.toFile();

        StringBuilder result = new StringBuilder();

        try {
            FileReader r = new FileReader(menuItems);
            BufferedReader reader = new BufferedReader(r);

            String line = reader.readLine();
            while (line != null) {

                result.append(line + "\n");
                line = reader.readLine();
            }
            reader.close();
            return result;


        } catch (FileNotFoundException ex) {
            return null;

        } catch (IOException ex) {
            return null;

        }
    }
}
