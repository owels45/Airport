public class Airport {

    private Object checkInDeskPort;;
    private Object baggageSortingUnitPort;
    private Object securityCheckPort;
    private Object federalPolicePort;
    private Object customsPort;
    private Object serviceVehicleOilPort;
    private Object serviceVehicleNitrogenOxygenPort;
    private Object serviceVehicleFreshWaterPort;
    private Object serviceVehicleWasteWaterTankPort;
    private Object airCargoPalletLifterPort;
    private Object skyTankingVehiclePort;
    private Object boardingControlPort;
    private Object pushBackVehiclePort;

    public void build() {
        //checkInDeskPort = CheckInDeskFactory.build();
        //...
    }

//    @Subscribe
    public void receive(CheckIn event) {
        // Methodenaufruf
    }
}
