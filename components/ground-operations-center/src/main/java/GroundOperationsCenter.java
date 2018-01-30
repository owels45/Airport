import java.util.ArrayList;

public class GroundOperationsCenter {

    private ArrayList<CheckInDeskReceipt> checkInReceipts = new ArrayList<CheckInDeskReceipt>();
    private ArrayList<BulkyBaggageDeskReceipt> bulkyBaggageDeskReceipts = new ArrayList<BulkyBaggageDeskReceipt>();
    private ArrayList<BaggageSortingUnitReceipt> baggeSortingUnitReceipts = new ArrayList<BaggageSortingUnitReceipt>();
    private ArrayList<SecurityCheckReceipt> securityCheckReceipts = new ArrayList<SecurityCheckReceipt>();
    private ArrayList<FederalPoliceReceipt> federalPoliceReceipts = new ArrayList<FederalPoliceReceipt>();
    private ArrayList<CustomsReceipt> customsReceipts = new ArrayList<CustomsReceipt>();
    private ArrayList<ServiceVehicleOilReceipt> serviceVehicleOilReceipts = new ArrayList<ServiceVehicleOilReceipt>();
    private ArrayList<ServiceVehicleNitrogenOxygenReceipt> serviceVehicleNitrogenOxygenReceipts = new ArrayList<ServiceVehicleNitrogenOxygenReceipt>();
    private ArrayList<ServiceVehicleFreshWaterReceipt> serviceVehicleFreshWaterReceipts = new ArrayList<ServiceVehicleFreshWaterReceipt>();
    private ArrayList<ServiceVehicleWasteWaterTankReceipt> serviceVehicleWasteWaterTankReceipts = new ArrayList<ServiceVehicleWasteWaterTankReceipt>();
    private ArrayList<AirCargoPalletLifterReceipt> airCargoPalletLifterReceipts = new ArrayList<AirCargoPalletLifterReceipt>();
    private ArrayList<ContainerLifterReceipt> containerLifterReceipts = new ArrayList<ContainerLifterReceipt>();
    private ArrayList<FuelReceipt> fuelReceipts = new ArrayList<FuelReceipt>();
    private ArrayList<BoardingControlReceipt> boardingControlReceipts = new ArrayList<BoardingControlReceipt>();
    private ArrayList<PushBackVehicleReceipt> pushBackVehicleReceipts = new ArrayList<PushBackVehicleReceipt>();

    private static GroundOperationsCenter instance = new GroundOperationsCenter();

    public Port port;

    private GroundOperationsCenter() {
        port = new Port();
    }

    public static GroundOperationsCenter getInstance() {
        return instance;
    }

    public String innerVersion() {
        return "GroundOperationsCenter 0.9";
    }

    public class Port implements IGroundOperationsCenter {
        public String version() {
            return innerVersion();
        }

        public void receive(CheckInDeskReceipt checkInReceipt) { innerCheckInDeskReceipt(checkInReceipt); }

        public void receive(BulkyBaggageDeskReceipt bulkyBaggageDeskReceipt) { bulkyBaggageDeskReceipts.add(bulkyBaggageDeskReceipt); }

        public void receive(BaggageSortingUnitReceipt baggageSortingUnitReceipt) { baggeSortingUnitReceipts.add(baggageSortingUnitReceipt); }

        public void receive(SecurityCheckReceipt securityCheckReceipt) { securityCheckReceipts.add(securityCheckReceipt); }

        public void receive(FederalPoliceReceipt federalPoliceReceipt) { federalPoliceReceipts.add(federalPoliceReceipt); }

        public void receive(CustomsReceipt customsReceipt) { customsReceipts.add(customsReceipt); }

        public void receive(ServiceVehicleOilReceipt serviceVehicleOilReceipt) { serviceVehicleOilReceipts.add(serviceVehicleOilReceipt); }

        public void receive(ServiceVehicleFreshWaterReceipt serviceVehicleFreshWaterReceipt) { serviceVehicleFreshWaterReceipts.add(serviceVehicleFreshWaterReceipt); }

        public void receive(ServiceVehicleWasteWaterTankReceipt serviceVehicleWasteWaterTankReceipt) { serviceVehicleWasteWaterTankReceipts.add(serviceVehicleWasteWaterTankReceipt); }

        public void receive(AirCargoPalletLifterReceipt airCargoPalletLifterReceipt) { airCargoPalletLifterReceipts.add(airCargoPalletLifterReceipt); }

        public void receive(ContainerLifterReceipt containerLifterReceipt) { containerLifterReceipts.add(containerLifterReceipt); }

        public void receive(FuelReceipt fuelReceipt) { fuelReceipts.add(fuelReceipt); }

        public void receive(BoardingControlReceipt boardingControlReceipt) { boardingControlReceipts.add(boardingControlReceipt); }

        public void receive(PushBackVehicleReceipt pushBackVehicleReceipt) { pushBackVehicleReceipts.add(pushBackVehicleReceipt); }

        public void receive(ServiceVehicleNitrogenOxygenReceipt serviceVehicleNitrogenOxygenReceipt) { serviceVehicleNitrogenOxygenReceipts.add(serviceVehicleNitrogenOxygenReceipt); }
    }

    private void innerCheckInDeskReceipt(CheckInDeskReceipt checkInReceipt) {
        checkInReceipts.add(checkInReceipt);
        //factory.persistence.build().insert(CheckInDeskReceipts, checkInReceipt);
    }
}