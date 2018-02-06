public class TestBoardingPass extends BoardingPass {
    public TestBoardingPass(String id, TicketClass ticketClass) {

        super(id, Carrier.Emirates, "Testflight", null,ticketClass, Source.MUC,
                Destination.CPT, "", "", "", "");
    }
}
