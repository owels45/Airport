public class Scanner {
    private static Scanner instance = new Scanner();
    public Port port;

    private Scanner() {
        this.port = new Port();
    }

    public String innerGetVersion() {
        return "Scanner - Version 1.0";
    }

    public class Port implements IScanner {

        public boolean scan(Baggage baggage, String pattern) {
            return innerScan(baggage, pattern);
        }

        public boolean scan(Passenger passenger, String pattern) {
            return innerScan(passenger, pattern);
        }

        /**
         * Gets the version of the component.
         *
         * @return The version string.
         */
        public String getVersion() {
            return innerGetVersion();
        }
    }

    private boolean innerScan(Baggage baggage, String pattern) {
        return false;
    }

    private boolean innerScan(Passenger passenger, String pattern) {
        return false;
    }
}
