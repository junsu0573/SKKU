package Assignment2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int is_working = 1; // for storing whether to continue the program
        int choice; // for storing the number of user's choice
        int quantity; // for storing the quantity of product the user buys

        // Iterating if user want to continue (is_working == 1)
        while(is_working == 1) {
            System.out.println("==== Welcome Apple Korea ====");
            System.out.println("What do you want to buy?\nChoose 1 for MacBook\nChoose 2 for iPhone\nChoose 3 for AirPods\nChoose 0 for Exit");
            System.out.print("Please enter your choice: ");
            choice = input.nextInt();
            System.out.println("==============================");

            //get user's choice and get user's selection of the features of the product user choiced
            switch (choice) {
                case 1:
                    // instantiate MacBook object
                    MacBook macbook = new MacBook(1000);
                    // get the features of MacBook
                    System.out.println("Base cost of the MacBook: $1000");
                    System.out.print("Which model do you want (Pro or Air): ");
                    macbook.setUserSelection();
                    macbook.setModel(macbook.getUserSelection());
                    System.out.print("Size (13, 14, 16): ");
                    macbook.setUserSelection();
                    macbook.setSize(macbook.getUserSelection());
                    System.out.print("Color (base, Gold, Silver): ");
                    macbook.setUserSelection();
                    macbook.setColor(macbook.getUserSelection());
                    System.out.print("Memory (128, 256, 512): ");
                    macbook.setUserSelection();
                    macbook.setMemory(macbook.getUserSelection());
                    System.out.print("How many do you want to buy: ");
                    quantity = input.nextInt();
                    macbook.setQuantity(quantity);

                    macbook.caculateCost(); // caculate total cost according to user's selection

                    macbook.printCheck(); // show extra features

                    System.out.println("Total cost for one MacBook: $" + macbook.getTotalCost());
                    System.out.println("Total cost (quantity x " + macbook.getQuantity() + "): $" + macbook.getTotalCost() * macbook.getQuantity());
                    System.out.print(" Do you want to purchase something else (Yes: 1, No: 0): ");
                    is_working = input.nextInt(); // get is_working value for continuing or finishing purchasing
                    break;
                case 2:
                    // instantiate iPhone object
                    iPhone iphone = new iPhone(800);
                    // get the features of iPhone
                    System.out.println("Base cost of the iPhone: $800");
                    System.out.print("Which model do you want (iPhone12 or iPhone13): ");
                    iphone.setUserSelection();
                    iphone.setModel(iphone.getUserSelection());
                    System.out.print("Color (base, Gold, Silver): ");
                    iphone.setUserSelection();
                    iphone.setColor(iphone.getUserSelection());
                    System.out.print("Memory (64, 128, 256, 512): ");
                    iphone.setUserSelection();
                    iphone.setMemory(iphone.getUserSelection());
                    System.out.print("How many do you want to buy: ");
                    quantity = input.nextInt();
                    iphone.setQuantity(quantity);

                    iphone.caculateCost(); // caculate total cost according to user's selection

                    iphone.printCheck(); // show extra features

                    System.out.println("Total cost for one iPhone: $" + iphone.getTotalCost());
                    System.out.println("Total cost (quantity x " + iphone.getQuantity() + "): $" + iphone.getTotalCost() * iphone.getQuantity());
                    System.out.print(" Do you want to purchase something else (Yes: 1, No: 0): ");
                    is_working = input.nextInt(); // get is_working value for continuing or finishing purchasing
                    break;
                case 3:
                    // instantiate iPhone object
                    AirPods airpods = new AirPods(120);
                    // get the features of AirPods
                    System.out.println("Base cost of the AirPods: $120");
                    System.out.print("Which model do you want (AirPods3 or AirPodsPro or AirPodsMax): ");
                    airpods.setUserSelection();
                    airpods.setModel(airpods.getUserSelection());
                    System.out.print("How many do you want to buy: ");
                    quantity = input.nextInt();
                    airpods.setQuantity(quantity);

                    airpods.caculateCost(); // caculate total cost according to user's selection

                    airpods.printCheck(); // show extra features

                    System.out.println("Total cost for one iPhone: $" + airpods.getTotalCost());
                    System.out.println("Total cost (quantity x " + airpods.getQuantity() + "): $" + airpods.getTotalCost() * airpods.getQuantity());
                    System.out.print(" Do you want to purchase something else (Yes: 1, No: 0): ");
                    is_working = input.nextInt(); // get is_working value for continuing or finishing purchasing
                    break;
                case 0:
                    is_working = 0;
                default:
                    break;
            }
            System.out.println("Thank you for your purchase!");
        }

    }
}
