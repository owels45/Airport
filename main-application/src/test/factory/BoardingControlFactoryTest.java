package factory;

import configuration.Configuration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BoardingControlFactoryTest {
    private Object boardingControlPort;

    @Test
    public void testFactoryBuildNotNull() {
        boardingControlPort = BoardingControlFactory.build();
        System.out.println(Configuration.instance.commonPathToJavaArchive + "/boarding-control.jar");
        assertNotNull(boardingControlPort);
    }
}
