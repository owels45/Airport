interface IServiceVehicleFreshWater {

    int refill(Object potableWaterTankPort);
    void notifyGroundOperations(ServiceVehicleFreshWaterReceipt serviceVehicleFreshWaterReceipt);

}