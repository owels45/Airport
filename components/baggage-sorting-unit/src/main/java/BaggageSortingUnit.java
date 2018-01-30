import placeholder.*;
import sun.security.krb5.internal.crypto.Des;


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
    private ArrayList<BaggageIdentificationTag> baggageIdentificationTags;

    public ArrayList<Baggage> getBaggageList() {
        return baggageList;
    }

    public void setBaggageList(ArrayList<Baggage> baggageList) {
        this.baggageList = baggageList;
    }

    private ArrayList<Baggage> baggageList;
    private Destination destination;


    public Port port;

    public void innerExecute() {
        // TODO Add loading of data.
        // Load baggages
        this.baggageList = new ArrayList<Baggage>();

        // Load baggageVehicles
        this.baggageVehicleList = new ArrayList<BaggageVehicle>();

        // Load BaggageIdentificationTags
        this.baggageIdentificationTags = new ArrayList<BaggageIdentificationTag>();

        // Call drop into luggageTub
        for (Baggage baggage : this.baggageList ) {
            LuggageTub luggageTub = new LuggageTub(baggage, this.destination );
            this.luggageTubList.add(this.port.drop(luggageTub, baggage));
        }

        // throw lugaggetub into destinationbox
        for (LuggageTub luggageTub : this.luggageTubList) {
            this.port.throwOff(luggageTub, this.destinationBox);
        }

        // Handhelds select into container (Sotiert nach Klasse, Destinationbox für Klassen, Fristclass zuerst)
        BaggageSortingUnitReceipt receipt = this.loadDestinationBoxIntoContainers();

        this.port.notifyGroundOperation(receipt);
    }

    private BaggageSortingUnit() {
        this.port = new Port();
        this.setDefaultValues();
    }

    public BaggageSortingUnitReceipt loadDestinationBoxIntoContainers() {

        int numberOfBaggageFirstClass = 0;
        int numberOfBaggageBusinessClass = 0;
        int numberOfBaggageEconomyClass = 0;
        int numberOfContainerFirstClass = 0;
        int numberOfContainerBusinessClass = 0;
        int numberOfContainerEconomyClass = 0;

        for (ContainerCategory category : ContainerCategory.values()) {
            if ( category == ContainerCategory.SpecialGood) continue;;
            MobileHandHeldScanner handHeld = new MobileHandHeldScanner(ContainerType.AKE, this, this.baggageIdentificationTags);
            handHeld.register(this.destinationBox);
            ArrayList<BaggageIdentificationTag> baggageTags = handHeld.select(category);
            switch (category){
                case First:
                    numberOfBaggageFirstClass = baggageTags.size();
                    break;
                case Business:
                    numberOfBaggageBusinessClass = baggageTags.size();
                    break;
                case Economy:
                    numberOfBaggageEconomyClass = baggageTags.size();
                    break;
            }

            // Get a new container:
            Container container = this.emptyContainerList.remove(0);
            ArrayList<BaggageIdentificationTag> currentContainerBaggages = new ArrayList<BaggageIdentificationTag>();
            for (int i = 0; i < baggageTags.size(); i++ ){
                if(currentContainerBaggages.size() == 50) {
                    handHeld.orderRoboterToLoad(currentContainerBaggages, container);
                    this.filledContainerList.add(container);
                    container = this.emptyContainerList.remove(0);
                    currentContainerBaggages = new ArrayList<BaggageIdentificationTag>();
                    switch (category){
                        case First:
                            numberOfContainerFirstClass++;
                            break;
                        case Business:
                            numberOfContainerBusinessClass++;
                            break;
                        case Economy:
                            numberOfContainerEconomyClass++;
                            break;
                    }
                }
                currentContainerBaggages.add(baggageTags.get(i));
            }
            if(currentContainerBaggages.size() > 0){
                handHeld.orderRoboterToLoad(currentContainerBaggages, container);
                this.filledContainerList.add(container);
            }
        }
        return new BaggageSortingUnitReceipt(this.destinationBox, this.filledContainerList
                , numberOfBaggageFirstClass, numberOfBaggageBusinessClass, numberOfBaggageEconomyClass
                , numberOfContainerFirstClass, numberOfContainerBusinessClass, numberOfContainerEconomyClass);

    }

    public void setDefaultValues() {
        this.position = "K20";
        this.luggageTubList = new ArrayList<LuggageTub>();
        this.destination = Destination.CPT;

        this.destinationBox = new DestinationBox();
        this.emptyContainerList = new ArrayList<Container>();
        this.filledContainerList = new ArrayList<Container>();

        this.roboter = new Roboter();

        this.generateEmptyContainers();
    }

    private void generateEmptyContainers() {
        for (int i = 0; i < 100; i++){
            ContainerProfile containerProfile = new ContainerProfile(this.destination.toString(), 0);
            this.emptyContainerList.add(new Container(ContainerType.AKE,  "ContainerId: " + i, ContainerCategory.First ,containerProfile,
                    "BarcodeID: " + i,  "QRCode: " + i, 50));
        }
    }

    public String innerGetVersion() {
        return "BaggageSortingUnit - Version 1.0";
    }

    public static BaggageSortingUnit getInstance() {
        return instance;
    }

    public class Port implements IBaggageSortingUnit {

        public LuggageTub drop(LuggageTub luggageTub, Baggage baggage) {
            luggageTub.setBaggage(baggage);
            return luggageTub;
        }

        public void throwOff(LuggageTub luggageTub, DestinationBox destinationBox) {
            destinationBox.getBaggegeList().add(luggageTub.getBaggage());
        }

        public void notifyGroundOperation(BaggageSortingUnitReceipt baggageSortingUnitReceipt) {
            // TODO: Notify per event?
        }

        // TODO Acceptable?
        public void execute() {
            innerExecute();
        }
    }
}
