package sql;

import base.Baggage;
import base.BaggageIdentificationTag;
import base.BoardingPass;
import engine.LogEngine;
import main.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaggageIdentificationTagSQL {
    Database instance = new Database();

    public void dropTableBaggageIdentificationTag(LogEngine logEngine) {
        String sqlStatement = "DROP TABLE BaggageIdentificationTag IF EXISTS";
        logEngine.write("main.Database", "dropTableBaggageIdentificationTag", "-", sqlStatement);
        instance.update(sqlStatement);
    }

    public void createTableBaggageIdentificationTag(LogEngine logEngine) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("CREATE TABLE baggageIdentificationTag").append(" ( ");
        sqlStringBuilder.append("id TEXT NOT NULL").append(",");
        sqlStringBuilder.append("boardingPassid VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("carrier TEXT NOT NULL").append(",");
        sqlStringBuilder.append("sequence INT NOT NULL").append(",");
        sqlStringBuilder.append("via01 TEXT NOT NULL").append(",");
        sqlStringBuilder.append("via02 TEXT NOT NULL").append(",");
        sqlStringBuilder.append("via03 TEXT NOT NULL").append(",");
        sqlStringBuilder.append("baggageid TEXT NOT NULL").append(",");
        sqlStringBuilder.append("isLocal TEXT NOT NULL").append(",");
        sqlStringBuilder.append("isTransfer TEXT NOT NULL").append(",");
        sqlStringBuilder.append("isTransferFirst TEXT NOT NULL").append(",");
        sqlStringBuilder.append("barCode TEXT NOT NULL");
        sqlStringBuilder.append("PRIMARY KEY (id)");
        sqlStringBuilder.append(" )");
        logEngine.write("main.Database", "createTableBaggageIdentificationTag", "-", sqlStringBuilder.toString());
        instance.update(sqlStringBuilder.toString());
    }


    public String buildInsertSQLStatement(BaggageIdentificationTag baggageIdentificationTag) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("INSERT INTO baggageIdentificationTag (id,boardingPassid,carrier,sequence,via01,via02,via03,baggageid,specialGood,isLocal,isTransfer,isTransferFirst,barCode) VALUES (");
        sqlStringBuilder.append("'").append(baggageIdentificationTag.getId()).append("'").append(",");
        sqlStringBuilder.append("'").append(baggageIdentificationTag.getBoardingPass().getId()).append("'").append(",");
        sqlStringBuilder.append("'").append(baggageIdentificationTag.getCarrier().toString()).append("'").append(",");
        sqlStringBuilder.append("'").append(baggageIdentificationTag.getSequence()).append("'").append(",");
        sqlStringBuilder.append("'").append(baggageIdentificationTag.getVia01()).append("'").append(",");
        sqlStringBuilder.append("'").append(baggageIdentificationTag.getVia02()).append("'").append(",");
        sqlStringBuilder.append("'").append(baggageIdentificationTag.getVia03()).append("'").append(",");
        sqlStringBuilder.append("'").append(baggageIdentificationTag.getBaggage().getUUID()).append("'").append(",");
        sqlStringBuilder.append("'").append(baggageIdentificationTag.getSpecialGood().getSpecialGoodType()).append("'").append(",");
        sqlStringBuilder.append("'").append(baggageIdentificationTag.isLocal()).append("'").append(",");
        sqlStringBuilder.append("'").append(baggageIdentificationTag.isTransfer()).append("'").append(",");
        sqlStringBuilder.append("'").append(baggageIdentificationTag.isTransferFirst()).append("'").append(",");
        sqlStringBuilder.append("'").append(baggageIdentificationTag.getBarCode()).append("'");
        sqlStringBuilder.append(")");
        return sqlStringBuilder.toString();
    }

    public void insert(BaggageIdentificationTag baggageIdentificationTag, LogEngine logEngine) {
        logEngine.write("main.Database", "insert", "BaggageIdentificationTag = " + baggageIdentificationTag.getId(), buildInsertSQLStatement(baggageIdentificationTag));
        instance.update(buildInsertSQLStatement(baggageIdentificationTag));
    }

    public String buildUpdateSQLStatement(BaggageIdentificationTag baggageIdentificationTag) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("UPDATE baggageIdentificationTag SET boardingPassid = '").append(baggageIdentificationTag.getBoardingPass().getId()).append("'").append(",");
        sqlStringBuilder.append("carrier = ").append(baggageIdentificationTag.getCarrier().toString()).append(",");
        sqlStringBuilder.append("sequence = ").append(baggageIdentificationTag.getSequence()).append(",");
        sqlStringBuilder.append("via01 = ").append(baggageIdentificationTag.getVia01()).append(",");
        sqlStringBuilder.append("via02 = ").append(baggageIdentificationTag.getVia02()).append(",");
        sqlStringBuilder.append("via03 = ").append(baggageIdentificationTag.getVia03()).append(",");
        sqlStringBuilder.append("baggageid = ").append(baggageIdentificationTag.getBaggage().getUUID()).append(",");
        sqlStringBuilder.append("specialGood = ").append(baggageIdentificationTag.getSpecialGood().getSpecialGoodType()).append(",");
        sqlStringBuilder.append("isLocal = ").append(baggageIdentificationTag.isLocal()).append(",");
        sqlStringBuilder.append("isTransfer = ").append(baggageIdentificationTag.isTransfer()).append(",");
        sqlStringBuilder.append("isTransferFirst = ").append(baggageIdentificationTag.isTransferFirst()).append(",");
        sqlStringBuilder.append("barCode = ").append(baggageIdentificationTag.getBarCode()).append(",");
        sqlStringBuilder.append("WHERE id = '").append(baggageIdentificationTag.getId()).append("'");
        return sqlStringBuilder.toString();
    }

    /*
    public BaggageIdentificationTag buildSelectSQLStatement (Baggage baggage) throws SQLException {

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM baggageIdentificationTag WHERE baggage=").append("'").append(baggage.getUUID()).append("'");
        Statement statement = instance.getConnection().createStatement();
        ResultSet result = statement.executeQuery(sb.toString());
        while (result.next()){

            //BaggageIdentificationTag baggageIdentificationTag = new BaggageIdentificationTag("3",)

        }
    }
    */
}

