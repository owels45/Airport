package sql;

import base.Invoice;
import base.Passenger;
import engine.LogEngine;
import main.Database;
import org.junit.experimental.theories.internal.ParameterizedAssertionError;

public class InvoiceSQL {

    private Database instance;

    public InvoiceSQL (Database instance){
        this.instance = instance;
    }

    public void dropTableInvoice(LogEngine logEngine) {
        String sqlStatement = "DROP TABLE invoice IF EXISTS";
        logEngine.write("main.Database", "dropTableInvoice", "-", sqlStatement);
        instance.update(sqlStatement);
    }

    public void createTableInvoice(LogEngine logEngine) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("CREATE TABLE invoice").append(" ( ");
        sqlStringBuilder.append("id VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("date TEXT NOT NULL").append(",");
        sqlStringBuilder.append("passengerid VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("numberofgoods INT NOT NULL").append(",");
        sqlStringBuilder.append("amount INT NOT NULL").append(",");
        sqlStringBuilder.append("PRIMARY KEY (id)");
        sqlStringBuilder.append(")");
        logEngine.write("main.Database", "createTableInvoice", "-", sqlStringBuilder.toString());
        instance.update(sqlStringBuilder.toString());
    }

    public String buildInsertSQLStatement(Invoice invoice) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("INSERT INTO baggage (id,date,passengerid,numberofgoods,amount) VALUES (");
        sqlStringBuilder.append("'").append(invoice.getId()).append("'").append(",");
        sqlStringBuilder.append("'").append(invoice.getDate()).append("'").append(",");
        sqlStringBuilder.append("'").append(invoice.getPassenger().getId()).append("'").append(",");
        sqlStringBuilder.append("'").append(invoice.getNumberOfGoods()).append("'").append(",");
        sqlStringBuilder.append("'").append(invoice.getAmount()).append("'");
        sqlStringBuilder.append(")");
        return sqlStringBuilder.toString();
    }

    public void insert(Invoice invoice,Passenger passenger, LogEngine logEngine) {
        System.out.println(invoice.hashCode());
        logEngine.write("main.Database", "insert", "baggage = " + invoice.getId(), buildInsertSQLStatement(invoice));
        instance.update(buildInsertSQLStatement(invoice));
    }

    public String buildUpdateSQLStatement(Invoice invoice) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("UPDATE invoice SET date = '").append(invoice.getDate()).append("'").append(",");
        sqlStringBuilder.append("passengerid = '").append(invoice.getPassenger().getId()).append("'").append(",");
        sqlStringBuilder.append("numberofgoods = '").append(invoice.getNumberOfGoods()).append("'").append(",");
        sqlStringBuilder.append("amount = '").append(invoice.getAmount()).append("'").append(",");
        sqlStringBuilder.append("WHERE id = '").append(invoice.getId()).append("'");
        return sqlStringBuilder.toString();
    }

}
