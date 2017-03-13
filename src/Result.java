import java.util.Scanner;

/**
 * Created by Thomas on 13.03.2017.
 */

public class Result {

    private GetInputs input = new GetInputs();
    private WorkoutData workoutData = null;

    private String exType = "";
    private String exLocation = "";
    private String exName = "";
    private String description;
    private String goal;
    private int workload;
    private int reps;
    private int sets;

    //Category info
    private int air_quality;
    private int spectators;
    private int temperature;
    private String weather;
    private boolean warmup;

    public Result(){

        setCategory();
        setExName();
        setDescription();
        setGoal();
        setReps();
        setSets();

        addWorkoutData();

    }

    private void addWorkoutData() {

        int value = input.getIntInputFreetext("Do you want do add workout data? 1 = YES, 2 = NO");

        if (value == 1){

            this.workoutData = new WorkoutData();
        }

    }

    private void setCategory(){

        System.out.println("Where did you do your workout? 1 = inside, 2 = outside");
        System.out.println(">>> ");
        int locInt = input.getIntInputFreetext("");

        System.out.println("What kind of exercise you do? 1 = cardio, 2 = bodybuilding" );
        System.out.println(">>> ");
        int typeInt = input.getIntInputFreetext("");

        if (locInt == 1) {
            this.air_quality = input.getIntInputFreetext("How was the air quality? [1-10]");
            this.spectators = input.getIntInputFreetext("How many spectators did you have?");
            this.exLocation = "inside";
        }

        else {
            this.temperature = input.getIntInputFreetext("What was the temperature?");
            this.weather = input.getStringInputFreetext("What was the weather?");
            this.exLocation = "outside";
        }

        setWorkload();

        if (typeInt == 1) {
            this.exType = "cardio";
        }

        else {
            int value = input.getIntInputFreetext("Did you have a warmup? 1 = YES, 2 = NO");
            this.warmup =  (value == 1 ? true : false);
            this.exType = "bodybuilding";
        }
    }

    private void setExName(){

        this.exName = input.getStringInputFreetext("Name your exercise:");

    }

    private void setDescription() {

        this.description = input.getStringInput("description");

    }

    private void setGoal(){

        this.goal = input.getStringInput("goal");

    }

    private void setWorkload(){

        this.workload = input.getIntInput("workload", (this.exType.equals("bodybuilding") ? " in kg" : " in km"));

    }

    private void setReps(){

        this.reps = input.getIntInputFreetext("How many reps did you do?");

    }

    private void setSets(){

        this.sets = input.getIntInputFreetext("How many sets did you do?");

    }

    public String getExType() {
        return exType;
    }

    public String getExLocation() {
        return exLocation;
    }

    public String getExName() {
        return exName;
    }

    public String getDescription() {
        return description;
    }

    public String getGoal() {
        return goal;
    }

    public int getWorkload() {
        return workload;
    }

    public int getReps() {
        return reps;
    }

    public int getSets() {
        return sets;
    }

    public WorkoutData getWorkoutData(){
        return this.workoutData;
    }

    @Override
    public String toString() {

        return ("Description: " + this.description
                + '\n' + "Exercise name: " + this.exName
                + '\n' + "Exercise type: " + this.exType
                + '\n' + "Exercise location: " + this.exLocation
                + '\n' + "Goal: " + this.goal
                + '\n' + "Workload: " + this.workload
                + '\n' + "Number of reps: " + Integer.toString(this.reps)
                + '\n' + "Number of sets: " + Integer.toString(this.sets));

    }
}