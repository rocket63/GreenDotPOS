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

        while (true) {
            //TODO print out menu
            System.out.println();

            int userChoice = Validator.getInt(scan, "Enter burger # you want to order: ", 1, 12);
            int numItems = Validator.getInt(scan, "How many of item # " + userChoice + " would you like: ");

            //TODO is PointOfSale correct here to get the right info for the new arraylist?
            ArrayList<PointOfSale> userOrder = new ArrayList<>();

            //TODO add userChoice to new userOrder ArrayList, pull info from POSarraylist
            //
            /**for (int i = 0; i < POS ARRAY;i++) {
             if(userChoice == POS ARRAY(i+1)) {
             userOrder.add(userChoice(i-1));
             }
             **/

            double priceTotal = 0; //TODO get price using point of sale? to get just the price from the userOrder arraylist
            int itemsTotal = (userOrder.size() + 1);
            System.out.println("Price: " + priceTotal);
            System.out.println("Items: " + itemsTotal);
            System.out.println();
            int userContinue = Validator.getInt(scan, "Enter 1 to continue to checkout, 2 to view the menu again.", 1, 2);
            if (userContinue == 1) {
                break;
            } else if (userContinue == 2) {
                continue;
            }
        }
        String paymentOption = Validator.getPaymentOption(scan, "Please enter payment option, Card/Check/Cash: ");
        //TODO add if & else if statements depending on user payment choice
        if (paymentOption.equalsIgnoreCase("Card")) {
            //TODO change credit card validator to only accept a 16-digit number
            int cardNum = Validator.getCardInt(scan, "Enter a credit card #: ");
            String expDate = Validator.getString(scan, "Please enter your expiraction date (MM/YY) : ");
            int securityNum = Validator.getInt(scan, "Please enter your 3-digit security num :", 100, 999);

        } else if (paymentOption.equalsIgnoreCase("check")) {

        } else if (paymentOption.equalsIgnoreCase("cash")) {

        }

    }
}


