package main;

import base.*;
import engine.LogEngine;
import sql.BaggageSQL;
import sql.ContainerSQL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class Database {
    private LogEngine logEngine;

    private Connection connection;
    private String driverName = "jdbc:hsqldb:";
    private String username = "sa";
    private String password = "";

    private static Database instance = new Database();
    public Port port;

    public Database() {
        port = new Port();
    }

    public static Database getInstance() {
        return instance;
    }

    public class Port implements IDatabase {
        public void initBaggage() {

            innerMethodInitBaggage();
        }
        
        public ArrayList<Baggage> getAllBaggages(){
            return innerMethodGetAllBaggages();
        }

        public void addBaggageIdentificationTag(BaggageIdentificationTag baggageIdentificationTag) {
            innerMethodAddBaggageIdentificationTag(baggageIdentificationTag);
        }

        public BaggageIdentificationTag getBaggageIdentificationTag(Baggage baggage) {
            return innerMethodGetBaggageIdentificationTag(baggage);
        }

        public void addBoardingPass(BoardingPass boardingPass) {
            innerMethodAddBoardingPass(boardingPass);
        }

        public BoardingPass getBoardingPass(Passenger passenger) {
            return innerMethodGetBoardingPass(passenger);
        }

        public void addContainer(Container container) {
            innerMethodAddContainer(container);
        }

        public Container getContainer() {
            return innerMethodGetContainer();
        }

        public void addCottonPad(CottonPad cottonPad) {
            innerMethodAddCottonPad(cottonPad);
        }

        public CottonPad getCottonPad() {
            return innerMethodGetCottonPad();
        }

        public void addDestinationBox(DestinationBox destinationBox) {
            innerMethodAddDestinationBox(destinationBox);
        }

        public DestinationBox getDestinationBox() {
            return innerMethodGetDestinationBox();
        }

        public  void addEmployee(Employee employee) {
            innerMethodAddEmployee(employee);
        }

        public Employee getEmployee() {
            return innerMethodGetEmployee();
        }

        public void addFlight(Flight flight) {
            innerMethodAddFlight(flight);
        }

        public Flight getFlight() {
            return innerMethodGetFlight();
        }

        public void addInvoice(Invoice invoice) {
            innerMethodAddInvoice(invoice);
        }

        public Invoice getInvoice() {
            return innerMethodGetInvoice();
        }

        public void addPassenger(Passenger passenger) {
            innerMethodAddPassenger(passenger);
        }

        public ArrayList<Passenger> getAllPassenger() {
            return innerMethodGetAllPassenger();
        }

        public void addPassport(Passport passport) {
            innerMethodAddPassport(passport);
        }

        public Passport getPassport() {
            return innerMethodGetPassport();
        }

        public Storage getStorrage() {
            return innerMethodGetStorage();
        }

        public void setLogEngine(LogEngine logEngine) {
            innerSetLogEngine(logEngine);
        }

        public PassengerList getPassengerList(){
            return innerMethodGetPassengerList();
        }
    }

    private PassengerList innerMethodGetPassengerList() {
    }

    private Storage innerMethodGetStorage() {
    }

    private ArrayList<Baggage> innerMethodGetAllBaggages() {
    }


    private Container innerMethodGetContainer() {
    }

    private void innerMethodAddCottonPad(CottonPad cottonPad) {
    }

    private CottonPad innerMethodGetCottonPad() {
    }

    private void innerMethodAddDestinationBox(DestinationBox destinationBox) {
    }

    private void innerMethodAddContainer(Container container) {
        ContainerSQL sql = new ContainerSQL();
    }

    private BoardingPass innerMethodGetBoardingPass(Passenger passenger) {
    }

    private DestinationBox innerMethodGetDestinationBox() {
    }

    private void innerMethodAddEmployee(Employee employee) {
    }

    private Employee innerMethodGetEmployee() {
    }

    private void innerMethodAddFlight(Flight flight) {
    }

    private Flight innerMethodGetFlight() {
    }

    private void innerMethodAddInvoice(Invoice invoice) {
    }

    private Invoice innerMethodGetInvoice() {
    }

    private void innerMethodAddPassenger(Passenger passenger) {
    }

    private ArrayList<Passenger> innerMethodGetAllPassenger() {
    }

    private void innerMethodAddPassport(Passport passport) {
    }

    private Passport innerMethodGetPassport() {
    }

    private void innerMethodAddBoardingPass(BoardingPass boardingPass) {
    }

    private BaggageIdentificationTag innerMethodGetBaggageIdentificationTag(Baggage baggage) {
        return
    }

    private void innerMethodAddBaggageIdentificationTag(BaggageIdentificationTag baggageIdentificationTag) {
    }

    //Essentials
    public Connection getConnection() {
        return connection;
    }

    public void startup(String dataPath) {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            String databaseURL = driverName + dataPath + "records.db";
            connection = DriverManager.getConnection(databaseURL, username, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void shutdown() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("SHUTDOWN");
            connection.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public synchronized void update(String sqlStatement) {
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sqlStatement);
            if (result == -1)
                System.out.println("error executing " + sqlStatement);
            statement.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }



    public void innerSetLogEngine(LogEngine logEngine) {
        this.logEngine = logEngine;
    }

    public void innerMethodInitBaggage() {
        BaggageSQL sql = new BaggageSQL();

        String csvFile = Configuration.instance.baggage_archive;
        BufferedReader br = null;
        String line = "";
        ArrayList<String> baggages = new ArrayList<String>();
        sql.dropTableBaggage(logEngine);
        sql.createTableBaggage(logEngine);


        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                baggages.add(Arrays.toString(line.split(";")));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        for (int i = 0; i < baggages.size(); i = +3) {
            for (int j = 1; j < baggages.size(); j = +3) {
                for (int k = 2; k < baggages.size(); k = +3) {
                    Baggage baggage = new Baggage(baggages.get(i), baggages.get(j), Double.parseDouble(baggages.get(k)), BaggageType.Normal);
                    sql.insert(baggage, logEngine);
                }
            }


        }
    }

    public static void main(String... args) {

        BaggageSQL sql = new BaggageSQL();

        Database.instance.innerSetLogEngine(new LogEngine(Configuration.instance.logFile));
        Database.instance.startup(Configuration.instance.dataPath);
        sql.dropTableBaggage(logEngine);
        sql.createTableBaggage(logEngine);

        Baggage baggage = new Baggage(UUID.randomUUID().toString(), "aljslskfasluioulfjkj", 2, BaggageType.Normal);
        sql.insert(baggage, logEngine);

        Database.instance.shutdown();
    }
}