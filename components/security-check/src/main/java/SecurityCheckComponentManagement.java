import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class SecurityCheckComponentManagement {
    public Class loadJavaArchive(String componentName,String className) {
        Class clazz = null;

        try {
            URL[] urls = {new File(SecurityCheckConfiguration.instance.commonPathToJavaArchives + componentName).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls,SecurityCheck.class.getClassLoader());
            clazz = Class.forName(className,true,urlClassLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clazz;
    }
}