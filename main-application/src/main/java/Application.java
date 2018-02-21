import base.Airplane;
import com.google.common.eventbus.EventBus;
import event.Subscriber;
<<<<<<< Updated upstream
=======

import event.baggage_sorting.BaggageSorting;
>>>>>>> Stashed changes
import event.boarding_control.BoardingControlCallPassengers;
import event.boarding_control.BoardingControlInspectPassports;
import event.boarding_control.BoardingControlNotifyGroundOperations;
import event.boarding_control.BoardingControlScanBoardingPass;
import event.boarding_control.base.PassengerList;
<<<<<<< Updated upstream
=======
import event.customs.CustomsScan;
import event.customs.CustomsVerify;
import event.federal_police.*;
import event.pushback_vehicle.PushBackVehicleConnect;
import event.pushback_vehicle.PushBackVehicleDisconnect;
import event.pushback_vehicle.PushBackVehiclePushBack;
import event.security_check.SecurityCheck;
>>>>>>> Stashed changes
import event.service_vehicle_fresh_water.ServiceVehicleRefillFreshWater;
import event.service_vehicle_nitrogen_oxygen.ServiceVehicleRefillNitrogenBottle;
import event.service_vehicle_nitrogen_oxygen.ServiceVehicleRefillOxygenBottle;
import event.service_vehicle_oil.ServiceVehicleAPUOilTankIncreaseLevel;
import event.service_vehicle_oil.ServiceVehicleChangeFireExtinguisher;
import event.service_vehicle_oil.ServiceVehicleEngineOilTankIncreaseLevel;
import event.service_vehicle_oil.ServiceVehicleRefillDeIcingSystem;
import event.service_vehicle_waster_water.ServiceVehiclePumpOut;
<<<<<<< Updated upstream
=======
import event.sky_tanking_vehicle.SkyTankingVehicleConnect;
import event.sky_tanking_vehicle.SkyTankingVehiclePrint;
import event.sky_tanking_vehicle.SkyTankingVehiclePump;
>>>>>>> Stashed changes
import factory.GroundOperationsCenterFactory;
import logging.LogEngine;

import java.util.ArrayList;

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

<<<<<<< Updated upstream
    public void customs() {
=======
    public void customsTasks(Passport passport, BoardingPass boardingPass, Invoice invoice, Baggage baggage) {
        String phase = "Customs";
        eventBus.post(new CustomsVerify(phase, passport, boardingPass, invoice));
        eventBus.post(new CustomsScan(phase, baggage));
>>>>>>> Stashed changes

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

    public void airCargoPalletLifterTask() {

    }

    public void tanking() {

    }

    // TODO: Insert passenger list into allPassengers if passenger instances are available (either database or instantiation)
    public void boardingControl() {
        PassengerList allPassengers = new PassengerList(new ArrayList<>());
        eventBus.post(new BoardingControlCallPassengers(allPassengers));
        eventBus.post(new BoardingControlInspectPassports(allPassengers));
        eventBus.post(new BoardingControlScanBoardingPass(allPassengers));
        eventBus.post(new BoardingControlNotifyGroundOperations(allPassengers, GroundOperationsCenterFactory.build()));
    }

    public void pushBack() {

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
