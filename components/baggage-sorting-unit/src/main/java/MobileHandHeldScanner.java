import placeholder.*;
import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;

public class MobileHandHeldScanner {
    private BaggageSortingUnit baggageSortingUnit;
    private DestinationBox destinationBox;
    private ContainerType containerType;
    private Container container;
    private ArrayList<BaggageIdentificationTag> baggageIdentificationTagList;
    private Roboter roboter;

    public MobileHandHeldScanner(BaggageSortingUnit baggageSortingUnit, DestinationBox destinationBox, ContainerType containerType
            , Container container ) {
        this.baggageSortingUnit = baggageSortingUnit;
        this.destinationBox = destinationBox;
        this.containerType = containerType;
        this.container = container;
        this.roboter = new Roboter();
    }

    public void register(DestinationBox destinationBox){
        this.destinationBox = destinationBox;
    }

    public ArrayList<BaggageIdentificationTag> select(ContainerCategory containerCategory) {

        //TODO: How to resolve BaggageIdentificationTag; Über DestinationBox -> Baggage -> BaggageId von Persistence?
        return new ArrayList<BaggageIdentificationTag>();
    }

    public void orderRoboterToLoad(ArrayList<BaggageIdentificationTag> baggageIdentificationTagList, Container container) {
        container.getProfile().setNumberOfBaggages(baggageIdentificationTagList.size());
        this.roboter.load(baggageIdentificationTagList, container);
    }

    public MobileHandHeldScanner(ContainerType containerType) {
        this.containerType = containerType;
    }

}
