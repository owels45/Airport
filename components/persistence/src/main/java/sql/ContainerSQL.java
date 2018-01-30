package sql;


import base.Baggage;
import base.Container;
import engine.LogEngine;
import main.Database;

public class ContainerSQL {

    Database instance = new Database();

    public void dropTableBaggage(LogEngine logEngine) {
        String sqlStatement = "DROP TABLE baggage IF EXISTS";
        logEngine.write("main.Database", "dropTableBaggage", "-", sqlStatement);
        instance.update(sqlStatement);
    }

    public void createTableBaggage(LogEngine logEngine) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("CREATE TABLE baggage").append(" ( ");
        sqlStringBuilder.append("uuid VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("content VARCHAR(50000) NOT NULL").append(",");
        sqlStringBuilder.append("weight INT NOT NULL").append(",");
        sqlStringBuilder.append("PRIMARY KEY (uuid)");
        sqlStringBuilder.append(" )");
        logEngine.write("main.Database", "createTableBaggage", "-", sqlStringBuilder.toString());
        instance.update(sqlStringBuilder.toString());
    }


    public String buildInsertSQLStatement(Container container) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("INSERT INTO baggage (uuid,content,weight) VALUES (");
        sqlStringBuilder.append("'").append(container.getId()).append("'").append(",");
        sqlStringBuilder.append("'").append(container.getBarCodeIDCategory()).append("'").append(",");
        sqlStringBuilder.append(container.getCategory()).append(",");
        sqlStringBuilder.append("'").append(container.getProfile()).append("'");
        sqlStringBuilder.append(")");
        return sqlStringBuilder.toString();
    }

    public void insert(Container container, LogEngine logEngine) {
        logEngine.write("main.Database", "insert", "baggage = " + container.getId(), buildInsertSQLStatement(container));
        instance.update(buildInsertSQLStatement(container));
    }

    public String buildUpdateSQLStatement(Container container) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("UPDATE baggage SET content = '").append(container.getId()).append("'").append(",");
        sqlStringBuilder.append("weight = ").append(container.getProfile()).append(",");
        sqlStringBuilder.append("WHERE uuid = '").append(container.getBarCodeIDCategory()).append("'");
        return sqlStringBuilder.toString();
    }
}
