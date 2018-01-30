package factory;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class FederalPoliceFactoryTest {
    private Object componentPort;

    @Test
    public void testBuild() {
        componentPort = FederalPoliceFactory.build();
        assertNotNull(componentPort);
    }

    @Test
    public void testGetInstance() {
        componentPort = FederalPoliceFactory.build();
        try {
            Method getInstanceMessage = componentPort.getClass().getDeclaredMethod("verify");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}