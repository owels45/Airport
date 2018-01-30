import java.util.ArrayList;

public interface IDatabase{
    void initBaggage();
    ArrayList<Baggage> getAllBaggages();
    void addBaggageIdentificationTag(BaggageIdentificationTag baggageIdentificationTag);
    BaggageIdentificationTag getBaggageIdentificationTag();
    void addBoardingPass(BoardingPass boardingPass);
    BoardingPass getBoardingPass();
    void addContainer(Container container);
    Container getContainer();
    void addCottonPad(CottonPad cottonPad);
    CottonPad getCottonPad();
    void addDestinationBox(DestinationBox destinationBox);
    DestinationBox getDestinationBox();
    void addEmployee(Employee employee);
    Employee getEmployee();
    void addFlight(Flight flight);
    Flight getFlight();
    void addInvoice(Invoice invoice);
    Invoice getInvoice();
    void addPassenger(Passenger passenger);
    Passenger getPassenger();
    PassengerList getPassengerList();
    void addPassport(Passport passport);
    Passport getPassport();
    Storage getStorrage();
}