import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class ContainerLifterUnitTest {

    @Test
    public void liftTest(){
        ArrayList<Container> containers = new ArrayList<Container>();
        Stowage stowage = new Stowage(containers);
        ContainerLifter containerLifter = new ContainerLifter();
        Assertions.assertEquals(1,containerLifter.innerLift(containers, stowage));

    }

}
