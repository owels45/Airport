import java.lang.reflect.Method;

public class ServiceVehicleNitrogenOxygen {

    private static ServiceVehicleNitrogenOxygen instance = new ServiceVehicleNitrogenOxygen();

    public static ServiceVehicleNitrogenOxygen getInstance() {
        return instance;
    }

    private int amountNitrogen = 1000;
    private int amountOxygen = 1000;

    public Port port;

    private ServiceVehicleNitrogenOxygen(){
        port = new Port();
    }

    public String getVehicleType() {
        return "ServiceVehicle: NitrogenOxygen";
    }

    public class Port implements IServiceVehicleNitrogenOxygen {

        public int refillNitrogenBottle(Object nitrogenBottlePort) {
            return innerMethodRefillNitrogenBottle(nitrogenBottlePort);
        }

        public int refillOxygenBottle(Object oxygenBottlePort) {
            return innerMethodRefillOxygenBottle(oxygenBottlePort);
        }

        public void notifyGroundOperations (ServiceVehicleNitrogenOxygenReceipt serviceVehicleNitrogenOxygenReceipt){
            innerMethodNotifyGroundOperations(serviceVehicleNitrogenOxygenReceipt);
        }

    }

    private int innerMethodRefillNitrogenBottle(Object nitrogenBottlePort) {
        try {
            Method refillNitrogen = nitrogenBottlePort.getClass().getDeclaredMethod("refill");
            int currentValue = (Integer) refillNitrogen.invoke(nitrogenBottlePort);
            amountNitrogen -= currentValue;
            return currentValue;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int innerMethodRefillOxygenBottle(Object oxygenBottlePort) {
        try {
            Method refillOxygen = oxygenBottlePort.getClass().getDeclaredMethod("refill");
            int currentValue = (Integer) refillOxygen.invoke(oxygenBottlePort);
            amountOxygen -= currentValue;
            return currentValue;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void innerMethodNotifyGroundOperations (ServiceVehicleNitrogenOxygenReceipt serviceVehicleNitrogenOxygenReceipt){

    }

}