import java.util.ArrayList;
import java.util.List;

public class Passenger {
    public Passenger(String content){
        this.content = content;
        this.baggageList = new ArrayList<Baggage>();
    }
    public String content;
    public List<Baggage> baggageList;
}
