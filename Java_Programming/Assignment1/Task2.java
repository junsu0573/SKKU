package Assignment1;

import java.util.Scanner;

public class Task2 {

    /*
    - function recieves the number of days as parameter
    - and calculate the saved money increasing every week
     */
    public static int calculateSavingMoney(int numberOfDays) {
        int caculatedMoney = 0;

        caculatedMoney = 7*(numberOfDays/7)*((numberOfDays/7)+1)/2 + ((numberOfDays/7)+1)*(numberOfDays%7);

        return caculatedMoney;
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of days: ");
        int numberOfDays = input.nextInt(); // for storing the number of days for saving money

        int savedMoney = calculateSavingMoney(numberOfDays); // for storing the saved money for the given days

        System.out.println("Total Frank's saving (after " + numberOfDays + " days): " + savedMoney);

    }
}
