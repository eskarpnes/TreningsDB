import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Erlend on 13.03.2017.
 */
public class Workout {

//    ArrayList<Result> results = new ArrayList<Result>();
    GetInputs input = new GetInputs();
    Note note;
    String wo_date, wo_time;
    int wo_num, duration, shape, performance;


    public Workout () {
        this.wo_date = getDate();
        getUserInput();
    }

    public Workout(int wo_num, String date, String time, int duration, int shape, int performance) {
        this.wo_num = wo_num;
        this.wo_date = date;
        this.wo_time = time;
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

//    public void addResult() {
////        results.add(new Result());
////    }

    public void getUserInput() {
        this.duration = input.getIntInput("Input duration in minutes");
        this.shape = input.getIntInput("Input shape from 1-10");
        this.performance = input.getIntInput("Input performance from 1-10");
    }

//    public int getTotal() {
//        int total = 0;
//        for (Result result : results) {
//            int load = result.getWorkload();
//            int sets = result.getSets();
//            int reps = result.getReps();
//            total += load*sets*reps;
//        }
//        return total;
//    }

}
