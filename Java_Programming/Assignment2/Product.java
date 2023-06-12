package Assignment2;

import java.util.Scanner;

public class Product {

    Scanner input = new Scanner(System.in);

    private double basePrice; // base price of the product
    private double totalCost; // total cost including extra charge
    private String model; // the name of model
    private int quantity; // the number of the product user buys
    private String UserSelection; // user's selection for the product features

    // one-argument constructor
    public Product(double basePrice) {
        this.basePrice = basePrice;
    }

    // return base price
    public double getBasePrice() {
        return basePrice;
    } // end method getBasePrice

    // return total cost
    public double getTotalCost() {
        return totalCost;
    } // end method getTotalCost

    // return the name of model
    public String getModel() {
        return model;
    } // end method getModel

    // return the quantity of the product
    public int getQuantity() {
        return quantity;
    } // end method getQuantity

    // return user's selection
    public String getUserSelection() {
        return UserSelection;
    } // end method getUserSelection

    // set base price
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    } // end method setBasePrice

    // set total cost
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    } // end method setTotalCost

    // set the name of model
    public void setModel(String model) {
        this.model = model;
    } // end method setModel

    // set the quantity of the product
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    } // end method setQuantity

    // set user's selection
    public void setUserSelection() {
        String selection = input.nextLine();
        this.UserSelection = selection;
    } // end method setUserSelection

    // caculate total cost with extra charge
    public void caculateCost() {
        setTotalCost(getBasePrice());
    } // end method caculateCost

    // show extra features
    public void printCheck() {
        System.out.println("====== check ======");
    } // end method printCheck

}
