import placeholder.*;

import java.util.ArrayList;

public class MobileHandHeldScanner {
    private BaggageSortingUnit baggageSortingUnit;
    private DestinationBox destinationBox;
    private ContainerType containerType;
    private Container container;
    private ArrayList<BaggageIdentificationTag> baggageIdentificationTagList;
    private Roboter roboter;

    public void register(DestinationBox destinationBox){

    }

    public ArrayList<BaggageIdentificationTag> select(ContainerCategory containerCategory) {

    }

    public void orderRoboterToLoad(ArrayList<BaggageIdentificationTag> baggageIdentificationTagList, Container container) {

    }

    public MobileHandHeldScanner(ContainerType containerType) {
        this.containerType = containerType;
    }

}
