import java.util.ArrayList;

public class ContainerLifter {
    private boolean isDown=true;

    private static ContainerLifter instance = new ContainerLifter();

    public Port port;

    public ContainerLifter() {port =new Port();}

    public static ContainerLifter getinstance() {return instance;}


    public boolean innerUp() {
        return !isDown;
    }

    public boolean innerDown() {
        return isDown;
    }

    public int innerLift(ArrayList<Container> containerList, Stowage stowage) {
        return 1;
    }

    public void innerNotifyGroundOperations(ContainerLifterReceipt containerLifterReceipt) {

    }


    public class Port implements IContainerLifter{

        public boolean up() {
            return !isDown;
        }

        public boolean down() {
            return isDown;
        }

        public int lift(ArrayList<Container> containerList, Stowage stowage) {
            if(up()){
                down();
            }


            return 1;
        }

        public void notifyGroundOperations(ContainerLifterReceipt containerLifterReceipt) {

        }
    }
}
