import base.CottonPad;
import base.Employee;

import java.util.ArrayList;

public class SecurityCheckReceipt {
    /**
     * The Employee
     */
    private Employee employee;
    /**
     * The Cotton Pads
     */
    private ArrayList<CottonPad> cottonPads;
    /**
     * The Number of Passengers Scanned
     */
    private int numberOfPassengerScanned;
    /**
     * The Number of Passengers Scanned for Explosives
     */
    private int numberOfPassengerScannedExplosivesTraceDetector;
    /**
     * The Number of Bags Scanned
     */
    private int numberOfBaggageScanned;
    /**
     * The Number of Dangerous Bags
     */
    private int numberOfDangerousBaggage;
    /**
     * The Constructor of the Security Check Receipt
     * @param employee The Employee
     * @param cottonPads The Cotton Pads
     * @param numberOfPassengerScanned The Number of Passengers Scanned
     * @param numberOfPassengerScannedExplosivesTraceDetector The Number of Passengers Scanned Explosives
     * @param numberOfBaggageScanned The Number of Bags Scanned
     * @param numberOfDangerousBaggage The Number of Dangerous Bags
     */
    public SecurityCheckReceipt(Employee employee, ArrayList<CottonPad> cottonPads, int numberOfPassengerScanned, int numberOfPassengerScannedExplosivesTraceDetector, int numberOfBaggageScanned, int numberOfDangerousBaggage) {
        this.employee = employee;
        this.cottonPads = cottonPads;
        this.numberOfPassengerScanned = numberOfPassengerScanned;
        this.numberOfPassengerScannedExplosivesTraceDetector = numberOfPassengerScannedExplosivesTraceDetector;
        this.numberOfBaggageScanned = numberOfBaggageScanned;
        this.numberOfDangerousBaggage = numberOfDangerousBaggage;
    }
    /**
     * Increments the Number of Passengers Scanned By One
     */
    public void incrementNumberOfPassengerScannedByOne() {
        this.numberOfPassengerScanned++;
    }
    /**
     * Increments the Number of Passengers Scanned for Explosives By One
     */
    public void incrementNumberOfPassengerScannedExplosivesTraceDetectorByOne() {
        this.numberOfPassengerScannedExplosivesTraceDetector++;
    }
    /**
     * Increments the Number of Bags Scanned By One
     */
    public void incrementNumberOfBaggageScannedByOne() {
        this.numberOfBaggageScanned++;
    }
    /**
     * Increments the Number of Dangerous Bags By One
     */
    public void incrementNumberOfDangerousBaggageByOne() {
        this.numberOfDangerousBaggage++;
    }
    /**
     * Get the Employee
     * @return The Employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Get The Cotton Pads
     * @return The Cotton Pads
     */
    public ArrayList<CottonPad> getCottonPads() {
        return cottonPads;
    }

    /**
     * Get The Number of Passengers Scanned
     * @return The Number of Passengers Scanned
     */
    public int getNumberOfPassengerScanned() {
        return numberOfPassengerScanned;
    }

    public int getNumberOfPassengerScannedExplosivesTraceDetector() {
        return numberOfPassengerScannedExplosivesTraceDetector;
    }

    public int getNumberOfBaggageScanned() {
        return numberOfBaggageScanned;
    }

    public int getNumberOfDangerousBaggage() {
        return numberOfDangerousBaggage;
    }
}
