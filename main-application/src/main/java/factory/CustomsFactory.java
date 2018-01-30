package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class CustomsFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/customs.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, CustomsFactory.class.getClassLoader());
            Class CustomsClass = Class.forName("CustomsClass", true, urlClassLoader);
            Object CustomsInstance = CustomsClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = CustomsClass.getDeclaredField("port").get(CustomsInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
