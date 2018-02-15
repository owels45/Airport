package event.boarding_control;

import event.boarding_control.base.PassengerList;

public class BoardingControlCallPassengers {
    private PassengerList passengers;

    public BoardingControlCallPassengers(PassengerList passengers) {
        this.passengers = passengers;
    }

    public PassengerList getPassengers() {
        return passengers;
    }
}
