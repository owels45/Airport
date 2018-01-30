package factory;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class GroundOperationsCenterFactory {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = { new File(System.getProperty("user.dir") + System.getProperty("file.separator") +
                    "jar/ground_operations_control_center.jar").toURI().toURL() };
            URLClassLoader urlClassLoader = new URLClassLoader(urls, GroundOperationsCenterFactory.class.getClassLoader());
            Class GroundOperationsCenterClass = Class.forName("GroundoperationsCenterClass", true, urlClassLoader);
            Object GroundOperationsCenterInstance = GroundOperationsCenterClass.getMethod("getInstance").invoke(null);
            componentPort = GroundOperationsCenterClass.getDeclaredField("port").get(GroundOperationsCenterInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
