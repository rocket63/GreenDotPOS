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
        double grandTotal = 0.00;
        String paymentMethod = "";

        while (true) {

            //Printing out menu
            pointOfSaleList = MenuFromFile.readTextFromFile("menuItems.txt");
            for (int i = 0; i < pointOfSaleList.size(); i++) {
                if (i < 9)
                    System.out.println((i + 1) + ".  " + pointOfSaleList.get(i).toString());
            else {
        System.out.println((i + 1) + ". " + pointOfSaleList.get(i).toString());
    }
}
            //TODO format arraylist

            //Gets user order and assigns choices to new arraylist

            System.out.println();
            int userChoice = Validator.getInt(scan, "Enter item # you want to order: ", 1, 12);
            int numItems = Validator.getInt(scan, "How many of item # " + userChoice + " would you like: ");

            ArrayList<PointOfSale> userOrder = new ArrayList<>();

            userOrder.add(pointOfSaleList.get(userChoice - 1));

            //Get price from pointOfSale and using in userOrder
            if ((pointOfSaleList.get(userChoice - 1).getName().equalsIgnoreCase("Cheeseburger")) ||
                    (pointOfSaleList.get(userChoice - 1).getName().equalsIgnoreCase("Regular"))) {
                priceSubTotal = numItems * 2.00;
                itemsTotal = itemsTotal + numItems;
            } else {
                priceSubTotal = numItems * 3.00;
                itemsTotal = itemsTotal + numItems;
            }
            priceTotal = priceTotal + priceSubTotal;

            System.out.println();
            System.out.printf("Price: $" + "%.2f", priceTotal);
            System.out.println();

            grandTotal = receiptInfo(priceTotal, itemsTotal);

            int userContinue = Validator.getInt(scan, "Enter 1 to continue to checkout, 2 to view the menu again: ", 1, 2);
            System.out.println();
            if (userContinue == 1) {
                break;
            } else if (userContinue == 2) {
                continue;
            }

        }

        //Ask user for payment method - validate entry
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
            System.out.printf("Change is: $" + "%.2f", changeNeeded);
            System.out.println();
            paymentMethod = String.format("You payed $%.2f" + " in cash. \nChange given: $%.2f", cashGiven, changeNeeded);
        }

        //Call & print receipt info
        System.out.println();
        System.out.println("RECEIPT");
        System.out.println("========");
        System.out.println("Your order is: ");
        //TODO print names of yourOrder
        receiptInfo(priceTotal, itemsTotal);
        System.out.printf(paymentMethod);
        System.out.println();
        System.out.println();
        System.out.println("Thanks for coming to Green Dot Stables! Happy pastures!");
        System.exit(0);

    }

    //Info needed to print receipt
    public static double receiptInfo(double priceTotal, int itemsTotal) {
        double grandTotal;
        double taxRate = 0.05;
        double salesTax = 0.00;
        salesTax = priceTotal * taxRate;
        grandTotal = priceTotal + salesTax;
        System.out.println("Items: " + itemsTotal);
        System.out.println();
        System.out.printf("Subtotal: $" + "%.2f", priceTotal);
        System.out.println();
        System.out.printf("Tax: " + "%.2f", salesTax);
        System.out.println();
        System.out.printf("Total Price: $" + "%.2f", grandTotal);
        System.out.println();
        System.out.println();
        return grandTotal;


    }
}


