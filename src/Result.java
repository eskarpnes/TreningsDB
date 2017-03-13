import java.util.Scanner;

/**
 * Created by Thomas on 13.03.2017.
 */

public class Result {

    private GetInputs input = new GetInputs();

    public String exType = "";
    public String exLocation = "";
    public String exName = "";
    public String description;
    public String goal;
    public int workload;
    public int reps;
    public int sets;

    //Category info
    public int air_quality;
    public int spectators;
    public int temperature;
    public String weather;
    public boolean warmup;

    public static void main(String[] args) {

        System.out.println(new Result());

    }

    public Result(){

        setCategory();
        setExName();
        setDescription();
        setGoal();
        setReps();
        setSets();

    }

    private void setCategory(){

        Scanner in = new Scanner(System.in);
        System.out.println("Where did you do your workout? 1 = inside, 2 = outside");
        System.out.println(">>> ");
        int locInt = in.nextInt();

        System.out.println("What kind of exercise you do? 1 = cardio, 2 = bodybuilding" );
        System.out.println(">>> ");
        int typeInt = in.nextInt();

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

    public GetInputs getInput() {
        return input;
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


