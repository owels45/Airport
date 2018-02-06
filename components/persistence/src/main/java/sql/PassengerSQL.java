package sql;

import base.Baggage;
import base.Passenger;
import engine.LogEngine;
import main.Database;

public class PassengerSQL {

    private Database instance;

    public PassengerSQL(Database instance){
        this.instance =  instance;
    }

    public void dropTableStorage(LogEngine logEngine) {
        String sqlStatement = "DROP TABLE passenger IF EXISTS";
        logEngine.write("main.Database", "dropTablePassenger", "-", sqlStatement);
        instance.update(sqlStatement);
    }

    public void createTablePassenger(LogEngine logEngine) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("CREATE TABLE passenger").append(" ( ");
        sqlStringBuilder.append("id VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("name TEXT NOT NULL").append(",");
        sqlStringBuilder.append("content TEXT NOT NULL").append(",");
        sqlStringBuilder.append("birthdate TEXT NOT NULL").append(",");
        sqlStringBuilder.append("street TEXT NOT NULL").append(",");
        sqlStringBuilder.append("postcode TEXT NOT NULL").append(",");
        sqlStringBuilder.append("city TEXT NOT NULL").append(",");
        sqlStringBuilder.append("citizenship TEXT NOT NULL").append(",");
        sqlStringBuilder.append("gender TEXT NOT NULL").append(",");
        sqlStringBuilder.append("passportid VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("baggage TEXT NOT NULL").append(",");
        sqlStringBuilder.append("boardingpassid VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("PRIMARY KEY (id)");
        sqlStringBuilder.append(")");
        logEngine.write("main.Database", "createTablePassenger", "-", sqlStringBuilder.toString());
        instance.update(sqlStringBuilder.toString());
    }

    public String buildInsertSQLStatement(Passenger passenger) {

        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("INSERT INTO storage (id,name,content,birthdate,street,postcode,city,citizenship,gender,passportid,baggage,boardingpassid) VALUES (");
        sqlStringBuilder.append("'").append(passenger.getId()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getName()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getContent()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getBirthDate()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getStreet()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getPostCode()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getCity()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getCitizenshipCode().toString()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getGender().toString()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getPassport().getId()).append("'").append(",");
        sqlStringBuilder.append("'").append(getStringfromList(passenger)).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getBoardingPass().getId()).append("'");
        sqlStringBuilder.append(")");
        return sqlStringBuilder.toString();
    }

    public void insert(Passenger passenger, LogEngine logEngine) {
        System.out.println(passenger.hashCode());
        logEngine.write("main.Database", "insert", "Passenger = " + passenger.getId(), buildInsertSQLStatement(passenger));
        instance.update(buildInsertSQLStatement(passenger));
    }

    public String buildUpdateSQLStatement(Passenger passenger) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("UPDATE storage SET name = '").append(passenger.getName()).append("'").append(",");
        sqlStringBuilder.append("content = '").append(passenger.getContent()).append("'").append(",");
        sqlStringBuilder.append("birthdate = '").append(passenger.getBirthDate()).append("'").append(",");
        sqlStringBuilder.append("street = '").append(passenger.getStreet()).append("'").append(",");
        sqlStringBuilder.append("postcode = '").append(passenger.getPostCode()).append("'").append(",");
        sqlStringBuilder.append("city = '").append(passenger.getCity()).append("'").append(",");
        sqlStringBuilder.append("citizenship = '").append(passenger.getCitizenshipCode().toString()).append("'").append(",");
        sqlStringBuilder.append("gender = '").append(passenger.getGender().toString()).append("'").append(",");
        sqlStringBuilder.append("passportid = '").append(passenger.getPassport().getId()).append("'").append(",");
        sqlStringBuilder.append("baggage = '").append(getStringfromList(passenger)).append("'").append(",");
        sqlStringBuilder.append("boardingpassid = '").append(passenger.getBoardingPass().getId()).append("'").append(",");
        sqlStringBuilder.append("WHERE id = '").append(passenger.getId()).append("'");
        return sqlStringBuilder.toString();
    }



    private String getStringfromList(Passenger passenger){
        boolean processedFirst = false;
        StringBuilder listbuilder = new StringBuilder();
        for (Baggage record: passenger.getBaggageList()){
            if (processedFirst)
                listbuilder.append(",");
            listbuilder.append(record);
            processedFirst = true;
        }
        return listbuilder.toString();
    }

}
