import org.junit.Assert;
import org.junit.Test;

public class ScannerTest {
    @Test
    public void Scanner_Baggage_Found(){
        Scanner scanner = Scanner.getInstance();
        Scanner.Port port = scanner.port;

        Baggage bag = new Baggage("TestStringGlockEnde");

        Assert.assertTrue("Scanner should find the pattern", port.scan(bag, "Glock"));
    }

    @Test
    public void Scanner_Baggage_NothingFound(){
        Scanner scanner = Scanner.getInstance();
        Scanner.Port port = scanner.port;

        Baggage bag = new Baggage("TestStringEnde");

        Assert.assertFalse("Scanner should find nothing", port.scan(bag, "Glock"));
    }

    @Test
    public void Scanner_Passenger_InContentFound(){
        Scanner scanner = Scanner.getInstance();
        Scanner.Port port = scanner.port;

        Passenger passenger = new Passenger("Mario Glock");
        passenger.baggageList.add(new Baggage("TestStringEnde"));
        passenger.baggageList.add(new Baggage("StringTest"));

        Assert.assertTrue("Scanner should find nothing", port.scan(passenger, "Glock"));
    }
    @Test
    public void Scanner_Passenger_InBaggageFound(){
        Scanner scanner = Scanner.getInstance();
        Scanner.Port port = scanner.port;

        Passenger passenger = new Passenger("Mario Test");
        passenger.baggageList.add(new Baggage("TestStringEnde"));
        passenger.baggageList.add(new Baggage("StringGLOCKTest"));

        Assert.assertTrue("Scanner should find nothing", port.scan(passenger, "Glock"));
    }

    @Test
    public void Scanner_Passenger_NothingFound(){
        Scanner scanner = Scanner.getInstance();
        Scanner.Port port = scanner.port;

        Passenger passenger = new Passenger("Mario Test");
        passenger.baggageList.add(new Baggage("TestStringEnde"));
        passenger.baggageList.add(new Baggage("StringTest"));

        Assert.assertFalse("Scanner should find nothing", port.scan(passenger, "Glock"));
    }
}
