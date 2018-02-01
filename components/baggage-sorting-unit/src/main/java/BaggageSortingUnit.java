import placeholder.*;
import sun.security.krb5.internal.crypto.Des;


import java.util.ArrayList;

public class BaggageSortingUnit {

    private static BaggageSortingUnit instance = new BaggageSortingUnit();

    public String getPosition() {
        return position;
    }

    private String position;
    private ArrayList<LuggageTub> luggageTubList;
    private DestinationBox destinationBox;
    private ArrayList<Container> emptyContainerList;
    private ArrayList<Container> filledContainerList;
    private Roboter roboter;
    private ArrayList<BaggageVehicle> baggageVehicleList;
    private ArrayList<BaggageIdentificationTag> baggageIdentificationTags;
    private ArrayList<Baggage> baggageList;
    private Destination destination;


    public Port port;

    public BaggageSortingUnitReceipt innerExecute() {
        // Call drop into luggageTub
        for (Baggage baggage : this.baggageList ) {
            LuggageTub luggageTub = new LuggageTub(baggage, this.destination );
            this.luggageTubList.add(this.drop(luggageTub, baggage));
        }

        // throw lugaggetub into destinationbox
        for (LuggageTub luggageTub : this.luggageTubList) {
            this.throwOff(luggageTub, this.destinationBox);
        }

        // Handhelds select into container (Sotiert nach Klasse, Destinationbox für Klassen, Fristclass zuerst)
        return this.loadDestinationBoxIntoContainers();
    }

    private void initialize(String position, Destination destination, ArrayList<Baggage> baggage, ArrayList<BaggageVehicle> baggageVehicles, ArrayList<BaggageIdentificationTag> baggageIdentificationTags) {

        this.position = position;
        this.luggageTubList = new ArrayList<LuggageTub>();
        this.destination = destination;

        this.destinationBox = new DestinationBox();
        this.emptyContainerList = new ArrayList<Container>();
        this.filledContainerList = new ArrayList<Container>();
        this.baggageVehicleList = baggageVehicles;

        this.roboter = new Roboter();

        this.generateEmptyContainers();

        this.baggageList = baggage;
        this.baggageIdentificationTags = baggageIdentificationTags;
    }

    private BaggageSortingUnit() {
        this.port = new Port();
    }

    private void updateBaggageSortingUnitReceiptNumberOfBaggage(BaggageSortingUnitReceipt receipt, ContainerCategory category, int value) {

        switch (category){
            case First:
                receipt.setNumberOfBaggageFirstClass(receipt.getNumberOfBaggageFirstClass() + value);
                break;
            case Business:
                receipt.setNumberOfBaggageBusinessClass(receipt.getNumberOfBaggageBusinessClass() + value);
                break;
            case Economy:
                receipt.setNumberOfBaggageEconomyClass(receipt.getNumberOfBaggageEconomyClass() + value);
                break;
        }
    }
    private void increaseBaggageSortingUnitReceiptNumberOfContainers(BaggageSortingUnitReceipt receipt, ContainerCategory category) {
        switch (category){
            case First:
                receipt.increaseNumberOfContainerFirstClass();
                break;
            case Business:
                receipt.increaseNumberOfContainerBusinessClass();
                break;
            case Economy:
                receipt.increaseNumberOfContainerEconomyClass();
                break;
        }
    }

    public BaggageSortingUnitReceipt loadDestinationBoxIntoContainers() {

        BaggageSortingUnitReceipt receipt = new BaggageSortingUnitReceipt(this.destinationBox, new ArrayList<Container>()
        ,0, 0, 0, 0
        ,0, 0);

        for (ContainerCategory category : ContainerCategory.values()) {
            if ( category == ContainerCategory.SpecialGood) continue;;
            MobileHandHeldScanner handHeld = new MobileHandHeldScanner(ContainerType.AKE, this, this.baggageIdentificationTags);
            handHeld.register(this.destinationBox);
            ArrayList<BaggageIdentificationTag> baggageTags = handHeld.select(category);
            this.updateBaggageSortingUnitReceiptNumberOfBaggage(receipt, category, baggageTags.size());

            // Get a new container:
            Container container = this.getContainerForCategory(category);

            ArrayList<BaggageIdentificationTag> currentContainerBaggages = new ArrayList<BaggageIdentificationTag>();
            for (int i = 0; i < baggageTags.size(); i++ ){
                if(currentContainerBaggages.size() == 50) {
                    // TODO Check for available vehicle
                    handHeld.orderRoboterToLoad(currentContainerBaggages, container, this.baggageVehicleList.remove(0));
                    this.filledContainerList.add(container);
                    container = this.getContainerForCategory(category);
                    currentContainerBaggages = new ArrayList<BaggageIdentificationTag>();
                    this.increaseBaggageSortingUnitReceiptNumberOfContainers(receipt, category);

                }
                currentContainerBaggages.add(baggageTags.get(i));
            }
            if(currentContainerBaggages.size() > 0){
                // TODO Check for available vehicle
                handHeld.orderRoboterToLoad(currentContainerBaggages, container,this.baggageVehicleList.remove(0));
                this.filledContainerList.add(container);
                this.increaseBaggageSortingUnitReceiptNumberOfContainers(receipt, category);
            }
        }
        receipt.setContainerList(this.filledContainerList);
        return receipt;
    }

    private Container getContainerForCategory(ContainerCategory category) {
        // TODO Check for available Container
        Container container = this.emptyContainerList.remove(0);
        container.setCategory(category);
        return container;
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

    public LuggageTub drop(LuggageTub luggageTub, Baggage baggage) {
        luggageTub.setBaggage(baggage);
        return luggageTub;
    }

    public void throwOff(LuggageTub luggageTub, DestinationBox destinationBox) {
        destinationBox.getBaggegeList().add(luggageTub.getBaggage());
    }

    public class Port implements IBaggageSortingUnit {
        // TODO Acceptable?
        public BaggageSortingUnitReceipt execute(String position, Destination destination, ArrayList<Baggage> baggage, ArrayList<BaggageVehicle> baggageVehicles, ArrayList<BaggageIdentificationTag> baggageIdentificationTags) {
            initialize(position, destination, baggage, baggageVehicles, baggageIdentificationTags);
            return innerExecute();
        }
    }
}
