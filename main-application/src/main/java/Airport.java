import com.google.common.eventbus.Subscribe;

import event.Subscriber;
import event.boarding_control.BoardingControlCallPassengers;
import event.boarding_control.BoardingControlInspectPassports;
import event.boarding_control.BoardingControlNotifyGroundOperations;
import event.boarding_control.BoardingControlScanBoardingPass;
import event.boarding_control.base.BoardingPass;
import event.boarding_control.base.Passenger;
import event.boarding_control.base.PassengerList;
import event.boarding_control.base.Passport;
import event.service_vehicle_fresh_water.ServiceVehicleRefillFreshWater;
import event.service_vehicle_nitrogen_oxygen.ServiceVehicleRefillNitrogenBottle;
import event.service_vehicle_nitrogen_oxygen.ServiceVehicleRefillOxygenBottle;
import event.service_vehicle_oil.ServiceVehicleAPUOilTankIncreaseLevel;
import event.service_vehicle_oil.ServiceVehicleChangeFireExtinguisher;
import event.service_vehicle_oil.ServiceVehicleEngineOilTankIncreaseLevel;
import event.service_vehicle_oil.ServiceVehicleRefillDeIcingSystem;
import event.service_vehicle_waster_water.ServiceVehiclePumpOut;
import factory.BoardingControlFactory;
import factory.GroundOperationsCenterFactory;
import factory.ServiceVehicleOilFactory;
import logging.LogEngine;
import sun.rmi.runtime.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Airport extends Subscriber {

    private Object checkInDeskPort;
    private Object baggageSortingUnitPort;
    private Object securityCheckPort;
    private Object federalPolicePort;
    private Object customsPort;
    private Object serviceVehicleOilPort;
    private Object serviceVehicleNitrogenOxygenPort;
    private Object serviceVehicleFreshWaterPort;
    private Object serviceVehicleWasteWaterTankPort;
    private Object airCargoPalletLifterPort;
    private Object skyTankingVehiclePort;
    private Object boardingControlPort;
    private Object pushBackVehiclePort;


    // TODO: 01.02.2018  HIER ALLE FACTORYS EINFÜGEN VON JEDEM TEAM SELBST!!!
    public void build() {
//        checkInDeskPort = .build();
//        baggageSortingUnitPort = .build();
//        securityCheckPort = .build();
//        federalPolicePort = .build();
//        customsPort = .build();
        serviceVehicleOilPort = ServiceVehicleOilFactory.build();
//        serviceVehicleNitrogenOxygenPort = .build();
//        serviceVehicleFreshWaterPort = .build();
//        serviceVehicleWasteWaterTankPort = .build();
//        airCargoPalletLifterPort = .build();
//        skyTankingVehiclePort = SkyTankingVehicleFactory.build();
        boardingControlPort = BoardingControlFactory.build();
//        pushBackVehiclePort = .build();
    }

    // TODO: 01.02.2018  HIER DIE GANZEN SUBSCRIBE METHODEN VON JEDEM TEAM SELBST!!!

    @Subscribe
    public void receive(ServiceVehicleAPUOilTankIncreaseLevel event) {
        try {
            ArrayList<Object> aPUOilTankPorts = event.getAirplane().getBody().getaPUOilTanks();
            for (int aPUOilTankIndex = 0; aPUOilTankIndex < aPUOilTankPorts.size(); aPUOilTankIndex++) {
                Method increaseLevelOfAPUOilTank = serviceVehicleOilPort.getClass().getDeclaredMethod("increaseLevelOfAPUOilTank", Object.class);
                LogEngine.instance.write("increaseLevelOfAPUOilTank = " + increaseLevelOfAPUOilTank);

                int increasedAmount = (Integer) increaseLevelOfAPUOilTank.invoke(serviceVehicleOilPort, aPUOilTankPorts.get(aPUOilTankIndex));
                LogEngine.instance.write(event.getPhase() + " : serviceVehicleAPUOilTankIncreaseLevel = " + increasedAmount);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(ServiceVehicleChangeFireExtinguisher event) {
        try {
            ArrayList<Object> fireExtinguisherPorts = event.getAirplane().getBody().getFireExtinguishers();
            for (int fireExtinguishersIndex = 0; fireExtinguishersIndex < fireExtinguisherPorts.size(); fireExtinguishersIndex++) {
                Method changeFireExtinguisher = serviceVehicleOilPort.getClass().getDeclaredMethod("change", Object.class);
                LogEngine.instance.write("changeFireExtinguisher = " + changeFireExtinguisher);

                boolean isChange = (Boolean) changeFireExtinguisher.invoke(serviceVehicleOilPort, fireExtinguisherPorts.get(fireExtinguishersIndex));
                LogEngine.instance.write(event.getPhase() + " : changeFireExtinguisher = " + isChange);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(ServiceVehicleRefillDeIcingSystem event) {
        try {
            ArrayList<Object> deIcingSystemPorts = event.getAirplane().getBody().getDeIcingSystems();
            for (int deIcingSystemsIndex = 0; deIcingSystemsIndex < deIcingSystemPorts.size(); deIcingSystemsIndex++) {
                Method refillDeIcingSystem = serviceVehicleOilPort.getClass().getDeclaredMethod("refill", Object.class);
                LogEngine.instance.write("refillDeIcingSystem = " + refillDeIcingSystem);

                boolean isChange = (Boolean) refillDeIcingSystem.invoke(serviceVehicleOilPort, deIcingSystemPorts.get(deIcingSystemsIndex));
                LogEngine.instance.write(event.getPhase() + " : refillDeIcingSystem = " + isChange);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(ServiceVehicleEngineOilTankIncreaseLevel event) {
        try {
            ArrayList<Object> engineOilTankPorts = event.getAirplane().getLeftWing().getEngineOilTanks();
            engineOilTankPorts.addAll(event.getAirplane().getRightWing().getEngineOilTanks());
            for (int engineOilTanksIndex = 0; engineOilTanksIndex < engineOilTankPorts.size(); engineOilTanksIndex++) {
                Method increaseLevelOfEngineOilTank = serviceVehicleOilPort.getClass().getDeclaredMethod("increaseLevelOfEngineOilTank", Object.class);
                LogEngine.instance.write("increaseLevelOfEngineOilTank = " + increaseLevelOfEngineOilTank);

                int increasedAmount = (Integer) increaseLevelOfEngineOilTank.invoke(serviceVehicleOilPort, engineOilTankPorts.get(engineOilTanksIndex));
                LogEngine.instance.write(event.getPhase() + " : serviceVehicleEngineOilTankIncreaseLevel = " + increasedAmount);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(ServiceVehiclePumpOut event) {
        try {
            ArrayList<Object> wasteWaterTankPorts = event.getAirplane().getBody().getWasteWaterTanks();
            for (int wasteWaterTanksIndex = 0; wasteWaterTanksIndex < wasteWaterTankPorts.size(); wasteWaterTanksIndex++) {
                Method pumpOutWasteWaterTank = serviceVehicleWasteWaterTankPort.getClass().getDeclaredMethod("pumpOut", Object.class);
                LogEngine.instance.write("pumpOutWasteWaterTank = " + pumpOutWasteWaterTank);

                int amountWasteWater = (Integer) pumpOutWasteWaterTank.invoke(serviceVehicleWasteWaterTankPort, wasteWaterTankPorts.get(wasteWaterTanksIndex));
                LogEngine.instance.write(event.getPhase() + " : pumpOutWasteWaterTank = " + amountWasteWater);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(ServiceVehicleRefillFreshWater event) {
        try {
            ArrayList<Object> freshWaterTankPorts = event.getAirplane().getBody().getPotableWaterTanks();
            for (int freshWaterTanksIndex = 0; freshWaterTanksIndex < freshWaterTankPorts.size(); freshWaterTanksIndex++) {
                Method refillFreshWaterTank = serviceVehicleFreshWaterPort.getClass().getDeclaredMethod("refill", Object.class);
                LogEngine.instance.write("refillFreshWaterTank = " + refillFreshWaterTank);

                int amountFreshWater = (Integer) refillFreshWaterTank.invoke(serviceVehicleFreshWaterPort, freshWaterTankPorts.get(freshWaterTanksIndex));
                LogEngine.instance.write(event.getPhase() + " : refillFreshWaterTank = " + amountFreshWater);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(ServiceVehicleRefillNitrogenBottle event) {
        try {
            ArrayList<Object> nitrogenBottlePorts = event.getAirplane().getBody().getNitrogenBottles();
            for (int nitrogenBottleIndex = 0; nitrogenBottleIndex < nitrogenBottlePorts.size(); nitrogenBottleIndex++) {
                Method refillNitrogenBottle = serviceVehicleNitrogenOxygenPort.getClass().getDeclaredMethod("refillNitrogenBottle", Object.class);
                LogEngine.instance.write("refillNitrogenBottle = " + refillNitrogenBottle);

                int amountNitrogen = (Integer) refillNitrogenBottle.invoke(serviceVehicleNitrogenOxygenPort, nitrogenBottlePorts.get(nitrogenBottleIndex));
                LogEngine.instance.write(event.getPhase() + " : refillNitrogenBottle = " + amountNitrogen);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(ServiceVehicleRefillOxygenBottle event) {
        try {
            ArrayList<Object> oxygenBottlePorts = event.getAirplane().getBody().getOxygenBottles();
            for (int oxygenBottleIndex = 0; oxygenBottleIndex < oxygenBottlePorts.size(); oxygenBottleIndex++) {
                Method refillOxygenBottle = serviceVehicleNitrogenOxygenPort.getClass().getDeclaredMethod("refillOxygenBottle", Object.class);
                LogEngine.instance.write("refillOxygenBottle = " + refillOxygenBottle);

                int amountOxygen = (Integer) refillOxygenBottle.invoke(serviceVehicleNitrogenOxygenPort, oxygenBottlePorts.get(oxygenBottleIndex));
                LogEngine.instance.write(event.getPhase() + " : refillOxygenBottle = " + amountOxygen);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(BoardingControlCallPassengers event) {
        try {
            // Load method 'call' from boardingControlPort with parameter of type PassengerList
            Method callPassengerMethod = boardingControlPort.getClass().getDeclaredMethod("call", PassengerList.class);
            LogEngine.instance.write("signature of BoardingControl.Port.call(PassengerList.class): " + callPassengerMethod.toGenericString());

            // Invoke method with passenger list from event
            callPassengerMethod.invoke(boardingControlPort, event.getPassengers());
            LogEngine.instance.write("--- Call all passengers to gate to start boarding");
            int passengerId = 1;
            for (Passenger passenger : event.getPassengers().getPassengerList()) {
                LogEngine.instance.write(String.format("%03d: %s", passengerId, passenger.toString()));
                passengerId++;
            }
            LogEngine.instance.write("--- Calling passengers completed");
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException exc) {
            exc.printStackTrace();
        }
    }

    @Subscribe
    public void receive(BoardingControlInspectPassports event) {
        try {
            // Load method 'inspect' with the Passport parameter from BoardingControl class
            Method inspectPassportMethod = boardingControlPort.getClass().getMethod("inspect", Passport.class);
            LogEngine.instance.write("signature of BoardingControl.Port.inspect(Passport.class): " + inspectPassportMethod.toGenericString());

            // Inspect the passport for each passenger before boarding
            LogEngine.instance.write("--- Inspect the passports of all passengers");
            for (Passenger passenger : event.getPassengers().getPassengerList()) {
                boolean validPassport = (boolean) inspectPassportMethod.invoke(boardingControlPort, passenger.getPassport());
                LogEngine.instance.write(validPassport ? "Passenger " + passenger.getName() + " has a valid passport." :
                        "Security Alert: Passenger " + passenger.getName() + " has a counterfeit passport!");
            }
            LogEngine.instance.write("--- Finished inspection: All passports are valid!");
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException exc) {
            exc.printStackTrace();
        }
    }

    @Subscribe
    public void receive(BoardingControlScanBoardingPass event) {
        try {
            // Load method 'scan' from BoardingControl to scan all boarding passes
            Method scanMethod = boardingControlPort.getClass().getDeclaredMethod("scan", BoardingPass.class);
            LogEngine.instance.write("signature of BoardingControl.Port.scan(BoardingPass.class): " + scanMethod.toGenericString());

            // Scan the boarding pass for each passenger and log the progress
            LogEngine.instance.write("--- Scanning all boarding passes of passengers");
            for (Passenger passenger : event.getPassengers().getPassengerList()) {
                boolean boardingPassScanned = (boolean) scanMethod.invoke(boardingControlPort, passenger.getBoardingPass());
                LogEngine.instance.write(boardingPassScanned ? "Passenger " + passenger.getName() + " is registered to flight " +
                        passenger.getBoardingPass().getFlight() + " from " + passenger.getBoardingPass().getSource() + " to " +
                        passenger.getBoardingPass().getDestination() + "!" : "Passenger " + passenger.getName() +
                        " is not registered on this flight!");
            }
            LogEngine.instance.write("--- Scanning boarding passes completed: All passengers are validly registered on this flight!");
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException exc) {
            exc.printStackTrace();
        }
    }

    @Subscribe
    public void receive(BoardingControlNotifyGroundOperations event) {
        try {
            // Load method 'notifyGroundOperations' from BoardingControl to invoke receive method of GroundOperationsCenter
            Method notifyGroundOperationsMethod = boardingControlPort.getClass().getDeclaredMethod("notifyGroundOperations", Object.class);
            LogEngine.instance.write("signature of BoardingControl.Port.notifyGroundOperations(Object.class): " + notifyGroundOperationsMethod.toGenericString());

            // Invoke notification of ground operations by applying the ground operation's port to method
            notifyGroundOperationsMethod.invoke(boardingControlPort, event.getGroundOperationsPort());
            LogEngine.instance.write("--- Notifying ground operations that boarding is completed and passengers are" +
                    "on their way to the airplane");
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException exc) {
            exc.printStackTrace();
        }
    }

}
