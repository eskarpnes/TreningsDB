/**
 * Created by Erlend on 13.03.2017.
 */
public class Note {

    private String notePurpose, noteTips;

    public Note(String purpose, String tips){

        notePurpose = purpose;
        noteTips = tips;

    }

    public String getPurpose() {
        return notePurpose;
    }

    public String getTips() {
        return noteTips;
    }
}
