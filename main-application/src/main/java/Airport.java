import com.google.common.eventbus.Subscribe;

import event.service_vehicle_oil.ServiceVehicleAPUOilTankIncreaseLevel;
import factory.ServiceVehicleOilFactory;

public class Airport {

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
    }

    //etc.


}
