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

    public PassengerSQL(Database instance) {
        this.instance = instance;
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
        sqlStringBuilder.append("'").append(getStringfromListWithSemicolon(passenger)).append("'").append(",");
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
        sqlStringBuilder.append("baggage = '").append(getStringfromListWithSemicolon(passenger)).append("'").append(",");
        sqlStringBuilder.append("boardingpassid = '").append(passenger.getBoardingPass().getId()).append("'").append(",");
        sqlStringBuilder.append("WHERE id = '").append(passenger.getId()).append("'");
        return sqlStringBuilder.toString();
    }


    private String getStringfromListWithSemicolon(Passenger passenger) {
        boolean processedFirst = false;
        StringBuilder listbuilder = new StringBuilder();
        for (Baggage record : passenger.getBaggageList()) {
            if (processedFirst)
                listbuilder.append(";");
            listbuilder.append(BaggageSQL.getCSVFromObject(record));
            processedFirst = true;
        }
        return listbuilder.toString();
    }

    private String getStringfromListWithColon(Passenger passenger) {
        boolean processedFirst = true;
        StringBuilder listbuilder = new StringBuilder();
        for (Baggage record : passenger.getBaggageList()) {
            if (processedFirst)
                listbuilder.append("::");
            listbuilder.append(BaggageSQL.getCSVFromObject(record));
            listbuilder.append("::");
            processedFirst = false;
        }
        return listbuilder.toString();
    }


    public String getCSVfromObject(Passenger passenger) {

        StringBuilder sb = new StringBuilder();
        BoardingPass boardingPass = passenger.getBoardingPass();

        sb.append(passenger.getId()).append(",");
        sb.append(passenger.getName()).append(",");
        sb.append(passenger.getContent()).append(",");
        sb.append(passenger.getBirthDate()).append(",");
        sb.append(passenger.getStreet()).append(",");
        sb.append(passenger.getPostCode()).append(",");
        sb.append(passenger.getCity()).append(",");
        sb.append(passenger.getPicture()).append(",");
        sb.append(passenger.getVisa()).append(",");
        sb.append(passenger.getCitizenshipCode().toString()).append(",");
        sb.append(passenger.getGender().toString()).append(",");
        sb.append(getStringfromListWithColon(passenger)).append(",");
        sb.append(boardingPass.getId()).append(",");
        sb.append(boardingPass.getCarrier().toString()).append(",");
        sb.append(boardingPass.getFlight()).append(",");
        sb.append(boardingPass.getPassengerName()).append(",");
        sb.append(boardingPass.getTicketClass().toString()).append(",");
        sb.append(boardingPass.getSource().toString()).append(",");
        sb.append(boardingPass.getDestination().toString()).append(",");
        sb.append(boardingPass.getDate()).append(",");
        sb.append(boardingPass.getGate()).append(",");
        sb.append(boardingPass.getBoardingTime()).append(",");
        sb.append(boardingPass.getSeat());

        return sb.toString();
    }

    public static ArrayList<Passenger> getObjectfromCSV(String list) {
        ArrayList<Passenger> result = new ArrayList<Passenger>();
        StringBuilder sb = new StringBuilder();
        String[] objects = list.split(";");
        for (int i = 0; i < objects.length; i++) {
            String[] passengers = objects[i].split("::");
            for (int j = 1; j<passengers.length-1; j++){
                sb.append(passengers[j]).append(";");
            }
            String[] values = objects[i].split(",");
            result.add(new Passenger(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], CitizenshipCode.valueOf(values[9]), Gender.valueOf(values[10]), BaggageSQL.getObjectfromCSV(sb.toString()), new BoardingPass(values[12], Carrier.valueOf(values[13]), values[14], values[15], TicketClass.valueOf(values[16]), Source.valueOf(values[17]), Destination.valueOf(values[18]), values[19], values[20], values[21], values[22])));
        }

        return result;
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
            String passengername = rs.getString("passengername");
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

            Passenger passenger = new Passenger(uuid, name, content, birthdate, street, postcode, city, picture, visa, CitizenshipCode.valueOf(citizenship), Gender.valueOf(gender), BaggageSQL.getObjectfromCSV(baggage), new BoardingPass(boardingpassid, Carrier.valueOf(carrier), flight, passengername, TicketClass.valueOf(ticketclass), Source.valueOf(source), Destination.valueOf(destination), date, gate, boardingtime, seat));
            allbagages.add(passenger);

        }
        statement.close();

        return allbagages;
    }

}
