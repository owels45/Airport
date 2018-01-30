import java.util.ArrayList;
import base.*;

public class CustomsReceipt {
    private int numberOfPassportVerified;
    private int numberOfBaggageScanned;
    private ArrayList<BoardingPass> boardingPassList;
    private ArrayList<Invoice> invoiceList;

    public CustomsReceipt(int numberOfPassportVerified, int numberOfBaggageScanned, ArrayList<BoardingPass> boardingPassList, ArrayList<Invoice> invoiceList){
        this.boardingPassList = boardingPassList;
        this.invoiceList = invoiceList;
        this.numberOfBaggageScanned = numberOfBaggageScanned;
        this.numberOfPassportVerified = numberOfPassportVerified;

    }
}
