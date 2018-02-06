
public interface IServiceVehicleNitrogenOxygen {

    int refillNitrogenBottle(Object nitrogenBottlePort);
    int refillOxygenBottle(Object oxygenBottlePort);
    void notifyGroundOperations(ServiceVehicleNitrogenOxygenReceipt serviceVehicleNitrogenOxygenReceipt);

}