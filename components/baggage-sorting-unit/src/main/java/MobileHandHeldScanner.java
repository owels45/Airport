import placeholder.*;
import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;

public class MobileHandHeldScanner {
    private BaggageSortingUnit baggageSortingUnit;
    private DestinationBox destinationBox;
    private ContainerType containerType;
    // TODO: wird das Feld container gebraucht?
    private Container container;
    private ArrayList<BaggageIdentificationTag> baggageIdentificationTagList;
    private Roboter roboter;


    public void register(DestinationBox destinationBox){
        this.destinationBox = destinationBox;
    }

    public ArrayList<BaggageIdentificationTag> select(ContainerCategory containerCategory) {

        //TODO: How to resolve BaggageIdentificationTag; Über DestinationBox -> Baggage -> BaggageId von Persistence?
        ArrayList<BaggageIdentificationTag> returnList = new ArrayList<BaggageIdentificationTag>();
        for (Baggage baggage: destinationBox.getBaggegeList()) {
            BaggageIdentificationTag tag = this.resolveTag(baggage);
            if(tag.getBoardingPass().getTicketClass().toString().toLowerCase().contains(containerCategory.toString().toLowerCase())){
                returnList.add(tag);
            }
            // TODO: Container Category vs TicketClass
        }

        return returnList;
    }

    private BaggageIdentificationTag resolveTag(Baggage baggage) {
        // TODO How to resolve?
        for (BaggageIdentificationTag tag : this.baggageIdentificationTagList) {
            if(tag.getId() == baggage.getId()) {
                return tag;
            }
        }
        return null;
    }

    public void orderRoboterToLoad(ArrayList<BaggageIdentificationTag> baggageIdentificationTagList, Container container) {
        container.getProfile().setNumberOfBaggages(baggageIdentificationTagList.size());
        this.roboter.load(baggageIdentificationTagList, container);
    }

    // TODO: CTOR angepasst, möglich?
    public MobileHandHeldScanner(ContainerType containerType, BaggageSortingUnit baggageSortingUnit, ArrayList<BaggageIdentificationTag> baggageIdentificationTagList) {
        this.containerType = containerType;
        this.baggageSortingUnit = baggageSortingUnit;
        this.roboter = new Roboter();
        this.baggageIdentificationTagList = baggageIdentificationTagList;
    }

}
