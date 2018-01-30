package event.service_vehicle;

public class ServiceVehicleApuOilIncreaseLevel {
    private String phase;

    public ServiceVehicleOilApuIncreaseLevel(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ServiceVehicleOilApuIncreaseLevel";
    }
}
