package sql;

import base.Passenger;
import base.Passport;
import engine.LogEngine;
import main.Database;

public class PassportSQL {

    private Database instance;

    public PassportSQL (Database instance){
        this.instance = instance;
    }

    public void dropTableBaggage(LogEngine logEngine) {
        String sqlStatement = "DROP TABLE passport IF EXISTS";
        logEngine.write("main.Database", "dropTablePassport", "-", sqlStatement);
        instance.update(sqlStatement);
    }

    public void createTableBaggage(LogEngine logEngine) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("CREATE TABLE passport").append(" ( ");
        sqlStringBuilder.append("id VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("picture TEXT NOT NULL").append(",");
        sqlStringBuilder.append("visa TEXT NOT NULL").append(",");
        sqlStringBuilder.append("passengerid VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("PRIMARY KEY (id)");
        sqlStringBuilder.append(")");
        logEngine.write("main.Database", "createTablePassport", "-", sqlStringBuilder.toString());
        instance.update(sqlStringBuilder.toString());
    }

    public String buildInsertSQLStatement(Passport passport, Passenger passenger) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("INSERT INTO baggage (id,picture,visa,passengerid) VALUES (");
        sqlStringBuilder.append("'").append(passport.getId()).append("'").append(",");
        sqlStringBuilder.append("'").append(passport.getPicture()).append("'").append(",");
        sqlStringBuilder.append("'").append(passport.getVisa()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getId()).append("'").append(",");
        sqlStringBuilder.append(")");
        return sqlStringBuilder.toString();
    }

    public void insert(Passport passport,Passenger passenger, LogEngine logEngine) {
        System.out.println(passport.hashCode());
        logEngine.write("main.Database", "insert", "baggage = " + passport.getId(), buildInsertSQLStatement(passport,passenger));
        instance.update(buildInsertSQLStatement(passport,passenger));
    }

    public String buildUpdateSQLStatement(Passport passport, Passenger passenger) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("UPDATE passport SET picture = '").append(passport.getPicture()).append("'").append(",");
        sqlStringBuilder.append("visa = '").append(passport.getVisa()).append("'").append(",");
        sqlStringBuilder.append("passengerid = '").append(passenger.getId()).append("'").append(",");
        sqlStringBuilder.append("WHERE id = '").append(passport.getId()).append("'");
        return sqlStringBuilder.toString();
    }
}
