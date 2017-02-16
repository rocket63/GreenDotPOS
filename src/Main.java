import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<PointOfSale> pointOfSaleList = new ArrayList<>();

        Driver.driver();

        StringBuilder menuItemTemp = MenuFromFile.readTextFromFile("menuItems.txt");

        //System.out.print(menuItemTemp);

        String newStringObj = menuItemTemp.toString();

        String[] menuItemArray = newStringObj.split("\n");
        for (String new1 : menuItemArray) {

            System.out.println(new1);
            String[] menuItemArray1 = newStringObj.split(",");
            for (int i = 0; i < menuItemArray1.length; i++) {
                System.out.println(menuItemArray1[i]);
                String name = menuItemArray1[0];
                String category = menuItemArray1[1];
                String description = menuItemArray1[2];
                String price = menuItemArray1[3];
                pointOfSaleList.add(new PointOfSale(name, category, description, price));
            }
        }


        //TEST print array using for loop to check values

    }
}
