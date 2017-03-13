import java.util.Scanner;

public class Result {

    public GetInputs input = new GetInputs();

    public String exType = "";
    public String exLocation = "";
    public String exName = "";
    public String description;
    public String goal;
    public int workload;
    public int reps;
    public int sets;


    public static void main(String[] args) {

        System.out.println(new Result());

    }

    public Result(){

        setCategory();
        setExName();
        setDescription();
        setGoal();
        setWorkload();
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

        if (locInt == 1) {this.exLocation = "inside";}
        else {this.exLocation = "outside";}

        if (typeInt == 1) {this.exType = "cardio";}
        else {this.exType = "bodybuilding";}

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


