package factory;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
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
