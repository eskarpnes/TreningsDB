import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Erlend on 13.03.2017.
 */
public class Workout {

    ArrayList<Result> results = new ArrayList<Result>();
    GetInputs input = new GetInputs();
    Note note;
    Date wo_date;
    int duration;
    int shape;
    int performance;

    public Workout () {
        getUserInput();
    }

    public Workout(Date date, int duration, int shape, int performance) {
        this.wo_date = date;
        this.duration = duration;
        this.shape = shape;
        this.performance = performance;
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
