<<<<<<< HEAD:components/customs/src/main/java/CustomsReceipt.java

import java.util.ArrayList;
=======
package SupportClasses;
>>>>>>> origin/ground-operation-center-adi:components/ground-operations-center/src/main/java/SupportClasses/CustomsReceipt.java

public class CustomsReceipt {
    private int numberOfPassportVerified;
    private int numberOfBaggageScanned;
    private ArrayList<BoardingPass> boardingPassList;
    private ArrayList<Invoice> invoiceList;

    public CustomsReceipt(int numberOfPassportVerified, int numberOfBaggageScanned, ArrayList<BoardingPass> boardingPassList, ArrayList<Invoice> invoiceList) {
        this.boardingPassList = boardingPassList;
        this.invoiceList = invoiceList;
        this.numberOfBaggageScanned = numberOfBaggageScanned;
        this.numberOfPassportVerified = numberOfPassportVerified;

    }
}
