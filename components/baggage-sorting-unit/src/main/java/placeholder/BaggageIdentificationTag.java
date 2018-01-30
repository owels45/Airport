package placeholder;

public class BaggageIdentificationTag {

    private String id;
    private BoardingPass boardingPass;

    public BaggageIdentificationTag(String id, BoardingPass boardingPass
                                   ) {
        this.id = id;
        this.boardingPass = boardingPass;

    }

    public String getId() {
        return id;
    }

    public BoardingPass getBoardingPass() {
        return boardingPass;
    }


}
