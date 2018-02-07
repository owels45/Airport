package sql;

import base.Baggage;
import base.BaggageType;
import base.DestinationBox;
import engine.LogEngine;
import main.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DestinationBoxSQL {

    private Database instance;

    public DestinationBoxSQL(Database instance) {
        this.instance = instance;
    }

    public void dropTableContainer(LogEngine logEngine) {
        String sqlStatement = "DROP TABLE destinationbox IF EXISTS";
        logEngine.write("main.Database", "dropTableDestinationBox", "-", sqlStatement);
        instance.update(sqlStatement);
    }

    public void createTableDestinationBox(LogEngine logEngine) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("CREATE TABLE destinationbox").append(" ( ");
        sqlStringBuilder.append("barcode VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("baggage TEXT NOT NULL").append(",");
        sqlStringBuilder.append("PRIMARY KEY (barcode)");
        sqlStringBuilder.append(")");
        logEngine.write("main.Database", "createTableDestinationBox", "-", sqlStringBuilder.toString());
        instance.update(sqlStringBuilder.toString());
    }


    public String buildInsertSQLStatement(DestinationBox box) {

        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("INSERT INTO destinationbox (barcode,baggage) VALUES (");
        sqlStringBuilder.append("'").append(box.getBarCode()).append("'").append(",");
        sqlStringBuilder.append("'").append(getStringfromList(box)).append("'");
        sqlStringBuilder.append(")");
        return sqlStringBuilder.toString();
    }

    public void insert(DestinationBox box, LogEngine logEngine) {
        System.out.println(box.hashCode());
        logEngine.write("main.Database", "insert", "DestinationBox = " + box.getBarCode(), buildInsertSQLStatement(box));
        instance.update(buildInsertSQLStatement(box));
    }

    public String buildUpdateSQLStatement(DestinationBox box) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("UPDATE destinationbox SET baggage = '").append(getStringfromList(box)).append("'").append(",");
        sqlStringBuilder.append("WHERE barcode = '").append(box.getBarCode()).append("'");
        return sqlStringBuilder.toString();
    }

    private String getStringfromList(DestinationBox box){
        boolean processedFirst = false;
        StringBuilder listbuilder = new StringBuilder();
        for (Baggage record: box.getBaggegeList()){
            if (processedFirst)
                listbuilder.append(";");
            listbuilder.append(getObjectasCSV(record));
            processedFirst = true;
        }
        return listbuilder.toString();
    }

    private String getObjectasCSV(Baggage baggage){
        StringBuilder sb = new StringBuilder();

        sb.append(baggage.getUUID()).append(",").append(baggage.getContent()).append(",").append(String.valueOf(baggage.getWeight())).append(",").append(baggage.getBaggageType().toString());
        return sb.toString();
    }

    public ArrayList<DestinationBox> buildSelectSQLStatement() throws SQLException {

        ArrayList<DestinationBox> allbagages = new ArrayList<DestinationBox>();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM baggage");
        Statement statement = instance.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sb.toString());
        while (rs.next()) {
            String barcode = rs.getString("barcode");
            String baggages = rs.getString("baggage");
            allbagages.add(new DestinationBox(barcode,getObjectfromCSV(baggages)));
        }

        statement.close();

        return allbagages;
    }

    private ArrayList<Baggage> getObjectfromCSV(String list){
        ArrayList<Baggage> result = new ArrayList<Baggage>();
        String[] objects = list.split(";");
        for (int i = 0; i< objects.length; i++){
            String[] values = objects[i].split(",");
            result.add(new Baggage(values[0],values[1],Double.parseDouble(values[2]), BaggageType.valueOf(values[3])));
        }

        return result;
    }
}