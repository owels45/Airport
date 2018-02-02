package event.service_vehicle_oil;

public class ServiceVehicleEngineOilTankIncreaseLevel {
    private String phase;

    public ServiceVehicleEngineOilTankIncreaseLevel(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ServiceVehicleEngineOilTankIncreaseLevel";
    }
}
