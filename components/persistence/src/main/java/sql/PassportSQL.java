package sql;

import base.Baggage;
import base.Passenger;
import base.Passport;
import engine.LogEngine;
import main.Database;

public class PassportSQL {

    private Database instance;

    public PassportSQL (Database instance){
        this.instance = instance;
    }

    public void dropTablePassport(LogEngine logEngine) {
        String sqlStatement = "DROP TABLE passport IF EXISTS";
        logEngine.write("main.Database", "dropTableBaggage", "-", sqlStatement);
        instance.update(sqlStatement);
    }

    public void createTableBaggage(LogEngine logEngine) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("CREATE TABLE passport").append(" ( ");
        sqlStringBuilder.append("id VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("picture VARCHAR(50000) NOT NULL").append(",");
        sqlStringBuilder.append("visa INT NOT NULL").append(",");
        sqlStringBuilder.append("PRIMARY KEY (id)");
        sqlStringBuilder.append(" )");
        logEngine.write("main.Database", "createTablePassport", "-", sqlStringBuilder.toString());
        instance.update(sqlStringBuilder.toString());
    }


    public String buildInsertSQLStatement(Passport passport) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("INSERT INTO passport (id,picture,visa) VALUES (");
        sqlStringBuilder.append("'").append(passport.getId()).append("'").append(",");
        sqlStringBuilder.append("'").append(passport.getPicture()).append("'").append(",");
        sqlStringBuilder.append(passport.getVisa()).append("'");
        sqlStringBuilder.append(")");
        return sqlStringBuilder.toString();
    }

    public void insert(Passport passport, LogEngine logEngine) {
        System.out.println(passport.hashCode());
        logEngine.write("main.Database", "insert", "baggage = " + passport.getId(), buildInsertSQLStatement(passport));
        instance.update(buildInsertSQLStatement(passport));
    }

    public String buildUpdateSQLStatement(Passport passport) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("UPDATE baggage SET picture = '").append(passport.getPicture()).append("'").append(",");
        sqlStringBuilder.append("visa = ").append(passport.getVisa()).append(",");
        sqlStringBuilder.append("WHERE id = '").append(passport.getId()).append("'");
        return sqlStringBuilder.toString();
    }
}
