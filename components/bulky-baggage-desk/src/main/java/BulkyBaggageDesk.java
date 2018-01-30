import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class BulkyBaggageDesk implements IBulkyBaggageDesk {
    private int id;
    private Employee employee;
    private int numberOfSpecialGoods;

    public boolean scan(Passport passport) {
        return true;
    }

    public boolean scan(BoardingPass boardingPass) {
        return true;
    }

    public BaggageIdentificationTag checkIn(BoardingPass boardingPass, SpecialGood specialGood) {
        return new BaggageIdentificationTag(
                UUID.randomUUID().toString(),
                boardingPass,
                boardingPass.getCarrier(),
                -1,
                "bla",
                "bla",
                "bla",
                null,
                specialGood,
                false,
                false,
                false,
                "00000"
        );
    }

    public void notifyGroundOperations(BulkyBaggageDeskReceipt bulkyBaggageDeskReceipt) {
        Object groundOperationsPort = ComponentLoader.loadComponent("ground-operations-center", "GroundOperationsCenter");
        try {
            groundOperationsPort.getClass().getMethod("receive", BulkyBaggageDeskReceipt.class).invoke(groundOperationsPort, bulkyBaggageDeskReceipt);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("could not notify ground operations center", e);
        }
    }
}
