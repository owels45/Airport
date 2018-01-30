import java.io.FileInputStream;
import java.util.Properties;

public enum SecurityCheckConfiguration {
    instance;

    public String userDirectory = System.getProperty("user.dir");
    public String fileSeparator = System.getProperty("file.separator");

    public String commonPathToJavaArchives = userDirectory.replace("security-check", "scanner")+ fileSeparator;

    public Class scannerClass;

    public void loadComponents() {
        SecurityCheckComponentManagement baggageSystemComponentManagement = new SecurityCheckComponentManagement();
        // scanner
        Class scannerClass = baggageSystemComponentManagement.loadJavaArchive("search.jar","Search");
        this.scannerClass = scannerClass;
    }
}