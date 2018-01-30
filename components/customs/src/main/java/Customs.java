import java.util.ArrayList;
import DummyFiles.*;

public class Customs implements ICustoms {

    private int numberOfPassportsVerified;
    private int numberOfBaggageScanned;
    private ArrayList<BoardingPass> boardingPassList;
    private ArrayList<Invoice> invoiceList;
    @Override
    public boolean verify(Passport passport, BoardingPass boardingPass, Invoice parameter)
    {

        return false;
    }

    @Override
    public boolean scan(Baggage baggage) {

        return false;
    }

    @Override
    public void notifyGroundOperations(CustomsReceipt customsReceipt) {

    }
}
