package event.service_vehicle;

public class ServiceVehicleRefillFreshWater {
    private String phase;

    public ServiceVehicleRefillFreshWater(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ServiceVehicleRefillFreshWater";
    }
}
