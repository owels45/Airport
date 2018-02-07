package main;

import base.*;
import engine.LogEngine;
import sql.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;

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

        public void initTables(){
            innerMethodinitTables();
        }
        
        public ArrayList<Baggage> getAllBaggages(){
            return innerMethodGetAllBaggages();
        }

        public void addBaggageIdentificationTag(BaggageIdentificationTag baggageIdentificationTag) {    //Done
            innerMethodAddBaggageIdentificationTag(baggageIdentificationTag);
        }

        public BaggageIdentificationTag getBaggageIdentificationTag(Baggage baggage) {
            return innerMethodGetBaggageIdentificationTag(baggage);
        }

        public void addBoardingPass(BoardingPass boardingPass) {                                        //Done
            innerMethodAddBoardingPass(boardingPass);
        }

        public BoardingPass getBoardingPass(Passenger passenger) {
            return innerMethodGetBoardingPass(passenger);
        }

        public void addContainer(Container container) {                                                                     //Done
            innerMethodAddContainer(container);
        }

        public ArrayList<Container> getContainer() {
            return innerMethodGetContainer();
        }

        public void addCottonPad(CottonPad cottonPad) {
            innerMethodAddCottonPad(cottonPad);
        }

        public ArrayList<CottonPad> getCottonPad() {
            return innerMethodGetCottonPad();
        }

        public void addDestinationBox(DestinationBox destinationBox) {
            innerMethodAddDestinationBox(destinationBox);
        }

        public ArrayList<DestinationBox> getDestinationBox() {
            return innerMethodGetDestinationBox();
        }

        public  void addEmployee(Employee employee) {
            innerMethodAddEmployee(employee);
        }

        public ArrayList<Employee> getEmployee() {
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
        return null;
    }

    private Storage innerMethodGetStorage() {
        init();
        ContainerSQL containerSQL = new ContainerSQL(Database.instance);
        try {
            return containerSQL.buildSelectSQLStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private ArrayList<Baggage> innerMethodGetAllBaggages() {
        init();
        BaggageSQL baggageSQL = new BaggageSQL(Database.instance);
        try {
            return baggageSQL.buildSelectSQLStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    private ArrayList<Container> innerMethodGetContainer() {
        return null;
    }

    private void innerMethodAddCottonPad(CottonPad cottonPad) {
        init();
        CottonPadSQL cottonPadSQL = new CottonPadSQL(Database.instance);
        cottonPadSQL.insert(cottonPad,logEngine);
    }

    private ArrayList<CottonPad> innerMethodGetCottonPad() {
        init();
        CottonPadSQL cottonPadSQL = new CottonPadSQL(Database.instance);
        try {
            return cottonPadSQL.buildSelectSQLStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void innerMethodAddDestinationBox(DestinationBox destinationBox) {
        DestinationBoxSQL box = new DestinationBoxSQL(Database.instance);
        box.createTableDestinationBox(logEngine);
    }

    private void innerMethodAddContainer(Container container) {
        init();
        ContainerSQL containerSQL = new ContainerSQL(Database.instance);
        containerSQL.insert(container,logEngine);
    }

    private BoardingPass innerMethodGetBoardingPass(Passenger passenger) {
        return null;
    }


    private ArrayList<DestinationBox> innerMethodGetDestinationBox() {
        init();
        DestinationBoxSQL destinationBoxSQL = new DestinationBoxSQL(Database.instance);
        try {
            return destinationBoxSQL.buildSelectSQLStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void innerMethodAddEmployee(Employee employee) {
        init();
        EmployeeSQL employeeSQL = new EmployeeSQL(Database.instance);
        employeeSQL.insert(employee,logEngine);
    }

    private ArrayList<Employee> innerMethodGetEmployee() {
        init();
        EmployeeSQL employeeSQL = new EmployeeSQL(Database.instance);
        try {
            return employeeSQL.buildSelectSQLStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void innerMethodAddFlight(Flight flight) {
        init();
        FlightSQL flightSQL = new FlightSQL(Database.instance);
        flightSQL.insert(flight,logEngine);
    }

    private Flight innerMethodGetFlight() {
        return null;
    }

    private void innerMethodAddInvoice(Invoice invoice) {
        init();
        InvoiceSQL invoiceSQL = new InvoiceSQL(Database.instance);
        invoiceSQL.insert(invoice,logEngine);
    }

    private Invoice innerMethodGetInvoice() {
        return null;
    }

    private void innerMethodAddPassenger(Passenger passenger) {
        init();
        PassengerSQL passengerSQL = new PassengerSQL(Database.instance);
        passengerSQL.insert(passenger,logEngine);
    }

    private ArrayList<Passenger> innerMethodGetAllPassenger() {
        return null;
    }

    private void innerMethodAddPassport(Passport passport) {
        init();
        PassportSQL passportSQL = new PassportSQL(Database.instance);
        passportSQL.insert(passport,logEngine);
    }

    private Passport innerMethodGetPassport() {
        return null;
    }

    private void innerMethodAddBoardingPass(BoardingPass boardingPass) {
        init();
        BoardingPassSQL boardingPassSQL = new BoardingPassSQL(Database.instance);
        boardingPassSQL.insert(boardingPass,logEngine);
    }

    private BaggageIdentificationTag innerMethodGetBaggageIdentificationTag(Baggage baggage) {
        return null;
    }

    private void innerMethodAddBaggageIdentificationTag(BaggageIdentificationTag baggageIdentificationTag) {
        init();
        BaggageIdentificationTagSQL baggageIdentificationTagSQL = new BaggageIdentificationTagSQL(Database.instance);
        baggageIdentificationTagSQL.insert(baggageIdentificationTag,logEngine);
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

    public void innerMethodinitTables(){

    }

    public void innerMethodInitBaggage() {
        BaggageSQL sql = new BaggageSQL(Database.instance);

        String csvFile = Configuration.instance.baggage_archive;
        BufferedReader br = null;
        String line = "";
        ArrayList<String> baggages = new ArrayList<String>();
        sql.dropTableBaggage(logEngine);
        sql.createTableBaggage(logEngine);


        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                for (String value: line.split(";")){
                    baggages.add(value);
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        for (int i = 0; i < baggages.size();) {
            for (int j = 1; j < baggages.size();) {
                for (int k = 2; k < baggages.size(); k += 3) {
                    Baggage baggage = new Baggage(baggages.get(i), baggages.get(j), Double.parseDouble(baggages.get(k)), BaggageType.Normal);
                    sql.insert(baggage, logEngine);
                    i+= 3;
                    j += 3;
                }
            }


        }
    }

    public void init(){
        LogEngine log = new LogEngine(Configuration.instance.logFile);
        Database.instance.innerSetLogEngine(log);
        Database.instance.startup(Configuration.instance.dataPath);
    }

    public static void main(String... args) {

        LogEngine log = new LogEngine(Configuration.instance.logFile);
        ArrayList<Baggage> list = new ArrayList<Baggage>();

        Database.instance.innerSetLogEngine(log);
        Database.instance.startup(Configuration.instance.dataPath);
        PassengerSQL passengerSQL = new PassengerSQL(Database.instance);
        String objects = "Baggage{UUID='1', content='ok', weight=15.0, baggageType=Normal};Baggage{UUID='2', content='ok', weight=18.0, baggageType=Normal}";

        //Database.instance.innerMethodInitBaggage();
        /*
        ArrayList<Baggage> bag = sql.buildSelectSQLStatement();
        for (int i = 0; i < bag.size(); i++)
        {
            System.out.println(bag.get(i));
        }

        */
        Database.instance.shutdown();

    }
}