import java.lang.reflect.Method;

public class ServiceVehicleFreshWater {

    private int amountFreshWater = 5000;

    private static ServiceVehicleFreshWater instance = new ServiceVehicleFreshWater();

    public static ServiceVehicleFreshWater getInstance() {
        return instance;
    }

    public Port port;

    private ServiceVehicleFreshWater() {
        port = new Port();
    }

    public String getVehicleType() {
        return "ServiceVehicle: FreshWater";
    }

    public class Port implements IServiceVehicleFreshWater {

        public int refill(Object potableWaterTankPort) {
            return innerMethodRefill(potableWaterTankPort);
        }

        public void notifyGroundOperations(ServiceVehicleFreshWaterReceipt serviceVehicleFreshWaterReceipt) {
            innerMethodNotifyGroundOperations(serviceVehicleFreshWaterReceipt);
        }

    }

    private int innerMethodRefill(Object potableWaterTankPort) {
        try {
            Method refillFreshWater = potableWaterTankPort.getClass().getDeclaredMethod("refill");
            int currentValue = (Integer) refillFreshWater.invoke(potableWaterTankPort);
            amountFreshWater -= currentValue;
            return currentValue;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    private void innerMethodNotifyGroundOperations(ServiceVehicleFreshWaterReceipt serviceVehicleFreshWaterReceipt) {

    }

}