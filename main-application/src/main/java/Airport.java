import com.google.common.eventbus.Subscribe;

import event.Subscriber;
import event.service_vehicle_oil.ServiceVehicleAPUOilTankIncreaseLevel;
import event.service_vehicle_oil.ServiceVehicleChangeFireExtinguisher;
import event.service_vehicle_oil.ServiceVehicleEngineOilTankIncreaseLevel;
import event.service_vehicle_oil.ServiceVehicleRefillDeIcingSystem;
import factory.ServiceVehicleOilFactory;
import logging.LogEngine;

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
//        boardingControlPort = .build();
//        pushBackVehiclePort = .build();
    }

    // TODO: 01.02.2018  HIER DIE GANZEN SUBSCRIBE METHODEN VON JEDEM TEAM SELBST!!!
    
    @Subscribe
    public void receive(ServiceVehicleAPUOilTankIncreaseLevel event) {
        try {
            ArrayList<Object> aPUOilTanks = event.getAirplane().getBody().getaPUOilTanks();
            for (int aPUOilTankIndex = 0; aPUOilTankIndex < aPUOilTanks.size(); aPUOilTankIndex++) {
                Method increaseLevelOfAPUOilTank = serviceVehicleOilPort.getClass().getDeclaredMethod("increaseLevelOfAPUOilTank", Object.class);
                LogEngine.instance.write("increaseLevelOfAPUOilTank = " + increaseLevelOfAPUOilTank);

                int increasedAmount = (Integer) increaseLevelOfAPUOilTank.invoke(serviceVehicleOilPort, aPUOilTanks.get(aPUOilTankIndex));
                LogEngine.instance.write(event.getPhase() + " : serviceVehicleAPUOilTankIncreaseLevel = " + increasedAmount);

                LogEngine.instance.write("+");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(ServiceVehicleChangeFireExtinguisher event) {
        try {
            ArrayList<Object> fireExtinguishers = event.getAirplane().getBody().getFireExtinguishers();
            for (int fireExtinguishersIndex = 0; fireExtinguishersIndex < fireExtinguishers.size(); fireExtinguishersIndex++) {
                Method changeFireExtinguisher = serviceVehicleOilPort.getClass().getDeclaredMethod("change", Object.class);
                LogEngine.instance.write("changeFireExtinguisher = " + changeFireExtinguisher);

                boolean isChange = (Boolean) changeFireExtinguisher.invoke(serviceVehicleOilPort, fireExtinguishers.get(fireExtinguishersIndex));
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
            ArrayList<Object> deIcingSystems = event.getAirplane().getBody().getDeIcingSystems();
            for (int deIcingSystemsIndex = 0; deIcingSystemsIndex < deIcingSystems.size(); deIcingSystemsIndex++) {
                Method refillDeIcingSystem = serviceVehicleOilPort.getClass().getDeclaredMethod("refill", Object.class);
                LogEngine.instance.write("refillDeIcingSystem = " + refillDeIcingSystem);

                boolean isChange = (Boolean) refillDeIcingSystem.invoke(serviceVehicleOilPort, deIcingSystems.get(deIcingSystemsIndex));
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
            ArrayList<Object> engineOilTanks = event.getAirplane().getLeftWing().getEngineOilTanks();
            engineOilTanks.addAll(event.getAirplane().getRightWing().getEngineOilTanks());
            for (int engineOilTanksIndex = 0; engineOilTanksIndex < engineOilTanks.size(); engineOilTanksIndex++) {
                Method increaseLevelOfEngineOilTank = serviceVehicleOilPort.getClass().getDeclaredMethod("increaseLevelOfEngineOilTank", Object.class);
                LogEngine.instance.write("increaseLevelOfEngineOilTank = " + increaseLevelOfEngineOilTank);

                int increasedAmount = (Integer) increaseLevelOfEngineOilTank.invoke(serviceVehicleOilPort, engineOilTanks.get(engineOilTanksIndex));
                LogEngine.instance.write(event.getPhase() + " : serviceVehicleEngineOilTankIncreaseLevel = " + increasedAmount);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
