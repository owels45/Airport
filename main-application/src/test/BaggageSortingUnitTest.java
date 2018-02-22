import event.baggage_sorting.BaggageSorting;
import org.junit.Assert;
import org.junit.Test;
import base.Baggage;
import base.BaggageType;
import base.BaggageIdentificationTag;
import base.Destination;
import base.TicketClass;

import java.util.ArrayList;
import java.util.List;


public class BaggageSortingUnitTest {

    @Test
    public void BaggageSortingUnitTest_loadDestinationBoxIntoContainers() {
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

        ArrayList<Object> vehicles = this.generateBaggageVehicles(6);

        ArrayList<BaggageIdentificationTag> combinedTags = new ArrayList<BaggageIdentificationTag>();
        combinedTags.addAll(firstClassTags);
        combinedTags.addAll(economyClassTags);
        combinedTags.addAll(businessClassTags);
        combinedTags.addAll(premiumEconomyClassTags);


        BaggageSorting baggageSorting = new BaggageSorting("K20", Destination.CPT, combinedBaggage, vehicles, combinedTags);

        Airport airport = new Airport();
        airport.build();

        airport.receive(baggageSorting);

        BaggageSortingUnitReceipt receipt = null;


        //First class:
        Assert.assertEquals("Should contain one container for first class", 1 , receipt.getNumberOfContainerFirstClass());
        Assert.assertEquals("Should contain first class baggage", 45 , receipt.getNumberOfBaggageFirstClass());

        // Business:
        Assert.assertEquals("Should contain two container for business class", 2 , receipt.getNumberOfContainerBusinessClass());
        Assert.assertEquals("Should contain business class baggage", 75 , receipt.getNumberOfBaggageBusinessClass());

        // Economy:
        Assert.assertEquals("Should contain two container for economy class", 3 , receipt.getNumberOfContainerEconomyClass());
        Assert.assertEquals("Should contain economy class baggage", 106 , receipt.getNumberOfBaggageEconomyClass());

        Assert.assertTrue("Containers should be correct" ,this.AssertContainers(receipt));
    }

    private boolean AssertContainers(BaggageSortingUnitReceipt receipt) {
        List<Container> containers = receipt.getContainerList();

        int firstClassContainerCount  = this.getContainerCountForCategory(containers, ContainerCategory.First);
        int businessClassContainerCount  = this.getContainerCountForCategory(containers, ContainerCategory.Business);
        int economyClassContainerCount  = this.getContainerCountForCategory(containers, ContainerCategory.Economy);

        Assert.assertEquals("Correct number of containers should be in the receipt", 6, containers.size());
        Assert.assertEquals("Correct number of first class containers should be in the receipt", 1, firstClassContainerCount);
        Assert.assertEquals("Correct number of business class containers should be in the receipt", 2, businessClassContainerCount);
        Assert.assertEquals("Correct number of economy class containers should be in the receipt", 3, economyClassContainerCount);
        return true;
    }

    private int getContainerCountForCategory(List<Container> containers, ContainerCategory category) {
        int counter = 0;
        for (Container container : containers ) {
            if (container.getCategory() == category) { counter++; }
        }
        return counter;
    }

    private ArrayList<Object> generateBaggageVehicles(int size) {
        ArrayList<Object> vehicles = new ArrayList<Object>();
        for (int i = 0; i < size; i++) vehicles.add(new MockBaggageVehicle());

         return vehicles;
    }

    private ArrayList<BaggageIdentificationTag> createBaggageTagsForBaggage(ArrayList<Baggage> baggageList, TicketClass ticketClass) {
        ArrayList<BaggageIdentificationTag> tags = new ArrayList<BaggageIdentificationTag>();
        for (Baggage bagggage : baggageList ) {
            tags.add(new TestBaggageIdentificationTag(bagggage.getId(), new TestBoardingPass(bagggage.getId(), ticketClass)));
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
