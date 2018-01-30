package event.service_vehicle;

public class ServiceVehicleAPUOilTankIncreaseLevel {
    private String phase;

    public ServiceVehicleAPUOilTankIncreaseLevel(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ServiceVehicleAPUOilTankIncreaseLevel";
    }
}
