import base.Airplane;
import base.Baggage;
import base.BoardingPass;
import base.Invoice;
import base.Passenger;
import base.Passport;
import base.SpecialGood;
import com.google.common.eventbus.EventBus;
import event.Subscriber;
import event.customs.CustomsScan;
import event.customs.CustomsVerify;
import event.federal_police.*;
import event.service_vehicle_fresh_water.ServiceVehicleRefillFreshWater;
import event.service_vehicle_nitrogen_oxygen.ServiceVehicleRefillNitrogenBottle;
import event.service_vehicle_nitrogen_oxygen.ServiceVehicleRefillOxygenBottle;
import event.service_vehicle_oil.ServiceVehicleAPUOilTankIncreaseLevel;
import event.service_vehicle_oil.ServiceVehicleChangeFireExtinguisher;
import event.service_vehicle_oil.ServiceVehicleEngineOilTankIncreaseLevel;
import event.service_vehicle_oil.ServiceVehicleRefillDeIcingSystem;
import event.service_vehicle_waster_water.ServiceVehiclePumpOut;
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

    public void federalPolice(Passport passport, Passenger passenger, SpecialGood specialGood, Baggage baggage) {
        String phase = "Federal Police";
        eventBus.post(new FederalPoliceVerify(phase, passport));
        eventBus.post(new FederalPoliceInspectWeapon(phase, specialGood));
        eventBus.post(new FederalPoliceInspectMunition(phase, specialGood));
        eventBus.post(new FederalPoliceScan(phase, passport));
        eventBus.post(new FederalPoliceArrest(phase, passenger));
        eventBus.post(new FederalPoliceKeepSafe(phase, baggage));
    }

    public void customsTasks(Passport passport, BoardingPass boardingPass, Invoice invoice, Baggage baggage) {
        String phase = "Customs";
        eventBus.post(new CustomsVerify(phase, passport, boardingPass, invoice ));
        eventBus.post(new CustomsScan(phase, baggage));

    }

    public void serviceVehicleTasks(Airplane airplane) {
        String phase = "Service Vehicle";
        eventBus.post(new ServiceVehicleAPUOilTankIncreaseLevel(phase, airplane));
        eventBus.post(new ServiceVehicleEngineOilTankIncreaseLevel(phase, airplane));
        eventBus.post(new ServiceVehicleChangeFireExtinguisher(phase, airplane));
        eventBus.post(new ServiceVehicleRefillDeIcingSystem(phase, airplane));

        eventBus.post(new ServiceVehicleRefillFreshWater(phase, airplane));

        eventBus.post(new ServiceVehicleRefillNitrogenBottle(phase, airplane));
        eventBus.post(new ServiceVehicleRefillOxygenBottle(phase, airplane));

        eventBus.post(new ServiceVehiclePumpOut(phase, airplane));
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