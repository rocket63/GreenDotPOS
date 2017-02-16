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
        ArrayList<PointOfSale> userOrder = new ArrayList<>();
        while (true) {

            //Welcome and print menu
            pointOfSaleList = printMenu(); //see method

            //Gets user order and assigns choices to new array list
            System.out.println();
            int userChoice = Validator.getInt(scan, "Enter item # you want to order: ", 1, 12);
            int numItems = Validator.getInt(scan, "How many of item # " + userChoice + " would you like: ");
            createUserOrderArrayList(pointOfSaleList, userOrder, userChoice, numItems); //see method

            //Setting price and totals based on user order quantities
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
            grandTotal = receiptInfo(priceTotal, itemsTotal);

            int userContinue = Validator.getInt(scan, "Enter 1 to continue to checkout, 2 to view the menu again: ", 1, 2);
            System.out.println();
            if (userContinue == 1) {
                break; //calls paymentOptions method below
            } else if (userContinue == 2) {
                continue; //shows menu again and starts over
            }
        }

        //Ask user for payment method - validate entry
        paymentOptions(scan, priceTotal, itemsTotal, grandTotal, paymentMethod, userOrder); //see method below

    }

    //Printing menu
    public static ArrayList<PointOfSale> printMenu() {
        System.out.println("Welcome to Green Dot Stables!");
        System.out.println("Our menu: ");
        System.out.println();
        ArrayList<PointOfSale> pointOfSaleList;
        pointOfSaleList = MenuFromFile.readTextFromFile("menuItems.txt");
        for (int i = 0; i < pointOfSaleList.size(); i++) {
            if (i < 9)
                System.out.println((i + 1) + ".  " + pointOfSaleList.get(i).toString());
            else {
                System.out.println((i + 1) + ". " + pointOfSaleList.get(i).toString());
            }
        }
        return pointOfSaleList;
    }

    //Create new array list with user order only

    public static void createUserOrderArrayList(ArrayList<PointOfSale> pointOfSaleList, ArrayList<PointOfSale> userOrder, int userChoice, int numItems) {
        for (int i = 0; i < numItems; i++) {
            userOrder.add(pointOfSaleList.get(userChoice - 1));
        }
    }

    //Ask user for payment option and print payment info
    public static void paymentOptions(Scanner scan, double priceTotal, int itemsTotal, double grandTotal, String paymentMethod, ArrayList<PointOfSale> userOrder) {
        String paymentOption = Validator.getPaymentOption(scan, "Please enter payment option, Card/Check/Cash: ");
        if (paymentOption.equalsIgnoreCase("Card")) {
            String cardNum = Validator.getCardNum(scan, "Enter a credit card #: ");
            String expDate = Validator.getString(scan, "Please enter your expiration date (MM/YY): ");
            int securityNum = Validator.getInt(scan, "Please enter your 3-digit security num: ", 100, 999);
            paymentMethod = ("You paid with card number: " + cardNum + "\nEXP Date: " + expDate + " \nSecurity Number: " + securityNum + ". \n");

        } else if (paymentOption.equalsIgnoreCase("check")) {
            int checkNum = Validator.getInt(scan, "Please enter your check number: ", 0, 9999);
            paymentMethod = ("You paid with check, you ludditical dinosaur!");

        } else if (paymentOption.equalsIgnoreCase("cash")) {
            double cashGiven = Validator.getDouble(scan, "Please enter amount tendered: ");
            double changeNeeded = cashGiven - grandTotal;
            System.out.printf("Change is: $" + "%.2f", changeNeeded);
            System.out.println();
            paymentMethod = String.format("You paid $%.2f" + " in cash. \nChange given: $%.2f", cashGiven, changeNeeded);
        }

        callAndPrintReceipt(priceTotal, itemsTotal, paymentMethod, userOrder);
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

    //Call & print receipt info
    public static void callAndPrintReceipt(double priceTotal, int itemsTotal, String paymentMethod, ArrayList<PointOfSale> userOrder) {
        System.out.println();
        System.out.println("RECEIPT");
        System.out.println("========");
        System.out.println("Your order is: ");
        for (int i = 0; i < userOrder.size(); i++) {
            System.out.println(userOrder.get(i));
        }

        receiptInfo(priceTotal, itemsTotal);
        System.out.printf(paymentMethod);
        System.out.println();
        System.out.println();
        System.out.println("Thanks for coming to Green Dot Stables! Happy pastures!");
        System.out.println();
        System.out.println("Next order: ");
        System.out.println();
        driver();

    }
}


