import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Erlend on 13.03.2017.
 */
public class Main {

    Tool tool;
    LoadDatabase db = null;
    public Main() {
        getUserFunction();
    }

    public void getUserFunction() {
        this.tool = new Tool();
        String input = "";
        while (!input.equals("quit")) {
            System.out.println("");
            System.out.println("Which function do you want to use?");
            System.out.println("Input workout | Best workout | Statistics");
            input = tool.getStringInput("");
            if (input.trim().toLowerCase().equals("tool workout")) {
                inputWorkout();
            } else if (input.trim().toLowerCase().equals("best workout")) {
                bestWorkout();
            } else if (input.trim().toLowerCase().equals("statistics")) {
                statistics();
            } else if (!input.equals("quit")){
                System.out.println("Not a valid tool");
            }
        }
        tool.closeScanner();
    }

    //Inputs a workout to the database
    public void inputWorkout() {
        String input;
        Workout workout = new Workout();
        input = tool.getStringInput("Do you want to add a note?");
        if (input.toLowerCase().equals("yes")||input.toLowerCase().equals("y")) {
           workout.addNote();
        }
        int num = tool.getIntInput("How many exercises did you do?");
        for (int i = 0; i<num; i++) {
            System.out.println("Inputting exercise number " + Integer.toString(i+1));
//            workout.addResult();
        }
    }

    //Gets the best workout tool the last 7 days
    public void bestWorkout() {
        System.out.println("Calculating the best workout");
        //Get all workouts from the last 7 days.
        SQL_Workout sqlwo = new SQL_Workout(db);
        SQL_Result sqlres = new SQL_Result(db);
        String dateString = tool.getDate(7);
        sqlwo.fetch(" WHERE workout_date > '" + dateString + "'");
        ArrayList<Workout> workouts = sqlwo.getResults();
        for (Workout workout : workouts) {
            sqlres.fetch(workout.id);
            ArrayList<Result> results = sqlres.getResults();
            workout.addResults(results);
        }
        HashMap<Workout, Integer> map = new HashMap();
        for (Workout workout : workouts) {
            map.put(workout, workout.getTotal());
        }

        int _max = 0;
        Workout _maxw = null;
        for (Map.Entry<Workout, Integer> entry : map.entrySet()) {
            if (entry.getValue() > _max) {
                _max = entry.getValue();
                _maxw = entry.getKey();
            }
        }

        System.out.println("Your best workout was: ");
        _maxw.toString();
        System.out.println("With a total volume of " + Integer.toString(_max));
    }

    //Gets statistics from the database
    public void statistics() {
        System.out.println("Fetching statistics");
    }


    public static void main(String[] args) {
        Main m = new Main();
    }
}
