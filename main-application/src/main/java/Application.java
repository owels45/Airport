import base.Airplane;
import com.google.common.eventbus.EventBus;
import event.Subscriber;
import event.baggage_sorting.BaggageSorting;
import event.boarding_control.BoardingControlCallPassengers;
import event.boarding_control.BoardingControlInspectPassports;
import event.boarding_control.BoardingControlNotifyGroundOperations;
import event.boarding_control.BoardingControlScanBoardingPass;
import event.boarding_control.base.PassengerList;
import event.customs.CustomsScan;
import event.customs.CustomsVerify;
import event.federal_police.*;
import event.pushback_vehicle.PushBackVehicleConnect;
import event.pushback_vehicle.PushBackVehicleDisconnect;
import event.pushback_vehicle.PushBackVehiclePushBack;
import event.security_check.SecurityCheck;
import event.service_vehicle_fresh_water.ServiceVehicleRefillFreshWater;
import event.service_vehicle_nitrogen_oxygen.ServiceVehicleRefillNitrogenBottle;
import event.service_vehicle_nitrogen_oxygen.ServiceVehicleRefillOxygenBottle;
import event.service_vehicle_oil.ServiceVehicleAPUOilTankIncreaseLevel;
import event.service_vehicle_oil.ServiceVehicleChangeFireExtinguisher;
import event.service_vehicle_oil.ServiceVehicleEngineOilTankIncreaseLevel;
import event.service_vehicle_oil.ServiceVehicleRefillDeIcingSystem;
import event.service_vehicle_waster_water.ServiceVehiclePumpOut;
import event.sky_tanking_vehicle.SkyTankingVehicleConnect;
import event.sky_tanking_vehicle.SkyTankingVehiclePrint;
import event.sky_tanking_vehicle.SkyTankingVehiclePump;
import factory.GroundOperationsCenterFactory;
import logging.LogEngine;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private EventBus eventBus;

    public Application() {
        eventBus = new EventBus();
    }

    public void addSubscriber(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

    public void checkIn() {

    }

    public void baggageSorting() {
        // TODO Use real data
        String targetPosition = "";
        base.Destination destination = base.Destination.CPT;
        List<base.Baggage> baggages = new ArrayList<>();
        List<Object> baggageVehicles = new ArrayList<>();
        List<base.BaggageIdentificationTag> baggageTags = new ArrayList<>();
        eventBus.post(new BaggageSorting(targetPosition, destination, baggages, baggageVehicles, baggageTags));
    }

    public void securityCheck() {
        // TODO: Use the real passengers and baggage.
        List<base.Passenger> passengers = new ArrayList<>();
        List<base.Baggage> baggage = new ArrayList<>();
        eventBus.post(new SecurityCheck(passengers, baggage));

    }

    public void federalPolice(base.Passport passport, base.Passenger passenger, base.SpecialGood specialGood, base.Baggage baggage) {
        String phase = "Federal Police";
        eventBus.post(new FederalPoliceVerify(phase, passport));
        eventBus.post(new FederalPoliceInspectWeapon(phase, specialGood));
        eventBus.post(new FederalPoliceInspectMunition(phase, specialGood));
        eventBus.post(new FederalPoliceScan(phase, passport));
        eventBus.post(new FederalPoliceArrest(phase, passenger));
        eventBus.post(new FederalPoliceKeepSafe(phase, baggage));
    }

    public void customs(base.Passport passport, base.BoardingPass boardingPass, base.Invoice invoice, base.Baggage baggage) {
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

    public void tanking(Airplane airplane) {
        String phase = "SkyTanking Vehicle";
        eventBus.post(new SkyTankingVehicleConnect(phase, airplane));
        eventBus.post(new SkyTankingVehiclePump(phase, airplane));
        eventBus.post(new SkyTankingVehiclePrint(phase, airplane));
    }

    public void airCargoPalletLifterTask() {

    }

    // TODO: Insert passenger list into allPassengers if passenger instances are available (either database or instantiation)
    public void boardingControl() {
        PassengerList allPassengers = new PassengerList(new ArrayList<>());
        eventBus.post(new BoardingControlCallPassengers(allPassengers));
        eventBus.post(new BoardingControlInspectPassports(allPassengers));
        eventBus.post(new BoardingControlScanBoardingPass(allPassengers));
        eventBus.post(new BoardingControlNotifyGroundOperations(allPassengers, GroundOperationsCenterFactory.build()));
    }

    public void pushBack(Airplane airplane) {
        String phase = "PushBack Vehicle";
        eventBus.post(new PushBackVehicleConnect(phase, airplane));
        eventBus.post(new PushBackVehiclePushBack(phase, airplane));
        eventBus.post(new PushBackVehicleDisconnect(phase, airplane));
    }


    public void startSimulation(Airplane airplane) {
        //eigentlicher Ablauf der Simulation:
//        checkIn();
//        baggageSorting();
//        securityCheck();
//        federalPolice();
//        customs();
//        customs();
//        serviceVehicleTasks(airplane);
//        airCargoPalletLifterTask();
//        tanking();
//        boardingControl();
//        pushBack();
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
