package sql;

import base.Container;
import engine.LogEngine;
import main.Database;

import java.util.ArrayList;

public class StorageSQL {

    private Database instance;

    public StorageSQL (Database instance){
        this.instance = instance;
    }

    public ArrayList<Container> buildSelectSQLStatement(LogEngine logEngine) {

        ArrayList<Container> listcontainer = new ArrayList<Container>();
        StringBuilder sb = new StringBuilder();


        return listcontainer;

    }
}
