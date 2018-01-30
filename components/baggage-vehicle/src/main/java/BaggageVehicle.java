public class BaggageVehicle {

    public static BaggageVehicle instance = new BaggageVehicle();

    public Port port;

    public int innerStore(){
        return 1;
    }

    public void innerConnect(Object containerlifter){

    }

    private BaggageVehicle() {port =new Port();}

    public static BaggageVehicle getInstance() {return instance;}

    public class Port implements IBaggageVehicle {
        //private Container container = new Container();
        private Object containerLifterPort;


        public int store(Container container){
            return innerStore();
        }

        public void connect(Object containerLifterPort){
            innerConnect(containerLifterPort);
        }

    }
}
