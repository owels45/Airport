import java.util.ArrayList;

public interface IBaggageSortingUnit {
    BaggageSortingUnitReceipt execute(String position, Destination destination, ArrayList<Baggage> baggage, ArrayList<Object> baggageVehicles, ArrayList<BaggageIdentificationTag> baggageIdentificationTags) throws Exception;
}
