package factory;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import configuration.Configuration;

public class CheckInDeskFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/check-in-desk-1.0.0.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, CheckInDeskFactory.class.getClassLoader());
            Class checkInDeskClass = Class.forName("main.CheckInDesk",true,urlClassLoader);
            Object checkInDeskInstance = checkInDeskClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = checkInDeskClass.getDeclaredField("port").get(checkInDeskInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componentPort;
    }
}