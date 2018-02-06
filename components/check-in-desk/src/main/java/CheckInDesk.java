import java.util.ArrayList;

public class CheckInDesk {
    private int id;
    private String flight;
    private Source source;
    private Destination destination;
    private String date;
    private String boardingTime;
    private String gate;
    private Employee employee;
    private ReadingDevice readingDevice;
    private int numberOfPassengersFirstClass;
    private int numberOfPassengersBusinessClass;
    private int numberOfPassengersEconomyClass;
    private int numberOfBaggage;

    private static CheckInDesk instance = new CheckInDesk();
    public Port port = new Port();

    public static CheckInDesk getInstance() {
        return instance;
    }

    private CheckInDesk() {
    }

    public class Port implements ICheckInDesk{

        public BoardingPass checkIn(Passenger passenger, ArrayList<Baggage> baggage) {
            return innerCheckIn(passenger,baggage);
        }

        public boolean scan(Passport passport) {
            return innerScan(passport);
        }

        public void print(BoardingPass boardingPass) {
            innerPrint(boardingPass);
        }

        public BaggageIdentificationTag checkIn(Baggage baggage) {
            return innerCheckIn(baggage);
        }

        public void notifyGroundOperations(CheckInDeskReceipt checkInDeskReceipt) {
            innerNotifyGroundOperations(checkInDeskReceipt);
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ReadingDevice getReadingDevice() {
        return readingDevice;
    }

    public void setReadingDevice(ReadingDevice readingDevice) {
        this.readingDevice = readingDevice;
    }

    public int getNumberOfPassengersFirstClass() {
        return numberOfPassengersFirstClass;
    }

    public void setNumberOfPassengersFirstClass(int numberOfPassengersFirstClass) {
        this.numberOfPassengersFirstClass = numberOfPassengersFirstClass;
    }

    public int getNumberOfPassengersBusinessClass() {
        return numberOfPassengersBusinessClass;
    }

    public void setNumberOfPassengersBusinessClass(int numberOfPassengersBusinessClass) {
        this.numberOfPassengersBusinessClass = numberOfPassengersBusinessClass;
    }

    public int getNumberOfPassengersEconomyClass() {
        return numberOfPassengersEconomyClass;
    }

    public void setNumberOfPassengersEconomyClass(int numberOfPassengersEconomyClass) {
        this.numberOfPassengersEconomyClass = numberOfPassengersEconomyClass;
    }

    public int getNumberOfBaggage() {
        return numberOfBaggage;
    }

    public void setNumberOfBaggage(int numberOfBaggage) {
        this.numberOfBaggage = numberOfBaggage;
    }


    public BoardingPass innerCheckIn(Passenger passenger, ArrayList<Baggage> baggage) {
        passenger.setBaggageList(baggage);
        BoardingPass boardingPass = new BoardingPass(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
        return boardingPass;
    }

    public boolean innerScan(Passport passport) {
        return true;
    }

    public void innerPrint(BoardingPass boardingPass) {

    }

    public BaggageIdentificationTag innerCheckIn(Baggage baggage) {
        BaggageIdentificationTag baggageIdentificationTag = new BaggageIdentificationTag("1",
                null,
                null,
                1,
                null,
                null,
                null,
                null,
                null,
                true,
                true,
                true,
                null);
        return baggageIdentificationTag;
    }

    public void innerNotifyGroundOperations(CheckInDeskReceipt checkInDeskReceipt) {
        Object port = ComponentLoader.loadComponent("ground-operations-center", "GroundOperationsCenter");
        try {
            port.getClass().getMethod("receive", CheckInDeskReceipt.class).invoke(port, checkInDeskReceipt);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
