package Assignment2;

public class MacBook extends Product {

    private String memory; // memory size of MacBook (128, 256, 512)
    private String size; // size of MacBook (13, 14, 16)
    private String color; // color of MacBook (base, gold, silver)

    // one-argument constructor
    public MacBook(double basePrice) {
        super(basePrice);
    }

    // return memory size of MacBook
    public String getMemory() {
        return memory;
    } // end method getMemory

    // return size of MackBook
    public String getSize() {
        return size;
    } // end method getSize

    // return the color of MacBook
    public String getColor() {
        return color;
    } // end method getColor

    // set memory size of MacBook
    public void setMemory(String memory) {
        this.memory = memory;
    } // end method setMemory

    // set size of MacBook
    public void setSize(String size) {
        this.size = size;
    } // end of method setSize

    // set the color of MacBook
    public void setColor(String color) {
        this.color = color;
    } // end of method setColor

    // caculate the total cost including extra charge
    @Override // overrides Product class method
    public void caculateCost() {
        double extraCharge = 0;
        if(getModel().equals("Pro")) extraCharge += 200;
        if(getSize().equals("14")) extraCharge += 100;
        else if(getSize().equals("16")) extraCharge += 200;
        if(getColor().equals("Gold")) extraCharge += 20;
        else if(getColor().equals("Silver")) extraCharge += 10;
        if(getMemory().equals("256")) extraCharge += 100;
        else if(getMemory().equals("512")) extraCharge += 300;

        setTotalCost(getBasePrice()+extraCharge);
    }

    // show extra features
    @Override // overrides Product class method
    public void printCheck() {
        super.printCheck();
        if(getModel().equals("Pro")) System.out.println("Model (Pro) ------ +$200");
        if(getSize().equals("14")) System.out.println("Size (14) ------ +$100");
        else if(getSize().equals("16")) System.out.println("Size (16) ------ +$200");
        if(getColor().equals("Gold")) System.out.println("Color (Gold) ------ +$20");
        else if(getColor().equals("Silver")) System.out.println("Color (Silver) ------ +$10");
        if(getMemory().equals("256")) System.out.println("Memory (256) ------ +$100");
        else if(getMemory().equals("512")) System.out.println("Memory (512) ------ +$300");
        System.out.println();
    }
}
