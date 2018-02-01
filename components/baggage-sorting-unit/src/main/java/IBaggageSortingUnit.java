import placeholder.Baggage;
import placeholder.BaggageIdentificationTag;
import placeholder.BaggageVehicle;
import placeholder.Destination;

import java.util.ArrayList;

public interface IBaggageSortingUnit {
    BaggageSortingUnitReceipt execute(String position, Destination destination, ArrayList<Baggage> baggage, ArrayList<BaggageVehicle> baggageVehicles, ArrayList<BaggageIdentificationTag> baggageIdentificationTags);
}
