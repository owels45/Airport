import java.util.ArrayList;

public class GroundOperationsCenter implements IGroundOperationsCenter {
    ArrayList<CheckInDeskReceipt> checkInReceipts = new ArrayList<CheckInDeskReceipt>();
    ArrayList<BulkyBaggageDeskReceipt> bulkyBaggageDeskReceipts = new ArrayList<BulkyBaggageDeskReceipt>();
    ArrayList<BaggageSortingUnitReceipt> baggeSortingUnitReceipts;
    ArrayList<SecurityCheckReceipt> securityCheckReceipts;
    ArrayList<FederalPoliceReceipt> federalPoliceReceipts;
    ArrayList<CustomsReceipt> customsReceipts;
    ArrayList<ServiceVehicleOilReceipt> serviceVehicleOilReceipts;
    ArrayList<ServiceVehicleNitrogenOxygenReceipt> serviceVehicleNitrogenOxygenReceipts;
    ArrayList<ServiceVehicleFreshWaterReceipt> serviceVehicleFreshWaterReceipts;
    ArrayList<ServiceVehicleWasteWaterTankReceipt> serviceVehicleWasteWaterTankReceipts;
    ArrayList<AirCargoPalletLifterReceipt> airCargoPalletLifterReceipts;
    ArrayList<ContainerLifterReceipt> containerLifterReceipts;
    ArrayList<FuelReceipt> fuelReceipts;
    ArrayList<BoardingControlReceipt> boardingControlReceipts;
    ArrayList<PushBackVehicleReceipt> pushBackVehicleReceipts;


    public void receive(CheckInDeskReceipt checkInReceipt) {
        checkInReceipts.add(checkInReceipt);
    }

    public void receive(BulkyBaggageDeskReceipt bulkyBaggageDeskReceipt) {
        bulkyBaggageDeskReceipts.add(bulkyBaggageDeskReceipt);
    }

    public void receive(BaggageSortingUnitReceipt baggageSortingUnitReceipt) {
        baggeSortingUnitReceipts.add(baggageSortingUnitReceipt);
    }

    public void receive(SecurityCheckReceipt securityCheckReceipt) {
        securityCheckReceipts.add(securityCheckReceipt);
    }

    public void receive(FederalPoliceReceipt federalPoliceReceipt) {
        federalPoliceReceipts.add(federalPoliceReceipt);
    }

    public void receive(CustomsReceipt customsReceipt) {
        customsReceipts.add(customsReceipt);
    }

    public void receive(ServiceVehicleOilReceipt serviceVehicleOilReceipt) {
        serviceVehicleOilReceipts.add(serviceVehicleOilReceipt);
    }
}