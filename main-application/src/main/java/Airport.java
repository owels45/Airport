import com.google.common.eventbus.Subscribe;

import event.Subscriber;
import event.service_vehicle_fresh_water.ServiceVehicleFreshWaterNotifyGroundOperations;
import event.service_vehicle_fresh_water.ServiceVehicleRefillFreshWater;
import event.service_vehicle_nitrogen_oxygen.ServiceVehicleNitrogenOxygenNotifyGroundOperations;
import event.service_vehicle_nitrogen_oxygen.ServiceVehicleRefillNitrogenBottle;
import event.service_vehicle_nitrogen_oxygen.ServiceVehicleRefillOxygenBottle;
import event.service_vehicle_oil.*;
import event.service_vehicle_waste_water.ServiceVehiclePumpOut;
import event.service_vehicle_waste_water.ServiceVehicleWasteWaterNotifyGroundOperations;
import factory.ServiceVehicleFreshWaterFactory;
import factory.ServiceVehicleNitrogenOxygenFactory;
import factory.ServiceVehicleOilFactory;
import factory.ServiceVehicleWasteWaterTankFactory;
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
        serviceVehicleNitrogenOxygenPort = ServiceVehicleNitrogenOxygenFactory.build();
        serviceVehicleFreshWaterPort = ServiceVehicleFreshWaterFactory.build();
        serviceVehicleWasteWaterTankPort = ServiceVehicleWasteWaterTankFactory.build();
//        airCargoPalletLifterPort = .build();
//        skyTankingVehiclePort = SkyTankingVehicleFactory.build();
//        boardingControlPort = .build();
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
        }catch (Exception e) {
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
        } catch(Exception e) {
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
        } catch(Exception e) {
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
    public void receive(ServiceVehicleOilNotifyGroundOperations event) {
        try {
            Method notifyGroundOperations = serviceVehicleOilPort.getClass().getDeclaredMethod("notifyGroundOperations", Object.class);
            notifyGroundOperations.invoke(serviceVehicleOilPort, event.getGroundOperationCenterPort());
            LogEngine.instance.write("ServiceVehicleOil: Notifying the groundoperations center...");

            LogEngine.instance.write("+");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(ServiceVehicleNitrogenOxygenNotifyGroundOperations event) {
        try {
            Method notifyGroundOperations = serviceVehicleNitrogenOxygenPort.getClass().getDeclaredMethod("notifyGroundOperations", Object.class);
            notifyGroundOperations.invoke(serviceVehicleNitrogenOxygenPort, event.getGroundOperationCenterPort());
            LogEngine.instance.write("ServiceVehicleNitrogenOxygen: Notifying the groundoperations center...");

            LogEngine.instance.write("+");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(ServiceVehicleWasteWaterNotifyGroundOperations event) {
        try {
            Method notifyGroundOperations = serviceVehicleWasteWaterTankPort.getClass().getDeclaredMethod("notifyGroundOperations", Object.class);
            notifyGroundOperations.invoke(serviceVehicleWasteWaterTankPort, event.getGroundOperationCenterPort());
            LogEngine.instance.write("ServiceVehicleWasteWater: Notifying the groundoperations center...");

            LogEngine.instance.write("+");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(ServiceVehicleFreshWaterNotifyGroundOperations event) {
        try {
            Method notifyGroundOperations = serviceVehicleFreshWaterPort.getClass().getDeclaredMethod("notifyGroundOperations", Object.class);
            notifyGroundOperations.invoke(serviceVehicleFreshWaterPort, event.getGroundOperationCenterPort());
            LogEngine.instance.write("ServiceVehicleFreshWater: Notifying the groundoperations center...");

            LogEngine.instance.write("+");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}