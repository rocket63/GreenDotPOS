import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<PointOfSale> pointOfSaleList = new ArrayList<>();


        StringBuilder menuItemTemp = MenuFromFile.readTextFromFile("menuItems.txt");

        //System.out.print(menuItemTemp);

        String newStringObj = menuItemTemp.toString();

        String[] menuItemArray = newStringObj.split("\n");



        for (int i = 0; )

    }
}
