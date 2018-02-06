package sql;

import base.BoardingPass;
import base.Passenger;
import engine.LogEngine;
import main.Database;

public class BoardingPassSQL {

    private Database instance;

    public BoardingPassSQL(Database instance) {
        this.instance = instance;
    }

    public void dropTableBoardingPass(LogEngine logEngine) {
        String sqlStatement = "DROP TABLE boardingpass IF EXISTS";
        logEngine.write("main.Database", "dropTableBoardingPass", "-", sqlStatement);
        instance.update(sqlStatement);
    }

    public void createTableBoardingPass(LogEngine logEngine) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("CREATE TABLE boardingpass").append(" ( ");
        sqlStringBuilder.append("uuid VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("carrier TEXT NOT NULL").append(",");
        sqlStringBuilder.append("ticketclass TEXT NOT NULL").append(",");
        sqlStringBuilder.append("source TEXT NOT NULL").append(",");
        sqlStringBuilder.append("destination TEXT NOT NULL").append(",");
        sqlStringBuilder.append("date TEXT NOT NULL").append(",");
        sqlStringBuilder.append("gate TEXT NOT NULL").append(",");
        sqlStringBuilder.append("boardingtime TEXT NOT NULL").append(",");
        sqlStringBuilder.append("seat TEXT NOT NULL").append(",");
        sqlStringBuilder.append("passengerid VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("PRIMARY KEY (uuid)");
        sqlStringBuilder.append(" )");
        logEngine.write("main.Database", "createTableBoardingPass", "-", sqlStringBuilder.toString());
        instance.update(sqlStringBuilder.toString());
    }

    public String buildInsertSQLStatement(BoardingPass boardingPass){
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("INSERT INTO boardingpass (uuid,carrier,ticketclass,source,destination,date,gate,boardingtime,seat,passengerid) VALUES (");
        sqlStringBuilder.append("'").append(boardingPass.getId()).append("'").append(",");
        sqlStringBuilder.append("'").append(boardingPass.getCarrier().toString()).append("'").append(",");
        sqlStringBuilder.append("'").append(boardingPass.getTicketClass().toString()).append("'").append(",");
        sqlStringBuilder.append("'").append(boardingPass.getSource().toString()).append("'").append(",");
        sqlStringBuilder.append("'").append(boardingPass.getDestination().toString()).append("'").append(",");
        sqlStringBuilder.append("'").append(boardingPass.getDate()).append("'").append(",");
        sqlStringBuilder.append("'").append(boardingPass.getGate()).append("'").append(",");
        sqlStringBuilder.append("'").append(boardingPass.getBoardingTime()).append("'").append(",");
        sqlStringBuilder.append("'").append(boardingPass.getSeat()).append("'").append(",");
        sqlStringBuilder.append("'").append(boardingPass.getPassenger().getId()).append("'");
        sqlStringBuilder.append(")");
        return sqlStringBuilder.toString();
    }

    public void insert(BoardingPass boardingPass, Passenger passenger, LogEngine logEngine) {
        System.out.println(boardingPass.hashCode());
        logEngine.write("main.Database", "insert", "baggage = " + boardingPass.getId(), buildInsertSQLStatement(boardingPass));
        instance.update(buildInsertSQLStatement(boardingPass));
    }

    public String buildUpdateSQLStatement(BoardingPass boardingPass){
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("UPDATE boardingpass SET carrier = '").append(boardingPass.getCarrier().toString()).append("'").append(",");
        sqlStringBuilder.append("ticketclass = ").append(boardingPass.getTicketClass().toString()).append(",");
        sqlStringBuilder.append("source = ").append(boardingPass.getSource().toString()).append(",");
        sqlStringBuilder.append("destination = ").append(boardingPass.getDestination().toString()).append(",");
        sqlStringBuilder.append("date = ").append(boardingPass.getDate()).append(",");
        sqlStringBuilder.append("gate = ").append(boardingPass.getGate()).append(",");
        sqlStringBuilder.append("boardingtime = ").append(boardingPass.getBoardingTime()).append(",");
        sqlStringBuilder.append("seat = ").append(boardingPass.getSeat()).append(",");
        sqlStringBuilder.append("passengerid = ").append(boardingPass.getPassenger().getId()).append(",");
        sqlStringBuilder.append("WHERE uuid = '").append(boardingPass.getId()).append("'");
        return sqlStringBuilder.toString();
    }





}
