import factory.GroundOperationsCenterFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BoardingControl {
    private static BoardingControl instance = new BoardingControl();
    public Port port;

    private CheckInDesk checkInDesk;
    private PassengerList boardedPassengerList;

    private BoardingControl() {
        port = new Port();
    }

    public static BoardingControl getInstance() {
        return instance;
    }

    public void callPassengers(PassengerList passengerList) {
        printMethodCall("callPassengers", false);
        if (!passengerList.getPassengerList().isEmpty()) {
            Passenger examplePassenger = passengerList.getPassengerList().get(0);
            String flightNumber = examplePassenger.getBoardingPass().getFlight();
            Source source = examplePassenger.getBoardingPass().getSource();
            Destination destination = examplePassenger.getBoardingPass().getDestination();
            String gate = examplePassenger.getBoardingPass().getGate();

            System.out.printf("Boarding for Flight %s from %s to %s is now beginning!\n", flightNumber,
                    source.name(), destination.name());

            System.out.println("Following passengers are now advised to adjourn to gate '" + gate + "':");
            printPassengers(passengerList);
        } else {
            System.out.println("No passengers to board available!");
        }
        printMethodCall("callPassengers", true);
    }

    public boolean inspectPassport(Passport passport) {
        return true;

    }

    public boolean scanBoardingPass(BoardingPass boardingPass) {
        return true;
    }

    public void printPassengerList(PassengerList passengerList) {
        printMethodCall("printPassengerList", false);
        printPassengers(passengerList);
        printMethodCall("printPassengerList", true);
    }

    public void notifyGroundOperations(BoardingControlReceipt boardingControlReceipt) {
        boardingControlReceipt.setBoardedPassengerList(boardedPassengerList);
        Object groundControlPort = GroundOperationsCenterFactory.build();
        try {
            Method method = groundControlPort.getClass().getMethod("receive", BoardingControlReceipt.class);
            method.invoke(groundControlPort, boardingControlReceipt);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException exc) {
            exc.printStackTrace();
        }
    }

    private void printPassengers(PassengerList passengers) {
        int passengerNumber = 1;
        for (Passenger passenger : passengers.getPassengerList()) {
            System.out.printf("%3d: %s\n", passengerNumber, passenger.toString());
            passengerNumber++;
        }
    }

    private void printMethodCall(String methodName, boolean end) {
        System.out.printf("--- %s.%s\n", (end ? "End " : "") + getClass().getName(), methodName);
    }

    public class Port implements IBoardingControl {

        public void call(PassengerList passengerList) {
            getInstance().callPassengers(passengerList);
        }

        public boolean inspect(Passport passport) {
            return getInstance().inspectPassport(passport);
        }

        public boolean scan(BoardingPass boardingPass) {
            return getInstance().scanBoardingPass(boardingPass);
        }

        public void printPassengerList(PassengerList passengerList) {
            getInstance().printPassengerList(passengerList);
        }

        public void notifyGroundOperations(BoardingControlReceipt boardingControlReceipt) {
            getInstance().notifyGroundOperations(boardingControlReceipt);
        }
    }
}
