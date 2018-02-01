import com.google.common.eventbus.EventBus;
import event.service_vehicle_oil.ServiceVehicleAPUOilTankIncreaseLevel;
import logging.LogEngine;

public class Application {

    private EventBus eventBus;


    public Application() {
        eventBus = new EventBus();
    }

    // TODO: 01.02.2018  einzelne Methoden für jedes Event schreiben
    public void checkIn() {

    }

    public void baggageSorting() {

    }

    public void securityCheck() {

    }

    public void federalPolice() {

    }

    public void customs() {

    }

    public void tankingService() {
        String phase = "service";
        eventBus.post(new ServiceVehicleAPUOilTankIncreaseLevel(phase));
    }
    //    ...?
    public void tanking() {

    }
// TODO: 01.02.2018  ...alle service-Vehicle-Events ergänzen

    public void boardingControl() {

    }

    public void pushBack() {

    }


    public void startSimulation() {
        //Aufruf obiger Methoden in richtiger Reihenfolge
    }

    public static void main(String... args) {
        LogEngine.instance.init();

        Airport airport = new Airport();
        airport.build();

        Application application = new Application();
        application.startSimulation();


//        FlightRecorder.instance.startup();
//        FlightRecorder.instance.init();
//
//        Airplane airplane = new Airplane();
//        airplane.build();
//
//        Cockpit cockpit = new Cockpit(airplane);
//        cockpit.startSimulation();
//
//        FlightRecorder.instance.shutdown();

        LogEngine.instance.close();
    }
}