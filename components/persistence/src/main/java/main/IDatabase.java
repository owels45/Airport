package main;

import base.*;

import java.util.ArrayList;

public interface IDatabase{
    void initBaggage();
    void initTables();
    ArrayList<Baggage> getAllBaggages();
    void addBaggageIdentificationTag(BaggageIdentificationTag baggageIdentificationTag);
    BaggageIdentificationTag getBaggageIdentificationTag(Baggage baggage);
    void addBoardingPass(BoardingPass boardingPass);
    BoardingPass getBoardingPass(Passenger passenger);
    void addContainer(Container container);
    ArrayList<Container> getContainer();
    void addCottonPad(CottonPad cottonPad);
    ArrayList<CottonPad> getCottonPad();
    void addDestinationBox(DestinationBox destinationBox);
    ArrayList<DestinationBox> getDestinationBox();
    void addEmployee(Employee employee);
    ArrayList<Employee> getEmployee();
    void addFlight(Flight flight);
    Flight getFlight();
    void addInvoice(Invoice invoice);
    Invoice getInvoice();
    void addPassenger(Passenger passenger);
    ArrayList<Passenger> getAllPassenger();
    PassengerList getPassengerList();
    void addPassport(Passport passport);
    Passport getPassport();
    Storage getStorrage();
}