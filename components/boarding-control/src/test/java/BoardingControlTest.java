import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BoardingControlTest {
    private BoardingControl boardingControl;
    private PassengerList passengerList;

    @Before
    public void init() {
        boardingControl = BoardingControl.getInstance();

        passengerList = new PassengerList(new ArrayList<Passenger>());
        for (int i = 0; i < 100; i++) {
            passengerList.getPassengerList().add(new Passenger("Max Mustermann", "content", "04.01.1995",
                    "Example Street", "74822", "Mosbach", CitizenshipCode.DEU, Gender.Female,
                    null, null, null));
        }

    }

    @Test
    public void testCallPassengers() {
        boardingControl.printPassengerList(passengerList);
    }

    @Test
    public void testInspectPassport() {
        assertTrue(boardingControl.inspectPassport(new Passport("1", "/path/to/picture.png", "DEU", null)));
    }

    @Test
    public void testScanBoardingPass() {
        assertTrue(boardingControl.scanBoardingPass(new BoardingPass("1", Carrier.Lufthansa, "NH380", null, null,
                Source.MUC, Destination.CPT, "01.04.1998", "B4", "13:14", "6F")));
    }

    @Test
    public void testPrintPassengersList() {
        boardingControl.printPassengerList(passengerList);
    }

    @Test
    public void testNotifyGroundOperations() {
        boardingControl.notifyGroundOperations(new BoardingControlReceipt());
    }
}
