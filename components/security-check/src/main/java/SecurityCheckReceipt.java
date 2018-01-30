import base.CottonPad;
import base.Employee;

import java.util.ArrayList;

public class SecurityCheckReceipt {
    private Employee employee;
    private ArrayList<CottonPad> cottonPads;
    private int numberOfPassengerScanned;
    private int numberOfPassengerScannedExplosivesTraceDetector;
    private int numberOfBaggageScanned;
    private int numberOfDangerousBaggage;

    public SecurityCheckReceipt(Employee employee, ArrayList<CottonPad> cottonPads, int numberOfPassengerScanned, int numberOfPassengerScannedExplosivesTraceDetector, int numberOfBaggageScanned, int numberOfDangerousBaggage) {
        this.employee = employee;
        this.cottonPads = cottonPads;
        this.numberOfPassengerScanned = numberOfPassengerScanned;
        this.numberOfPassengerScannedExplosivesTraceDetector = numberOfPassengerScannedExplosivesTraceDetector;
        this.numberOfBaggageScanned = numberOfBaggageScanned;
        this.numberOfDangerousBaggage = numberOfDangerousBaggage;
    }

    public Employee getEmployee() {
        return employee;
    }

    public ArrayList<CottonPad> getCottonPads() {
        return cottonPads;
    }

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
