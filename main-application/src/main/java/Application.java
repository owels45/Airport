import base.Airplane;
import com.google.common.eventbus.EventBus;
import event.Subscriber;
import event.service_vehicle_fresh_water.ServiceVehicleFreshWaterNotifyGroundOperations;
import event.service_vehicle_fresh_water.ServiceVehicleRefillFreshWater;
import event.service_vehicle_nitrogen_oxygen.ServiceVehicleNitrogenOxygenNotifyGroundOperations;
import event.service_vehicle_nitrogen_oxygen.ServiceVehicleRefillNitrogenBottle;
import event.service_vehicle_nitrogen_oxygen.ServiceVehicleRefillOxygenBottle;
import event.service_vehicle_oil.*;
import event.service_vehicle_waste_water.ServiceVehiclePumpOut;
import event.service_vehicle_waste_water.ServiceVehicleWasteWaterNotifyGroundOperations;
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

    public void serviceVehicleTasks(Airplane airplane, Object groundOperationCenterPort) {
        String phase = "Service Vehicle";
        eventBus.post(new ServiceVehicleAPUOilTankIncreaseLevel(phase, airplane));
        eventBus.post(new ServiceVehicleEngineOilTankIncreaseLevel(phase, airplane));
        eventBus.post(new ServiceVehicleChangeFireExtinguisher(phase, airplane));
        eventBus.post(new ServiceVehicleRefillDeIcingSystem(phase, airplane));
        eventBus.post(new ServiceVehicleOilNotifyGroundOperations(phase, groundOperationCenterPort));

        eventBus.post(new ServiceVehicleRefillFreshWater(phase, airplane));
        eventBus.post(new ServiceVehicleFreshWaterNotifyGroundOperations(phase, groundOperationCenterPort));

        eventBus.post(new ServiceVehicleRefillNitrogenBottle(phase, airplane));
        eventBus.post(new ServiceVehicleRefillOxygenBottle(phase, airplane));
        eventBus.post(new ServiceVehicleNitrogenOxygenNotifyGroundOperations(phase, groundOperationCenterPort));

        eventBus.post(new ServiceVehiclePumpOut(phase, airplane));
        eventBus.post(new ServiceVehicleWasteWaterNotifyGroundOperations(phase, groundOperationCenterPort));
    }

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