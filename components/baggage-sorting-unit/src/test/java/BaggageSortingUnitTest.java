import org.junit.Assert;
import org.junit.Test;
import placeholder.Baggage;
import placeholder.BaggageType;
import placeholder.DestinationBox;
import placeholder.LuggageTub;
import java.util.ArrayList;


public class BaggageSortingUnitTest {

    @Test
    public void BaggageSortingUnitTest_Drop_BaggageIsInLuggage() {
        BaggageSortingUnit.Port port = BaggageSortingUnit.getInstance().port;

        Baggage baggage = new Baggage("1", 1.0, BaggageType.Normal);
        LuggageTub luggageTub = new LuggageTub(null, placeholder.Destination.CPT);
        port.drop(luggageTub, baggage);

        Assert.assertEquals("LuggageTub should contain baggage", baggage, luggageTub.getBaggage());
    }

    @Test
    public void BaggageSortingUnitTest_throwOff_BaggageIsInBox() {
        BaggageSortingUnit.Port port = BaggageSortingUnit.getInstance().port;
        DestinationBox box = new DestinationBox();

        Baggage firstBaggage = new Baggage("1", 1.0, BaggageType.Normal);
        Baggage secondBaggage = new Baggage("2", 2.0, BaggageType.Normal);

        LuggageTub luggageTub = new LuggageTub(null, placeholder.Destination.CPT);
        luggageTub.setBaggage(firstBaggage);
        port.throwOff(luggageTub, box);

        LuggageTub secondTub = new LuggageTub(null, placeholder.Destination.CPT);
        secondTub.setBaggage(secondBaggage);
        port.throwOff(secondTub, box);

        ArrayList<Baggage> baggage = box.getBaggegeList();

        Assert.assertEquals("Baggage count should be correct", 2, baggage.size());
        Assert.assertEquals("Baggage should be correct", firstBaggage, baggage.get(0));
        Assert.assertEquals("Baggage should be correct", secondBaggage, baggage.get(1));
    }


    @Test
    public void BaggageSortingUnitTest_loadDestinationBoxIntoContainers() {

        BaggageSortingUnit unit = BaggageSortingUnit.getInstance();
        unit.setDefaultValues();

        unit.setBaggageList(this.getTestBaggageTestData());

        BaggageSortingUnitReceipt receipt =  BaggageSortingUnit.getInstance().loadDestinationBoxIntoContainers();

    }

    private ArrayList<Baggage> getTestBaggageTestData() {
        ArrayList<Baggage> list = new ArrayList<Baggage>();

        list.add(new Baggage("1", 1.0, BaggageType.Normal));
        list.add(new Baggage("2", 1.0, BaggageType.Normal));

        return list;
    }
}
