import java.util.Scanner;

public class Validator {
    public static String getString(Scanner sc, String prompt) {
        System.out.print(prompt);
        String s = sc.next();// read user entry
        sc.nextLine();  // discard any other data entered on the line

        return s;
    }

    public static String getPaymentOption(Scanner sc, String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine();// read user entry

        boolean isValid = false;
        while (isValid == false) {
            if (s.equalsIgnoreCase("check") | s.equalsIgnoreCase("cash") | s.equalsIgnoreCase("card")) {
                isValid = true;
                break;

            } else {
                System.out.println("Oh no! That wasn't a valid payment method. Try again.");
                s = sc.nextLine();
            }
            sc.nextLine();
        }
        return s;
    }

    public static int getInt(Scanner sc, String prompt) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Oh no! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static String getCardNum(Scanner sc, String prompt) {
        String i = "";
        System.out.print(prompt);
        i = sc.nextLine();
        int length = i.length();
        boolean isValid = false;
        while (isValid == false) {
            if (length == 16) {
                isValid = true;
                break;
            } else {
                System.out.println("Oh no! Invalid card number. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(Scanner sc, String prompt,
                             int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = getInt(sc, prompt);
            if (i < min)
                System.out.println(
                        "Oh no! Number must be " + min + " or greater. Try again.");
            else if (i > max)
                System.out.println(
                        "Oh no! Number must be " + max + " or less. Try again.");
            else
                isValid = true;
        }

        return i;
    }

    public static double getDouble(Scanner sc, String prompt) {
        double d = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("Oh no! Invalid dollar amount. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }
}