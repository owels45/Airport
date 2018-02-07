package event.service_vehicle_oil;

public class ServiceVehicleNotifyGroundOperations {
    private String phase;

    // TODO: Groundoperationport dem Konstruktor übergeben um in ServiceVehicleOil die Daten zu persistieren
    public ServiceVehicleNotifyGroundOperations(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ServiceVehicleNotifyGroundOperations";
    }
}
