import base.Baggage;
import base.Passenger;

public interface ISecurityCheck {
    boolean scan(Passenger passenger, Scanner scanner, String pattern);
    boolean scan(Passenger passenger, ExplosivesTraceDetection explosivesTraceDetection);
    boolean scan(Baggage baggage, Scanner scanner, String pattern);
    void notifyGroundOperations(SecurityCheckReceipt securityCheckReceipt);
}
