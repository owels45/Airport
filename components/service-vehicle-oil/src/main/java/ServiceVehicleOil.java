import base.APUOilTank;
import base.DelcingSystem;
import base.EngineOilTank;
import base.FireExtinguisher;

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

        public int refill(Object delcingSystemPort) {

        }

        public void notifyGroundOperations(ServiceVehicleOilReceipt serviceVehicleOilReceipt) {
            innerMethodNotifyGroundOperations(serviceVehicleOilReceipt);
        }

    }

    private int innerMethodIncreaseLevelOfAPUOilTank(Object apuOilTankPort) {
        Method increaseLevel = apuOilTankPort.getClass().getDeclaredMethod("increaseLevel", Integer.class);
        int currentValue = increaseLevel.invoke(apuOilTankPort, 0);
        currentValue = increaseLevel.invoke(apuOilTankPort, 10 - currentValue);
        amountAPUOil -= currentValue;
        return currentValue;
    }

    private int innerMethodIncreaseLevelOfEngineOilTank(Object engineOilTankPort) {
        Method increaseLevel = engineOilTankPort.getClass().getDeclaredMethod("increaseLevel", Integer.class);
        int currentValue = increaseLevel.invoke(engineOilTankPort, 0);
        currentValue = increaseLevel.invoke(engineOilTankPort, 10 - currentValue);
        amountAPUOil -= currentValue;
        return currentValue;
    }

    private boolean innerMethodChange(Object fireExtinguisherPort) {
        Method changeFE = engineOilTankPort.getClass().getDeclaredMethod("refill");
        return changeFE.invoke(fireExtinguisherPort);
    }

    private int innerMethodRefill(DelcingSystem delcingSystem) {
        return 0;
    }

    private void innerMethodNotifyGroundOperations(ServiceVehicleOilReceipt serviceVehicleOilReceipt) {

    }

}