package event.service_vehicle_waste_water;

public class ServiceVehiclePumpOut {
    private String phase;

    public ServiceVehiclePumpOut(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ServiceVehiclePumpOut";
    }
}
