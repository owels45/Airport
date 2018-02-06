package base;import java.util.ArrayList;

public class Storage {

    private String id;
    private ArrayList<Container> containerList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Container> getContainerList() {
        return containerList;
    }

    public void setContainerList(ArrayList<Container> containerList) {
        this.containerList = containerList;
    }

    public Storage(String id, ArrayList<Container> containerList) {
        this.id = id;
        this.containerList = containerList;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "containerList=" + containerList +
                '}';
    }
}
