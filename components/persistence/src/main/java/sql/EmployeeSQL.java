package sql;

import base.Employee;
import engine.LogEngine;
import main.Database;

public class EmployeeSQL {

    private Database instance;

    public EmployeeSQL(Database instance){
        this.instance = instance;
    }

    public void dropTableBaggage(LogEngine logEngine) {
        String sqlStatement = "DROP TABLE employee IF EXISTS";
        logEngine.write("main.Database", "dropTableBaggage", "-", sqlStatement);
        instance.update(sqlStatement);
    }

    public void createTableBaggage(LogEngine logEngine) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("CREATE TABLE employee").append(" ( ");
        sqlStringBuilder.append("id VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("name TEXT NOT NULL").append(",");
        sqlStringBuilder.append("idcard TEXT NOT NULL").append(",");
        sqlStringBuilder.append("PRIMARY KEY (id)");
        sqlStringBuilder.append(")");
        logEngine.write("main.Database", "createTableEmployee", "-", sqlStringBuilder.toString());
        instance.update(sqlStringBuilder.toString());
    }

    public String buildInsertSQLStatement(Employee employee) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("INSERT INTO employee (id,name,idcard) VALUES (");
        sqlStringBuilder.append("'").append(employee.getId()).append("'").append(",");
        sqlStringBuilder.append("'").append(employee.getName()).append("'").append(",");
        sqlStringBuilder.append("'").append(employee.getIdCard()).append("'");
        sqlStringBuilder.append(")");
        return sqlStringBuilder.toString();
    }

    public void insert(Employee employee, LogEngine logEngine) {
        System.out.println(employee.hashCode());
        logEngine.write("main.Database", "insert", "employee = " + employee.getId(), buildInsertSQLStatement(employee));
        instance.update(buildInsertSQLStatement(employee));
    }

    public String buildUpdateSQLStatement(Employee employee) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("UPDATE employee SET name = '").append(employee.getName()).append("'").append(",");
        sqlStringBuilder.append("idcard = '").append(employee.getIdCard()).append("'").append(",");
        sqlStringBuilder.append("WHERE id = '").append(employee.getId()).append("'");
        return sqlStringBuilder.toString();
    }
}
