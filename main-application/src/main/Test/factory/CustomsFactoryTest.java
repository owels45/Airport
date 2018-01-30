package factory;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class CustomsFactoryTest {

    private Object componentPort;

    @Test
    public void build() {
        componentPort=CustomsFactory.build();
        assertNotNull(componentPort);
    }
}