import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by davidshinabarger on 2/15/17.
 */
public class Driver extends Main {

    public static void driver() {
        Scanner scan = new Scanner(System.in);
        ArrayList<PointOfSale> pointOfSaleList = new ArrayList<>();

        double priceTotal = 0.00;
        double priceSubTotal = 0.00;
        int itemsTotal = 0;


        while (true) {

            //Printing out menu

            pointOfSaleList = MenuFromFile.readTextFromFile("menuItems.txt");
            for (int i = 0; i < pointOfSaleList.size(); i++) {
                System.out.println((i + 1) + ". " + pointOfSaleList.get(i).toString());
            }

            //Gets user order and assigns choices to new arraylist
            int userChoice = Validator.getInt(scan, "Enter item # you want to order: ", 1, 12);
            int numItems = Validator.getInt(scan, "How many of item # " + userChoice + " would you like: ");

            //TODO is PointOfSale correct here to get the right info for the new arraylist?
            ArrayList<PointOfSale> userOrder = new ArrayList<>();

            //TODO add userChoice to new userOrder ArrayList, pull info from POSarraylist
            //
            //for (int i = 0; i < pointOfSaleList.size();i++) {
             //if(userChoice == pointOfSaleList.get(i+1)) {
             userOrder.add(pointOfSaleList.get(userChoice - 1));



            //TODO get price using point of sale? to get just the price from the userOrder arraylist
            if ((pointOfSaleList.get(userChoice-1).getName().equalsIgnoreCase("Cheeseburger")) ||
                    (pointOfSaleList.get(userChoice -1).getName().equalsIgnoreCase("Regular"))) {
                priceSubTotal = numItems * 2.00;
                itemsTotal = itemsTotal + numItems;
            }
             else{
                priceSubTotal =numItems * 3.00;
                itemsTotal = itemsTotal + numItems;
            }
            priceTotal = priceTotal + priceSubTotal;


            System.out.println();
            System.out.println("Price: $" + priceTotal + "0");
            System.out.println("Items: " + itemsTotal);
            System.out.println();
            int userContinue = Validator.getInt(scan, "Enter 1 to continue to checkout, 2 to view the menu again: ", 1, 2);
            if (userContinue == 1) {
                break;
            } else if (userContinue == 2) {
                continue;
            }
        }

        //Ask user for payment method - validate entry
        System.out.println();
        String paymentOption = Validator.getPaymentOption(scan, "Please enter payment option, Card/Check/Cash: ");
        if (paymentOption.equalsIgnoreCase("Card")) {
            String cardNum = Validator.getCardNum(scan, "Enter a credit card #: ");
            String expDate = Validator.getString(scan, "Please enter your expiration date (MM/YY): ");
            int securityNum = Validator.getInt(scan, "Please enter your 3-digit security num: ", 100, 999);

        } else if (paymentOption.equalsIgnoreCase("check")) {
            int checkNum = Validator.getInt(scan, "Please enter your check number: ", 0, 9999);

        } else if (paymentOption.equalsIgnoreCase("cash")) {
            double cashGiven = Validator.getDouble(scan, "Please enter amount tendered: ");
            double changeNeeded = cashGiven - priceTotal;
        }

    }
}


