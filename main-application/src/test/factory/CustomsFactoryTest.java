package factory;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class CustomsFactoryTest {

    private Object componentPort;

    @Test
    void build() {
        componentPort=CustomsFactory.build();
        assertNotNull(componentPort);
    }
}