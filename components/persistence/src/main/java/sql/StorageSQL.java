package sql;

import base.Container;
import base.Storage;
import engine.LogEngine;
import main.Database;

public class StorageSQL {

    private Database instance;

    public StorageSQL(Database instance) {
        this.instance = instance;
    }

    public void dropTableStorage(LogEngine logEngine) {
        String sqlStatement = "DROP TABLE storage IF EXISTS";
        logEngine.write("main.Database", "dropTableStorage", "-", sqlStatement);
        instance.update(sqlStatement);
    }

    public void createTableDestinationBox(LogEngine logEngine) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("CREATE TABLE storage").append(" ( ");
        sqlStringBuilder.append("id VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("container TEXT NOT NULL").append(",");
        sqlStringBuilder.append("PRIMARY KEY (id)");
        sqlStringBuilder.append(")");
        logEngine.write("main.Database", "createTableStorage", "-", sqlStringBuilder.toString());
        instance.update(sqlStringBuilder.toString());
    }


    public String buildInsertSQLStatement(Storage storage) {

        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("INSERT INTO storage (id,container) VALUES (");
        sqlStringBuilder.append("'").append(storage.getId()).append("'").append(",");
        sqlStringBuilder.append("'").append(getStringfromList(storage)).append("'");
        sqlStringBuilder.append(")");
        return sqlStringBuilder.toString();
    }

    public void insert(Storage storage, LogEngine logEngine) {
        System.out.println(storage.hashCode());
        logEngine.write("main.Database", "insert", "Storage = " + storage.getId(), buildInsertSQLStatement(storage));
        instance.update(buildInsertSQLStatement(storage));
    }

    public String buildUpdateSQLStatement(Storage storage) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("UPDATE storage SET container = '").append(getStringfromList(storage)).append("'").append(",");
        sqlStringBuilder.append("WHERE id = '").append(storage.getId()).append("'");
        return sqlStringBuilder.toString();
    }

    private String getStringfromList(Storage storage){
        boolean processedFirst = false;
        StringBuilder listbuilder = new StringBuilder();
        for (Container record: storage.getContainerList()){
            if (processedFirst)
                listbuilder.append(",");
            listbuilder.append(record);
            processedFirst = true;
        }
        return listbuilder.toString();
    }
}
