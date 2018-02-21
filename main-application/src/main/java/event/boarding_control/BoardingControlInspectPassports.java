package event.boarding_control;

import event.boarding_control.base.PassengerList;

public class BoardingControlInspectPassports {
    private PassengerList passengers;

    public BoardingControlInspectPassports(PassengerList passengers) {
        this.passengers = passengers;
    }

    public PassengerList getPassengers() {
        return passengers;
    }
}
