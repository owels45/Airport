// please do not modify

import logging.LogEngine;

public class Application {

    //private EventBus eventBus;


    public Application() {
        //eventBus = new EventBus();
    }

    public void checkIn() {
//        eventBus.post(new CheckIn.event());
    }

    public void service() {

    }

    public void tanking() {

    }

    public void startSimulation(){

    }

    public static void main(String... args) {
        LogEngine.instance.init();

        Airport airport = new Airport();
        airport.build();





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