package event.service_vehicle;

public class ServiceVehicleStart {
    private String phase;

    public ServiceVehicleStart(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ServiceVehicleStart";
    }
}
