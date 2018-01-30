import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class Database {
    private LogEngine logEngine;

    private Connection connection;
    private String driverName = "jdbc:hsqldb:";
    private String username = "sa";
    private String password = "";

    private static Database instance = new Database();
    public Port port;

    private Database() {
        port = new Port();
    }

    public static Database getInstance() {
        return instance;
    }

    public class Port implements IDatabase {
        public void initBaggage() {
            innerMethodInitBaggage();
        }
    }

    public void startup(String dataPath) {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            String databaseURL = driverName + dataPath + "records.db";
            connection = DriverManager.getConnection(databaseURL,username,password);
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

    public void dropTableBaggage() {
        String sqlStatement = "DROP TABLE baggage IF EXISTS";
        logEngine.write("Database","dropTableBaggage","-",sqlStatement);
        update(sqlStatement);
    }

    public void createTableBaggage() {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("CREATE TABLE baggage").append(" ( ");
        sqlStringBuilder.append("uuid VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("content VARCHAR(50000) NOT NULL").append(",");
        sqlStringBuilder.append("weight INT NOT NULL").append(",");
        sqlStringBuilder.append("PRIMARY KEY (uuid)");
        sqlStringBuilder.append(" )");
        logEngine.write("Database","createTableBaggage","-",sqlStringBuilder.toString());
        update(sqlStringBuilder.toString());
    }


    public String buildInsertSQLStatement(Baggage baggage) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("INSERT INTO baggage (uuid,content,weight) VALUES (");
        sqlStringBuilder.append("'").append(baggage.getUUID()).append("'").append(",");
        sqlStringBuilder.append("'").append(baggage.getContent()).append("'").append(",");
        sqlStringBuilder.append(baggage.getWeight());
        sqlStringBuilder.append(")");
        return sqlStringBuilder.toString();
    }

    public void insert(Baggage baggage) {
        logEngine.write("Database","insert","baggage = " + baggage.getUUID(),buildInsertSQLStatement(baggage));
        update(buildInsertSQLStatement(baggage));
    }

    public String buildUpdateSQLStatement(Baggage baggage) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("UPDATE baggage SET content = '").append(baggage.getContent()).append("'").append(",");
        sqlStringBuilder.append("weight = ").append(baggage.getWeight()).append(",");
        sqlStringBuilder.append("WHERE uuid = '").append(baggage.getUUID()).append("'");
        return sqlStringBuilder.toString();
    }


    public void innerMethodInitBaggage() {
        String csvFile = "/Airport/data/baggage.csv";
        BufferedReader br = null;
        String line = "";
        ArrayList<String> baggages = new ArrayList<>();
        dropTableBaggage();
        createTableBaggage();


        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                baggages.add(Arrays.toString(line.split(";")));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        for (int i = 0; i< baggages.size(); i=+3){
            for(int j = 1; j<baggages.size(); j=+3){
                for (int k= 2; k<baggages.size(); k=+3){
                    Baggage baggage = new Baggage(baggages.get(i), baggages.get(j),Double.parseDouble(baggages.get(k)));
                    insert(baggage);
                }
            }


        }
    }
}