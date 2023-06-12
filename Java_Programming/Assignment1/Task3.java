package Assignment1;

import java.util.Scanner;
import java.util.Random;


public class Task3 {

    /*
    - function recieves the number of correct answer as parameter
    - and print the feedback as the given number
     */
    public static void printFeedback(int numberOfCorrect) {
        switch (numberOfCorrect) {
            case 0: System.out.println("Try again.");
                    break;
            case 1: System.out.println("Very bad.");
                    break;
            case 2: System.out.println("Not Bad.");
                    break;
            case 3: System.out.println("Good.");
                    break;
            case 4: System.out.println("Very good!");
                    break;
            case 5: System.out.println("Excellent!");
                    break;
            default:
                    break;
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random randomGenerator = new Random();

        int numberOfCorrect = 0; // for storing the number of correct answers

        // Iterating for getting a couple of random numbers and print
        for(int i = 1; i <= 5; i++) {
            int firstNumber = randomGenerator.nextInt(50); // for storoing a random number
            int secondNumber = randomGenerator.nextInt(50); // for storing the other number

            System.out.print("Question " + i + " - Caculate the addition (" + firstNumber + " + " + secondNumber + "): ");
            int userInput = input.nextInt();

            if(userInput == firstNumber+secondNumber) numberOfCorrect++; // count the number of correct answers
        }

        System.out.println("Number of correct answers: " + numberOfCorrect);
        printFeedback(numberOfCorrect);

    }
}
