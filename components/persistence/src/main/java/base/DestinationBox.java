package base;import java.util.ArrayList;

public class DestinationBox {

    private String barCode;
    private ArrayList<Baggage> baggageList;

    public DestinationBox(String barCode, ArrayList<Baggage> baggageList) {
        this.barCode = barCode;
        this.baggageList = baggageList;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public ArrayList<Baggage> getBaggegeList() {
        return baggageList;
    }

    public void setBaggegeList(ArrayList<Baggage> baggegeList) {
        this.baggageList = baggegeList;
    }

    @Override
    public String toString() {
        return "DestinationBox{" +
                "barCode='" + barCode + '\'' +
                ", baggegeList=" + baggageList +
                '}';
    }
}
