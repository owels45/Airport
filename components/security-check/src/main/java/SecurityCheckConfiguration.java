import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public enum SecurityCheckConfiguration {
    instance;

    public String userDirectory = System.getProperty("user.dir");
    public String fileSeparator = System.getProperty("file.separator");

    public String commonPathToJavaArchives = userDirectory.replace("security-check", "scanner")+ fileSeparator;

    public Class scannerClass;

    public void loadComponents() {
        Class scannerClass = loadJavaArchive("search.jar","Search");
        this.scannerClass = scannerClass;
    }

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