import base.APUOilTank;
import base.DelcingSystem;
import base.EngineOilTank;
import base.FireExtinguisher;

interface IServiceVehicleOil {

    int increaseLevelOfAPUOilTank(Object apuOilTankPort);
    int increaseLevelOfEngineOilTank(Object engineOilTankPort);
    boolean change(Object fireExtinguisherPort);
    int refill(Object delcingSystemPort);
    void notifyGroundOperations(ServiceVehicleOilReceipt serviceVehicleOilReceipt);

}