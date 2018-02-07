package sql;

import base.*;
import engine.LogEngine;
import main.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
        sqlStringBuilder.append("picture TEXT NOT NULL").append(",");
        sqlStringBuilder.append("visa TEXT NOT NULL").append(",");
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
        sqlStringBuilder.append("INSERT INTO storage (id,name,content,birthdate,street,postcode,city,picture,visa,citizenship,gender,baggage,boardingpassid) VALUES (");
        sqlStringBuilder.append("'").append(passenger.getId()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getName()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getContent()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getBirthDate()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getStreet()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getPostCode()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getCity()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getPicture()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getVisa()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getCitizenshipCode().toString()).append("'").append(",");
        sqlStringBuilder.append("'").append(passenger.getGender().toString()).append("'").append(",");
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
        sqlStringBuilder.append("picture = '").append(passenger.getPicture()).append("'").append(",");
        sqlStringBuilder.append("picture = '").append(passenger.getVisa()).append("'").append(",");
        sqlStringBuilder.append("citizenship = '").append(passenger.getCitizenshipCode().toString()).append("'").append(",");
        sqlStringBuilder.append("gender = '").append(passenger.getGender().toString()).append("'").append(",");
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
                listbuilder.append(";");
            listbuilder.append(BaggageSQL.getCSVFromObject(record));
            processedFirst = true;
        }
        return listbuilder.toString();
    }

    public ArrayList<Passenger> buildSelectSQLStatement() throws SQLException {

        ArrayList<Passenger> allbagages = new ArrayList<Passenger>();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM passenger INNER JOIN boardingpass ON passenger.boardingpassid=boardingpass.id");
        Statement statement = instance.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sb.toString());
        while (rs.next()) {
            String uuid = rs.getString("passenger.id");
            String carrier = rs.getString("carrier");
            String flight = rs.getString("flight");
            String ticketclass = rs.getString("ticketclass");
            String source = rs.getString("source");
            String destination = rs.getString("destination");
            String date = rs.getString("date");
            String gate = rs.getString("gate");
            String boardingtime = rs.getString("boardingtime");
            String seat = rs.getString("seat");
            String boardingpassid = rs.getString("boardingpass.id");
            String name = rs.getString("name");
            String content = rs.getString("content");
            String birthdate = rs.getString("birthdate");
            String street = rs.getString("street");
            String postcode = rs.getString("postcode");
            String city = rs.getString("city");
            String citizenship = rs.getString("citizenship");
            String gender = rs.getString("gender");
            String baggage = rs.getString("baggage");
            String picture = rs.getString("picture");
            String visa = rs.getString("visa");

            Passenger passenger = new Passenger(uuid,name,content,birthdate,street,postcode,city,picture,visa,CitizenshipCode.valueOf(citizenship),Gender.valueOf(gender),BaggageSQL.getObjectfromCSV(baggage),null);
            BoardingPass boardingPass = new BoardingPass(boardingpassid, Carrier.valueOf(carrier),flight,passenger, TicketClass.valueOf(ticketclass),Source.valueOf(source),Destination.valueOf(destination),date,gate,boardingtime,seat);

            passenger.setBoardingPass(boardingPass);
            allbagages.add(passenger);

        }
        statement.close();

        return allbagages;
    }

}
