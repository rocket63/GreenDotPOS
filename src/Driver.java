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

        double priceTotal = 0.0;
        double grandTotal = 0.0;
        String paymentMethod = "";

        while (true) {

            //Printing out menu
            //TODO number menu
            System.out.println(MenuFromFile.readTextFromFile("menuItems.txt"));

            //Gets user order and assigns choices to new arraylist
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

            //TODO get price using point of sale? to get just the price from the userOrder arraylist
            /**if () {
             priceTotal = 2;
             } else {
             priceTotal = 3;
             }**/

            //todo put this in its own method
            int itemsTotal = (userOrder.size() + 1);
            double taxRate = 0.05;
            double salesTax = 0.0;
            salesTax = priceTotal * taxRate;
            grandTotal = priceTotal + taxRate;
            System.out.println();
            System.out.println("Items: " + itemsTotal);
            System.out.println("Subtotal: " + priceTotal);
            System.out.println("Tax: " + salesTax);
            System.out.println("Total Price: " + grandTotal);

            int userContinue = Validator.getInt(scan, "Enter 1 to continue to checkout, 2 to view the menu again: ", 1, 2);
            if (userContinue == 1) {
                break;
            } else if (userContinue == 2) {
                continue;
            }
        }

        //Ask user for payment method - validate entry
        //TODO put this in a separate method?
        System.out.println();
        String paymentOption = Validator.getPaymentOption(scan, "Please enter payment option, Card/Check/Cash: ");
        if (paymentOption.equalsIgnoreCase("Card")) {
            String cardNum = Validator.getCardNum(scan, "Enter a credit card #: ");
            String expDate = Validator.getString(scan, "Please enter your expiration date (MM/YY): ");
            int securityNum = Validator.getInt(scan, "Please enter your 3-digit security num: ", 100, 999);
            paymentMethod = ("You payed with card number: " + cardNum + "\nEXP Date: " + expDate + " \nSecurity Number: " + securityNum + ". \n");

        } else if (paymentOption.equalsIgnoreCase("check")) {
            int checkNum = Validator.getInt(scan, "Please enter your check number: ", 0, 9999);
            paymentMethod = ("You payed with check, you ludditical dinosaur!");

        } else if (paymentOption.equalsIgnoreCase("cash")) {
            double cashGiven = Validator.getDouble(scan, "Please enter amount tendered: ");
            double changeNeeded = cashGiven - grandTotal;
            System.out.println("Change is: " + changeNeeded);
            paymentMethod = ("You payed " + cashGiven + " in cash." + "\n Change given: " + changeNeeded + "\n Your grand total is: " );
        }

        //PRINT RECEIPT INFO
        System.out.println("Your order is: " );
        //TODO print out userOrder arraylist
        //TODO call print receipt method (after creating print receipt method
        System.out.println(paymentMethod);
        System.out.println("Thanks for coming to Green Dot Stables! Happy pastures!");


    }
}


