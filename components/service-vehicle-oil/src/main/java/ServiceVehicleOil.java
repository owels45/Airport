import java.lang.reflect.Method;

public class ServiceVehicleOil {

    private int amountAPUOil = 1000;
    private int amountEngineOil = 1000;

    private static ServiceVehicleOil instance = new ServiceVehicleOil();

    public static ServiceVehicleOil getInstance() {
        return instance;
    }

    public Port port;

    private ServiceVehicleOil() {
        port = new Port();
    }

    public String getVehicleType() {
        return "ServiceVehicle: Oil";
    }

    public class Port implements IServiceVehicleOil {

        public int increaseLevelOfAPUOilTank(Object apuOilTankPort) {
            return innerMethodIncreaseLevelOfAPUOilTank(apuOilTankPort);
        }

        public int increaseLevelOfEngineOilTank(Object engineOilTankPort) {
            return innerMethodIncreaseLevelOfEngineOilTank(engineOilTankPort);
        }

        public boolean change(Object fireExtinguisherPort) {
            return innerMethodChange(fireExtinguisherPort);
        }

        public int refill(Object deIcingSystemPort) {
            return innerMethodRefill(deIcingSystemPort);
        }

        public void notifyGroundOperations(ServiceVehicleOilReceipt serviceVehicleOilReceipt) {
            innerMethodNotifyGroundOperations(serviceVehicleOilReceipt);
        }

    }

    private int innerMethodIncreaseLevelOfAPUOilTank(Object apuOilTankPort) {
        try {
            Method increaseLevel = apuOilTankPort.getClass().getDeclaredMethod("increaseLevel", Integer.class);
            int currentValue = (Integer) increaseLevel.invoke(apuOilTankPort, 0);
            currentValue = (Integer) increaseLevel.invoke(apuOilTankPort, 10 - currentValue);
            amountAPUOil -= currentValue;
            return currentValue;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  -1;
    }

    private int innerMethodIncreaseLevelOfEngineOilTank(Object engineOilTankPort) {
        try {
            Method increaseLevel = engineOilTankPort.getClass().getDeclaredMethod("increaseLevel", Integer.class);
            int currentValue = (Integer) increaseLevel.invoke(engineOilTankPort, 0);
            currentValue = (Integer) increaseLevel.invoke(engineOilTankPort, 10 - currentValue);
            amountAPUOil -= currentValue;
            return currentValue;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    private boolean innerMethodChange(Object fireExtinguisherPort) {
        try {
            Method changeFE = fireExtinguisherPort.getClass().getDeclaredMethod("refill");
            return (Boolean) changeFE.invoke(fireExtinguisherPort);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private int innerMethodRefill(Object deIcingSystemPort) {
        try {
            Method refillDeIcingSystem = deIcingSystemPort.getClass().getDeclaredMethod("refill");
            return (Integer) refillDeIcingSystem.invoke(deIcingSystemPort);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    private void innerMethodNotifyGroundOperations(ServiceVehicleOilReceipt serviceVehicleOilReceipt) {

    }

}