public class Scanner {
    private static Scanner instance = new Scanner();
    public Port port;

    public String getVersion() {
        return "Scanner - Version 1.0";
    }

    public class Port implements IScanner {

        public boolean scan(Baggage baggage, String pattern) {
            return false;
        }

        public boolean scan(Passenger passenger, String pattern) {
            return false;
        }
    }
}
