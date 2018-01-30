package event.service_vehicle_oil;

public class ServiceVehicleRefillDeIcingSystem {
    private String phase;

    public ServiceVehicleRefillDeIcingSystem(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ServiceVehicleRefillDeIcingSystem";
    }
}
