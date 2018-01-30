package placeholder;

public class BoardingPass {

    private String id;
    private String flight;
    private TicketClass ticketClass;
    private Destination destination;
    private String date;
    private String gate;
    private String boardingTime;
    private String seat;

    public BoardingPass(String id, String flight,
                        TicketClass ticketClass, Destination destination,
                        String date, String gate, String boardingTime, String seat) {
        this.id = id;
        this.flight = flight;
        this.ticketClass = ticketClass;
        this.destination = destination;
        this.date = date;
        this.gate = gate;
        this.boardingTime = boardingTime;
        this.seat = seat;
    }

    public String getId() {
        return id;
    }



    public String getFlight() {
        return flight;
    }



    public TicketClass getTicketClass() {
        return ticketClass;
    }


    public Destination getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public String getGate() {
        return gate;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public String getSeat() {
        return seat;
    }

    public void setId(String id) {
        this.id = id;
    }



    public void setFlight(String flight) {
        this.flight = flight;
    }


    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }



    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }


}
