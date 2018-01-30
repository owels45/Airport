import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ServiceVehicleOilTest {

    private ServiceVehicleOil.Port port;
    private Object aPUOilTankPort;

    @Before
    public void init() {
        port = ServiceVehicleOil.getInstance().port;
        //aPUOilTankPort = APUOilTankFactory.build();
    }

    @Test
    public void testIncreaseLevelOfAPUOilTank() {
        //assertEquals(2, port.increaseLevelOfAPUOilTank());
    }

}
