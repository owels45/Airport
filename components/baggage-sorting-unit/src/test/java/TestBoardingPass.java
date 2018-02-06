public class TestBoardingPass extends BoardingPass {
    public TestBoardingPass(String id, TicketClass ticketClass) {

        super(id, Carrier.Emirates, "Testflight", null,TicketClass.Business, Source.MUC,
                Destination.CPT, "", "", "", "");
    }
}
