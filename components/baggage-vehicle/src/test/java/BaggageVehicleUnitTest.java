import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BaggageVehicleUnitTest {
    @Test
    public void storeTest(){
        BaggageVehicle baggageVehicle = new BaggageVehicle();
        Container container = new Container();
        Assertions.assertEquals(1,baggageVehicle.innerStore(container));

    }
}
