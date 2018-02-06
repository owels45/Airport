import java.util.ArrayList;

public class BoardingControlReceipt {
    private CheckInDesk checkInDesk;
    private PassengerList boardedPassengerList;

    public BoardingControlReceipt() {
        checkInDesk = new CheckInDesk();
        boardedPassengerList = new PassengerList(new ArrayList<Passenger>());
    }

    public BoardingControlReceipt(PassengerList list) {
        this();
        boardedPassengerList = list;
    }

    public PassengerList getBoardedPassengerList() {
        return boardedPassengerList;
    }

    public void setBoardedPassengerList(PassengerList boardedPassengerList) {
        this.boardedPassengerList = boardedPassengerList;
    }

    public CheckInDesk getCheckInDesk() {
        return checkInDesk;
    }

    public void setCheckInDesk(CheckInDesk checkInDesk) {
        this.checkInDesk = checkInDesk;
    }
}
