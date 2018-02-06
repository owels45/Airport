package sql;

import base.Baggage;
import base.DestinationBox;
import engine.LogEngine;
import main.Database;

import java.util.List;

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
        sqlStringBuilder.append("baggage VARCHAR(36) NOT NULL").append(",");
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
                listbuilder.append(",");
            listbuilder.append(record);
        }
        return listbuilder.toString();
    }
}