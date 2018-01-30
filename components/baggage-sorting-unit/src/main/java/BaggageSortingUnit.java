import placeholder.*;
import sun.security.krb5.internal.crypto.Des;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BaggageSortingUnit {

    private static BaggageSortingUnit instance = new BaggageSortingUnit();

    private String position;
    private ArrayList<LuggageTub> luggageTubList;
    private DestinationBox destinationBox;
    private ArrayList<Container> emptyContainerList;
    private ArrayList<Container> filledContainerList;
    private Roboter roboter;
    private ArrayList<BaggageVehicle> baggageVehicleList;


    public Port port;

    private BaggageSortingUnit() {
        this.port = new Port();
        // Load baggages
        // Load baggageVehicles
    }

    public String innerGetVersion() {
        return "BaggageSortingUnit - Version 1.0";
    }

    public static BaggageSortingUnit getInstance() {
        return instance;
    }

    public class Port implements IBaggageSortingUnit {

        public LuggageTub drop(LuggageTub luggageTub, Baggage baggage) {
            return null;
        }

        public void throwOff(LuggageTub luggageTub, DestinationBox destinationBox) {

        }

        public void notifyGroundOperation(BaggageSortingUnitReceipt baggageSortingUnitReceipt) {
            // Persist BaggageSortingUnitReceipt
        }
    }
}
