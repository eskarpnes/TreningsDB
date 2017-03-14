import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Erlend on 13.03.2017.
 */
public class Workout {

    ArrayList<Result> results = new ArrayList<Result>();
    GetInputs input = new GetInputs();
    Note note;
    String wo_date;
    int duration;
    int shape;
    int performance;

    public Workout () {
        this.wo_date = getDate();
        getUserInput();
    }

    public Workout(String date, int duration, int shape, int performance) {
        this.wo_date = date;
        this.duration = duration;
        this.shape = shape;
        this.performance = performance;
    }

    public String getDate() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        String month = "" + (calendar.get(Calendar.MONTH) + 1);
        String day = "" + calendar.get(Calendar.DAY_OF_MONTH);
        if (month.length() == 1) {
            month = "0" + month;
        }
        if (day.length() == 1) {
            day = "0" + day;
        }
        return year + "-" + month + "-" + day;
    }

    public void addNote() {
        this.note = new Note();
    }

    public void addResult() {
        results.add(new Result());
    }

    public void getUserInput() {
        this.duration = input.getIntInput("Input duration in minutes");
        this.shape = input.getIntInput("Input shape from 1-10");
        this.performance = input.getIntInput("Input performance from 1-10");
    }

}
