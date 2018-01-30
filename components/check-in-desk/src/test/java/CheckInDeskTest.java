import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CheckInDeskTest {

    @Test
    public void checkInTest(){
        Passenger passenger = new Passenger(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
        Baggage baggage = new Baggage(
                "1",
                2,
                BaggageType.Normal
        );
        BoardingPass expectedBoardingPass = new BoardingPass(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        ArrayList<Baggage> listBaggage = new ArrayList<Baggage>();
        listBaggage.add(baggage);
        BoardingPass result = null;
        CheckInDesk checkInDesk = CheckInDesk.getInstance();
        result = checkInDesk.innerCheckIn(passenger, listBaggage);
        assertEquals(expectedBoardingPass.toString(), result.toString());
    }

    @Test
    public void scan1(){
        Passport passport = new Passport("1", "pic", "N/A", null);
        CheckInDesk checkInDesk = CheckInDesk.getInstance();
        boolean result = checkInDesk.innerScan(passport);
        assertEquals(true, result);
    }

    @Test
    public void checkInTest1(){
        Baggage baggage = new Baggage("1", 2, null);
        BaggageIdentificationTag baggageIdentificationTag = new BaggageIdentificationTag(
                "1",
                null,
                null,
                1,
                null,
                null,
                null,
                null,
                null,
                true,
                true,
                true,
                null
        );
        CheckInDesk checkInDesk = CheckInDesk.getInstance();
        BaggageIdentificationTag result = checkInDesk.innerCheckIn(baggage);
        assertEquals(baggageIdentificationTag.toString(), result.toString());
    }

}
