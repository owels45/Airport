package placeholder;

public class BaggageIdentificationTag {

    private String id;
    private BoardingPass boardingPass;
    private int sequence;
    private String via01 = "N/A";
    private String via02 = "N/A";
    private String via03 = "N/A";
    private Baggage baggage;
    private boolean isLocal;
    private boolean isTransfer;
    private boolean isTransferFirst;
    private String barCode;

    public BaggageIdentificationTag(String id, BoardingPass boardingPass,
                                    int sequence, String via01, String via02, String via03,
                                    Baggage baggage, boolean isLocal,
                                    boolean isTransfer, boolean isTransferFirst, String barCode) {
        this.id = id;
        this.boardingPass = boardingPass;
        this.sequence = sequence;
        this.via01 = via01;
        this.via02 = via02;
        this.via03 = via03;
        this.baggage = baggage;
        this.isLocal = isLocal;
        this.isTransfer = isTransfer;
        this.isTransferFirst = isTransferFirst;
        this.barCode = barCode;
    }

    public String getId() {
        return id;
    }

    public BoardingPass getBoardingPass() {
        return boardingPass;
    }


    public int getSequence() {
        return sequence;
    }

    public String getVia01() {
        return via01;
    }

    public String getVia02() {
        return via02;
    }

    public String getVia03() {
        return via03;
    }

    public Baggage getBaggage() {
        return baggage;
    }


    public boolean isLocal() {
        return isLocal;
    }

    public boolean isTransfer() {
        return isTransfer;
    }

    public boolean isTransferFirst() {
        return isTransferFirst;
    }

    public String getBarCode() {
        return barCode;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setBoardingPass(BoardingPass boardingPass) {
        this.boardingPass = boardingPass;
    }


    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public void setVia01(String via01) {
        this.via01 = via01;
    }

    public void setVia02(String via02) {
        this.via02 = via02;
    }

    public void setVia03(String via03) {
        this.via03 = via03;
    }

    public void setBaggage(Baggage baggage) {
        this.baggage = baggage;
    }



    public void setLocal(boolean local) {
        isLocal = local;
    }

    public void setTransfer(boolean transfer) {
        isTransfer = transfer;
    }

    public void setTransferFirst(boolean transferFirst) {
        isTransferFirst = transferFirst;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }


}
