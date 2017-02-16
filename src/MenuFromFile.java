import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class MenuFromFile {

    public static ArrayList<PointOfSale> readTextFromFile(String fileName) {

        Path filePath = Paths.get(fileName);

        File menuItems = filePath.toFile();

        ArrayList<PointOfSale> result = new ArrayList<PointOfSale>();

        try {
            FileReader r = new FileReader(menuItems);
            BufferedReader reader = new BufferedReader(r);

            String line = reader.readLine();
            while (line != null) {

        String[] menuItemArray = line.split(",");
        String lastPosition = menuItemArray[4];
        if (lastPosition != null){
            result.add(new PointOfSale(menuItemArray[0],menuItemArray[1],menuItemArray[2],menuItemArray[3]));
        }
                //result.append(line + "\n");
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
