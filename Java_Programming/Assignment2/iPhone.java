package Assignment2;

public class iPhone extends Product {

    private String memory; // memory size of iPhone (64, 128, 256, 512)
    private String color; // color of iPhone (base, Gold, Silver)

    // one-argument constructor
    public iPhone(double basePrice) {
        super(basePrice);
    } // end one-argument constructor

    // return memory size of iPhone
    public String getMemory() {
        return memory;
    } // end method getMemory

    // return color of iPhone
    public String getColor() {
        return color;
    } // end method getColor

    // set memory size of iPhone
    public void setMemory(String memory) {
        this.memory = memory;
    } // end method setMemory

    // set color of iPhone
    public void setColor(String color) {
        this.color = color;
    } // end method setColor

    // caculate the total cost including extra charge
    @Override // overrides Product class method
    public void caculateCost() {
        double extraCharge = 0;
        if(getModel().equals("iPhone13")) extraCharge += 200;
        if(getColor().equals("Gold")) extraCharge += 20;
        else if(getColor().equals("Silver")) extraCharge += 10;
        if(getMemory().equals("128")) extraCharge += 100;
        else if(getMemory().equals("256")) extraCharge += 200;
        else if(getMemory().equals("512")) extraCharge += 300;

        setTotalCost(getBasePrice()+extraCharge);
    } // end method caculateCost

    // show the extra features
    @Override // overrides Product class method
    public void printCheck() {
        super.printCheck();
        if(getModel().equals("iPhone13")) System.out.println("Model (iPhone13) ------ +$200");
        if(getColor().equals("Gold")) System.out.println("Color (Gold) ------ +$20");
        else if(getColor().equals("Silver")) System.out.println("Color (Silver) ------ +$10");
        if(getMemory().equals("128")) System.out.println("Memory (128) ------ +$100");
        else if(getMemory().equals("256")) System.out.println("Memory (256) ------ +$200");
        else if(getMemory().equals("512")) System.out.println("Memory (512) ------ +$300");
        System.out.println();
    } // end method printCheck

}
