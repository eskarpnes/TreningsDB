/**
 * Created by Erlend on 13.03.2017.
 */
public class Note {

    GetInputs in = new GetInputs();

    private String purpose, tips;

    public Note() {
        this.purpose = in.getStringInputFreetext("What was the purpose of this workout?");
        this.tips = in.getStringInputFreetext("What is the tips from this workout?");
        in.closeScanner();
    }

    public Note(String purpose, String tips){
        this.purpose = purpose;
        this.tips = tips;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getTips() {
        return tips;
    }
}
