<<<<<<< HEAD:components/ground-operations-center/src/main/java/ServiceVehicleOilReceipt.java
=======
package SupportClasses;
>>>>>>> master:components/ground-operations-center/src/main/java/SupportClasses/ServiceVehicleOilReceipt.java

public class ServiceVehicleOilReceipt {

    private int amountAPUOil;
    private int amountEngineOil;

    public ServiceVehicleOilReceipt(int amountAPUOil, int amountEngineOil) {
        this.amountAPUOil = amountAPUOil;
        this.amountEngineOil = amountEngineOil;
    }

    public int getAmountAPUOil() {
        return amountAPUOil;
    }

    public int getAmountEngineOil() {
        return amountEngineOil;
    }

}
