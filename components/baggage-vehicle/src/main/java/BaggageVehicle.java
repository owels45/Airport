public class BaggageVehicle {

    public static BaggageVehicle instance = new BaggageVehicle();

    public Port port;

    public int innerStore(){
        return 1;
    }
    public void innerConnect(ContainerLifter containerlifter){

    }

    public BaggageVehicle() {port =new Port();}

    public static BaggageVehicle getinstance() {return instance;}

    public class Port implements IBaggageVehicle {
        //private Container container = new Container();
        private ContainerLifter containerLifter = new ContainerLifter();


        public int store(Container container){
            return 1;
        }

        public void connect(ContainerLifter containerlifter){

        }

    }
}
