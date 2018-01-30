import placeholder.Container;
import placeholder.DestinationBox;

import java.util.ArrayList;

public class BaggageSortingUnitReceipt {

    private DestinationBox destinationBox;
    private ArrayList<Container> containerList;
    private int numberOfBaggageFirstClass;
    private int numberOfBaggageBusinessClass;
    private int numberOfBaggageEconomyClass;
    private int numberOfContainerFirstClass;
    private int numberOfContainerBusinessClass;
    private int numberOfContainerEconomyClass;

    public BaggageSortingUnitReceipt (DestinationBox destinationBox, ArrayList<Container> containerList, int numberOfBaggageFirstClass, int numberOfBaggageBusinessClass, int numberOfBaggageEconomyClass
        , int numberOfContainerFirstClass, int numberOfContainerBusinessClass, int numberOfContainerEconomyClass) {
        this.destinationBox = destinationBox;
        this.containerList = containerList;
        this.numberOfBaggageFirstClass = numberOfBaggageFirstClass;
        this.numberOfBaggageBusinessClass = numberOfBaggageBusinessClass;
        this.numberOfBaggageEconomyClass = numberOfBaggageEconomyClass;
        this.numberOfContainerFirstClass = numberOfContainerFirstClass;
        this.numberOfContainerBusinessClass = numberOfContainerBusinessClass;
        this.numberOfContainerEconomyClass = numberOfContainerEconomyClass;
    }

    public DestinationBox getDestinationBox() {
        return destinationBox;
    }

    public ArrayList<Container> getContainerList() {
        return containerList;
    }

    public int getNumberOfBaggageFirstClass() {
        return numberOfBaggageFirstClass;
    }

    public int getNumberOfBaggageBusinessClass() {
        return numberOfBaggageBusinessClass;
    }

    public int getNumberOfBaggageEconomyClass() {
        return numberOfBaggageEconomyClass;
    }

    public int getNumberOfContainerFirstClass() {
        return numberOfContainerFirstClass;
    }

    public int getNumberOfContainerBusinessClass() {
        return numberOfContainerBusinessClass;
    }

    public int getNumberOfContainerEconomyClass() {
        return numberOfContainerEconomyClass;
    }


}
