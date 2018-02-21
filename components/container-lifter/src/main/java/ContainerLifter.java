import java.util.ArrayList;

public class ContainerLifter {
    private static ContainerLifter instance = new ContainerLifter();
    public Port port;
    private boolean isDown=true;

    public ContainerLifter() {port =new Port();}

    public static ContainerLifter getInstance() {
        return instance;
    }

    public boolean innerUp() {
        return !isDown;
    }

    public boolean innerDown() {
        return isDown;
    }

    public int innerLift(ArrayList<Container> containerList, Stowage stowage) {
        if (!isDown){
            innerDown();
        }
        stowage.setContainerList(containerList);

        return 1;
    }

    public void innerNotifyGroundOperations(ContainerLifterReceipt containerLifterReceipt) {

    }

    public class Port implements IContainerLifter{

        public boolean up() {
            return innerUp();
        }

        public boolean down() {
            return innerDown();
        }

        public int lift(ArrayList<Container> containerList, Stowage stowage) {
            return innerLift(containerList, stowage);
        }

        public void notifyGroundOperations(ContainerLifterReceipt containerLifterReceipt) {
            innerNotifyGroundOperations(containerLifterReceipt);
        }
    }
}
