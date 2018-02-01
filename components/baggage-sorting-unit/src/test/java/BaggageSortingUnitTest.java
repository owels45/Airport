import org.junit.Assert;
import org.junit.Test;
import placeholder.*;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class BaggageSortingUnitTest {

    @Test
    public void BaggageSortingUnitTest_Drop_BaggageIsInLuggage() {
        BaggageSortingUnit unit = BaggageSortingUnit.getInstance();

        Baggage baggage = new Baggage("1", 1.0, BaggageType.Normal);
        LuggageTub luggageTub = new LuggageTub(null, placeholder.Destination.CPT);
        unit.drop(luggageTub, baggage);

        Assert.assertEquals("LuggageTub should contain baggage", baggage, luggageTub.getBaggage());
    }

    @Test
    public void BaggageSortingUnitTest_throwOff_BaggageIsInBox() {
        BaggageSortingUnit unit = BaggageSortingUnit.getInstance();
        DestinationBox box = new DestinationBox();

        Baggage firstBaggage = new Baggage("1", 1.0, BaggageType.Normal);
        Baggage secondBaggage = new Baggage("2", 2.0, BaggageType.Normal);

        LuggageTub luggageTub = new LuggageTub(null, placeholder.Destination.CPT);
        luggageTub.setBaggage(firstBaggage);
        unit.throwOff(luggageTub, box);

        LuggageTub secondTub = new LuggageTub(null, placeholder.Destination.CPT);
        secondTub.setBaggage(secondBaggage);
        unit.throwOff(secondTub, box);

        ArrayList<Baggage> baggage = box.getBaggegeList();

        Assert.assertEquals("Baggage count should be correct", 2, baggage.size());
        Assert.assertEquals("Baggage should be correct", firstBaggage, baggage.get(0));
        Assert.assertEquals("Baggage should be correct", secondBaggage, baggage.get(1));
    }


    @Test
    public void BaggageSortingUnitTest_loadDestinationBoxIntoContainers() {

        BaggageSortingUnit.Port port = BaggageSortingUnit.getInstance().port;

        

        BaggageSortingUnitReceipt receipt = port.execute();

        ArrayList<Baggage> firstClassBaggages = this.getTestBaggageTestData(0, 45);
        ArrayList<Baggage> businessClassBaggages = this.getTestBaggageTestData(96, 75);
        ArrayList<Baggage> economyClassBaggages = this.getTestBaggageTestData(171, 51);
        ArrayList<Baggage> premiumEconomyClassBaggages = this.getTestBaggageTestData(222, 55);


        ArrayList<BaggageIdentificationTag> firstClassTags =  this.createBaggageTagsForBaggage(firstClassBaggages, TicketClass.First);
        ArrayList<BaggageIdentificationTag> businessClassTags = this.createBaggageTagsForBaggage(businessClassBaggages, TicketClass.Business);
        ArrayList<BaggageIdentificationTag> economyClassTags =  this.createBaggageTagsForBaggage(economyClassBaggages, TicketClass.Economy);
        ArrayList<BaggageIdentificationTag> premiumEconomyClassTags = this.createBaggageTagsForBaggage(premiumEconomyClassBaggages, TicketClass.PremiumEconomy);

        ArrayList<Baggage> combinedBaggage = new ArrayList<Baggage>();
        combinedBaggage.addAll(firstClassBaggages);
        combinedBaggage.addAll(economyClassBaggages);
        combinedBaggage.addAll(businessClassBaggages);
        combinedBaggage.addAll(premiumEconomyClassBaggages);

        ArrayList<BaggageIdentificationTag> combinedTags = new ArrayList<BaggageIdentificationTag>();
        combinedTags.addAll(firstClassTags);
        combinedTags.addAll(economyClassTags);
        combinedTags.addAll(businessClassTags);
        combinedTags.addAll(premiumEconomyClassTags);

        unit.setBaggageList(combinedBaggage);
        unit.setBaggageIdentificationTags(combinedTags);

        DestinationBox box = unit.getDestinationBox();
        // This would happen in a previous step.
        box.setBaggegeList(unit.getBaggageList());

        BaggageSortingUnitReceipt receipt =  BaggageSortingUnit.getInstance().loadDestinationBoxIntoContainers();

        //First class:
        Assert.assertEquals("Should contain one container for first class", 1 , receipt.getNumberOfContainerFirstClass());
        Assert.assertEquals("Should contain first class baggage", 45 , receipt.getNumberOfBaggageFirstClass());

        // Business:
        Assert.assertEquals("Should contain two container for business class", 2 , receipt.getNumberOfContainerBusinessClass());
        Assert.assertEquals("Should contain business class baggage", 75 , receipt.getNumberOfBaggageBusinessClass());

        // Economy:
        Assert.assertEquals("Should contain two container for economy class", 3 , receipt.getNumberOfContainerEconomyClass());
        Assert.assertEquals("Should contain economy class baggage", 106 , receipt.getNumberOfBaggageEconomyClass());
    }

    private ArrayList<BaggageIdentificationTag> createBaggageTagsForBaggage(ArrayList<Baggage> baggageList, TicketClass ticketClass) {
        ArrayList<BaggageIdentificationTag> tags = new ArrayList<BaggageIdentificationTag>();
        for (Baggage bagggage : baggageList ) {
            tags.add(new BaggageIdentificationTag(bagggage.getId(), new BoardingPass(bagggage.getId(),ticketClass)));
        }
        return tags;
    }

    private ArrayList<Baggage> getTestBaggageTestData(int offset, int count) {
        ArrayList<Baggage> list = new ArrayList<Baggage>();

        for (int i = 0 + offset; i < count + offset; i++) {
            list.add(new Baggage( "" + i, 1.0, BaggageType.Normal));
        }

        return list;
    }
}
