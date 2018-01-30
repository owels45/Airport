package event.service_vehicle;

public class ServiceVehicleEngineOilIncreaseLevel {
    private String phase;

    public ServiceVehicleOilEngineIncreaseLevel(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ServiceVehicleOilApuIncreaseLevel";
    }
}
