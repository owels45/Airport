import java.util.ArrayList;

public class Roboter {

    public Roboter(){}

    public void load(ArrayList<Baggage> baggages, Container container){
        container.store(baggages);
    }

    public void load(Container container, BaggageVehicle baggageVehicle) {
        baggageVehicle.store(container);
    }

    public void orderBaggageVehicleMove( BaggageVehicle baggageVehicle, String position) {
        baggageVehicle.move(position);
    }
}
