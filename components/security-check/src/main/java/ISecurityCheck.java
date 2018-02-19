public interface ISecurityCheck {
    boolean scan(Passenger passenger, Object scanner, String pattern);
    boolean scan(Passenger passenger, ExplosivesTraceDetection explosivesTraceDetection);
    boolean scan(Baggage baggage, Object scanner, String pattern);
    void notifyGroundOperations(SecurityCheckReceipt securityCheckReceipt);
}
