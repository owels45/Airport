import java.util.ArrayList;

public class GroundOperationsCenter implements IGroundOperationsCenter {
    ArrayList<CheckInDeskReceipt> checkInReceipts = new ArrayList<CheckInDeskReceipt>();
    ArrayList<BulkyBaggageDeskReceipt> bulkyBaggageDeskReceipts = new ArrayList<BulkyBaggageDeskReceipt>();
    ArrayList<BaggageSortingUnitReceipt> baggeSortingUnitReceipts = new ArrayList<BaggageSortingUnitReceipt>();
    ArrayList<SecurityCheckReceipt> securityCheckReceipts = new ArrayList<SecurityCheckReceipt>();
    ArrayList<FederalPoliceReceipt> federalPoliceReceipts = new ArrayList<FederalPoliceReceipt>();
    ArrayList<CustomsReceipt> customsReceipts = new ArrayList<CustomsReceipt>();
    ArrayList<ServiceVehicleOilReceipt> serviceVehicleOilReceipts = new ArrayList<ServiceVehicleOilReceipt>();
    ArrayList<ServiceVehicleNitrogenOxygenReceipt> serviceVehicleNitrogenOxygenReceipts = new ArrayList<ServiceVehicleNitrogenOxygenReceipt>();
    ArrayList<ServiceVehicleFreshWaterReceipt> serviceVehicleFreshWaterReceipts = new ArrayList<ServiceVehicleFreshWaterReceipt>();
    ArrayList<ServiceVehicleWasteWaterTankReceipt> serviceVehicleWasteWaterTankReceipts = new ArrayList<ServiceVehicleWasteWaterTankReceipt>();
    ArrayList<AirCargoPalletLifterReceipt> airCargoPalletLifterReceipts = new ArrayList<AirCargoPalletLifterReceipt>();
    ArrayList<ContainerLifterReceipt> containerLifterReceipts = new ArrayList<ContainerLifterReceipt>();
    ArrayList<FuelReceipt> fuelReceipts = new ArrayList<FuelReceipt>();
    ArrayList<BoardingControlReceipt> boardingControlReceipts = new ArrayList<BoardingControlReceipt>();
    ArrayList<PushBackVehicleReceipt> pushBackVehicleReceipts = new ArrayList<PushBackVehicleReceipt>();


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