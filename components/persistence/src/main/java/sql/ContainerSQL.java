package sql;


import base.Container;
import base.ContainerProfile;
import engine.LogEngine;
import main.Database;

public class ContainerSQL {

    private Database instance;

    public ContainerSQL(Database instance){
        this.instance = instance;
    }

    public void dropTableContainer(LogEngine logEngine) {
        String sqlStatement = "DROP TABLE container IF EXISTS";
        logEngine.write("main.Database", "dropTableContainer", "-", sqlStatement);
        instance.update(sqlStatement);
    }

    public void createTableContainer(LogEngine logEngine) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("CREATE TABLE container").append(" ( ");
        sqlStringBuilder.append("id VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("type TEXT NOT NULL").append(",");
        sqlStringBuilder.append("category TEXT NOT NULL").append(",");
        sqlStringBuilder.append("profile VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("barCode TEXT NOT NULL").append(",");
        sqlStringBuilder.append("qrCode TEXT NOT NULL").append(",");
        sqlStringBuilder.append("maxLugage INT NOT NULL").append(",");
        sqlStringBuilder.append("PRIMARY KEY (id)");
        sqlStringBuilder.append(" )");
        logEngine.write("main.Database", "createTableContainer", "-", sqlStringBuilder.toString());
        instance.update(sqlStringBuilder.toString());
    }


    public String buildInsertSQLStatement(Container container, ContainerProfile containerProfile) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("INSERT INTO container (id,type,category,profile,barCode,qrCode,maxLugage) VALUES (");
        sqlStringBuilder.append("'").append(container.getId()).append("'").append(",");
        sqlStringBuilder.append("'").append(container.getType().toString()).append("'").append(",");
        sqlStringBuilder.append("'").append(container.getCategory().toString()).append("'").append(",");
        sqlStringBuilder.append("'").append(containerProfile.getId()).append("'").append(",");
        sqlStringBuilder.append("'").append(container.getBarCodeIDCategory()).append("'").append(",");
        sqlStringBuilder.append("'").append(container.getQrCodeIDECategory()).append("'").append(",");
        sqlStringBuilder.append(container.getMaximumNumberOfBaggages());
        sqlStringBuilder.append(")");
        return sqlStringBuilder.toString();
    }

    public void insert(Container container, ContainerProfile containerProfile, LogEngine logEngine) {
        logEngine.write("main.Database", "insert", "container = " + container.getId(), buildInsertSQLStatement(container ,containerProfile));
        instance.update(buildInsertSQLStatement(container,containerProfile));
    }

    public String buildUpdateSQLStatement(Container container) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("UPDATE container SET type = '").append(container.getType().toString()).append("'").append(",");
        sqlStringBuilder.append("category = ").append(container.getCategory().toString()).append(",");
        sqlStringBuilder.append("profile = ").append(container.getProfile().toString()).append(",");
        sqlStringBuilder.append("barCode = ").append(container.getBarCodeIDCategory()).append(",");
        sqlStringBuilder.append("category = ").append(container.getQrCodeIDECategory()).append(",");
        sqlStringBuilder.append("maxLugage = ").append(container.getMaximumNumberOfBaggages()).append(",");
        sqlStringBuilder.append("WHERE id = '").append(container.getId()).append("'");
        return sqlStringBuilder.toString();
    }
}
