import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //ArrayList<PointOfSale> pointOfSaleList = new ArrayList<>();

        Driver.driver();

<<<<<<< HEAD


=======
        pointOfSaleList = MenuFromFile.readTextFromFile("menuItems.txt");
        for (int i = 0; i < pointOfSaleList.size(); i++) {
           System.out.println(pointOfSaleList.get(i).toString());
            }
>>>>>>> 26a87ef71aa70b92f4b3870a59b98729beedcb72

        }
    }

