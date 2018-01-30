package placeholder;

public class BoardingPass {

    private String id;
    private String flight;
    private TicketClass ticketClass;


    public BoardingPass(String id, TicketClass ticketClass) {
        this.id = id;
        this.ticketClass = ticketClass;

    }


    public TicketClass getTicketClass() {
        return ticketClass;
    }



}
