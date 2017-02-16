import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<PointOfSale> pointOfSaleList = new ArrayList<>();

        Driver.driver();

        pointOfSaleList = MenuFromFile.readTextFromFile("menuItems.txt");
        for (int i = 0; i < pointOfSaleList.size(); i++) {
            System.out.println(pointOfSaleList.get(i).toString());
        }

    }
}

