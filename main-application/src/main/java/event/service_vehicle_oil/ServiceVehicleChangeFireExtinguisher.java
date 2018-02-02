package event.service_vehicle_oil;

public class ServiceVehicleChangeFireExtinguisher {
    private String phase;

    public ServiceVehicleChangeFireExtinguisher(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ServiceVehicleChangeFireExtinguisher";
    }
}