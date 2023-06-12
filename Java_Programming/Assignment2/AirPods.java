package Assignment2;

public class AirPods extends Product {

    // one-argument constructor
    public AirPods(double basePrice) {
        super(basePrice);
    }

    // caculate the total cost including extra charge
    @Override // overrides Product class method
    public void caculateCost() {
        double extraCharge = 0;
        if(getModel().equals("AirPodsPro")) extraCharge += 100;
        else if(getModel().equals("AirPodsMax")) extraCharge += 200;

        setTotalCost(getBasePrice()+extraCharge);
    } // end method caculateCost

    // show the extra features
    @Override // overrids Product class method
    public void printCheck() {
        super.printCheck();
        if(getModel().equals("AirPodsPro")) System.out.println("Model (AirPodsPro) ------ +$100");
        else if(getModel().equals("AirPodsMax")) System.out.println("Model (AirPodsMax) ------ +$200");
        System.out.println();
    } // end method printCheck

}
