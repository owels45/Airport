import base.Airplane;
import com.google.common.eventbus.EventBus;
import event.Subscriber;
import event.service_vehicle_oil.ServiceVehicleAPUOilTankIncreaseLevel;
import event.service_vehicle_oil.ServiceVehicleChangeFireExtinguisher;
import event.service_vehicle_oil.ServiceVehicleEngineOilTankIncreaseLevel;
import event.service_vehicle_oil.ServiceVehicleRefillDeIcingSystem;
import logging.LogEngine;

public class Application {

    private EventBus eventBus;

    public Application() {
        eventBus = new EventBus();
    }

    public void addSubscriber(Subscriber subscriber) {
        eventBus.register(subscriber);
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

    public void serviceVehicleTasks(Airplane airplane) {
        String phase = "Service Vehicle";
        eventBus.post(new ServiceVehicleAPUOilTankIncreaseLevel(phase, airplane));
        eventBus.post(new ServiceVehicleEngineOilTankIncreaseLevel(phase, airplane));
        eventBus.post(new ServiceVehicleChangeFireExtinguisher(phase, airplane));
        eventBus.post(new ServiceVehicleRefillDeIcingSystem(phase, airplane));
        //eventBus.post()
    }
    //    ...?
    public void tanking() {

    }
// TODO: 01.02.2018  ...alle service-Vehicle-Events ergänzen

    public void boardingControl() {

    }

    public void pushBack() {

    }


    public void startSimulation(Airplane airplane) {
        //Aufruf obiger Methoden in richtiger Reihenfolge
        //serviceVehicleTasks(airplane);
    }

    public static void main(String... args) {
        LogEngine.instance.init();

        Application application = new Application();

        Airport airport = new Airport();
        airport.build();
        application.addSubscriber(airport);

        Airplane airplane = new Airplane();
        airplane.build();

        application.startSimulation(airplane);


//        FlightRecorder.instance.startup();
//        FlightRecorder.instance.init();
//
//
//        Cockpit cockpit = new Cockpit(airplane);
//        cockpit.startSimulation();
//
//        FlightRecorder.instance.shutdown();

        LogEngine.instance.close();
    }
}