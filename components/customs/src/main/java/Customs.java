import java.util.ArrayList;
import DummyFiles.*;

public class Customs{

    private static Customs instance = new Customs();

    public Port port;

    private Customs(){
        port = new Port();
        numberOfPassportsVerified=0;
        numberOfBaggageScanned=0;
        boardingPassList=new ArrayList<>();
        invoiceList=new ArrayList<>();
    }

    public static Customs getInstance(){ return instance; }

    private int numberOfPassportsVerified;
    private int numberOfBaggageScanned;
    private ArrayList<BoardingPass> boardingPassList;
    private ArrayList<Invoice> invoiceList;

    public class Port implements ICustoms{

        @Override
        public boolean verify(Passport passport, BoardingPass boardingPass, Invoice parameter) { return innerMethodVerify(passport, boardingPass, parameter); }

        @Override
        public boolean scan(Baggage baggage) { return innerMethodScan(baggage); }


        @Override
        public void notifyGroundOperations(CustomsReceipt customsReceipt) { innerMethodNotifyGroundOperations(customsReceipt); }
        }
    }
    public boolean innerMethodVerify(Passport passport, BoardingPass boardingPass, Invoice parameter)
    {
        if (passport.getPassanger() == boardingPass.getPassanger()) {
            return true;
        }
        return false;
    }

    public boolean innerMethodScan(Baggage baggage) {

        return false;
    }

    public void innerMethodNotifyGroundOperations(CustomsReceipt customsReceipt) {

    }
}
