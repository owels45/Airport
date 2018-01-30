import placeholder.Baggage;
import placeholder.DestinationBox;
import placeholder.LuggageTub;

public interface IBaggageSortingUnit {
    LuggageTub drop(LuggageTub luggageTub, Baggage baggage);
    void throwOff(LuggageTub luggageTub, DestinationBox destinationBox);
    void notifyGroundOperation(BaggageSortingUnitReceipt baggageSortingUnitReceipt);
}
