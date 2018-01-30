package factory;

import factory.GroundOperationsCenterFactory;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertNotNull;

public class TestGroundControlsCenterFactory {
    private Object componentPort;

    @Test
    public void build() {
        componentPort = GroundOperationsCenterFactory.build();
        assertNotNull(componentPort);
    }

    @Test
    public void receive() {
        componentPort = GroundOperationsCenterFactory.build();
        try {
            //Method onMethod = componentPort.getClass().getDeclaredMethod("on");
            //boolean isOn = (boolean)onMethod.invoke(componentPort);
            //assertEquals(true,isOn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
