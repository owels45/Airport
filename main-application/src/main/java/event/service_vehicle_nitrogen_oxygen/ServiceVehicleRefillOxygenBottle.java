package event.service_vehicle_nitrogen_oxygen;

public class ServiceVehicleRefillOxygenBottle {
    private String phase;

    public ServiceVehicleRefillOxygenBottle(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ServiceVehicleRefillFreshWater";
    }
}
