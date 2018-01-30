package event.service_vehicle_nitrogen_oxygen;

public class ServiceVehicleRefillNitrogenBottle {
    private String phase;

    public ServiceVehicleRefillNitrogenBottle(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ServiceVehicleRefillNitrogenBottle";
    }
}
