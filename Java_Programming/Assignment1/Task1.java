package Assignment1;

import java.util.Scanner;

public class Task1 {

    /*
    - function receices initial balance, percentage, and the number of years as parameter
    - and caculates the amount of deposit after the given year
     */
    public static double getNewBalance(double initialBalance, double percentage, int numberOfYears) {
        double newBalance = initialBalance; // for storing caculated balance

        // Iterating for getting increased balance for each year
        for(int i = 1; i <= numberOfYears; i++) {
            newBalance += newBalance*(percentage/100);
        }

        return newBalance;
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please, enter following information:");

        System.out.print("Your name: ");
        String userName = input.nextLine(); // for storing the bank user's name

        System.out.print("Initial Balance: ");
        double initialBalance = input.nextInt(); // for storing initial balance of user

        System.out.print("Percentage: ");
        double percentage = input.nextDouble(); // for storing increasing percentage

        System.out.print("Number of years: ");
        int numberOfYears = input.nextInt(); // for storing deposit years

        double newBalance = getNewBalance(initialBalance, percentage, numberOfYears); // for storing deposit after the given year

        System.out.println("========================================");

        System.out.println("User name: " + userName);
        System.out.println("Percentage: " + percentage);
        System.out.println("Your balance (after " + numberOfYears + " years): " +newBalance);
    }
}
