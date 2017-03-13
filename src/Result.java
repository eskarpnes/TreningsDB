
public class Result extends GetInputs {

    public String goal;
    public String description;

    public static void main(String[] args) {

        new Result();

    }

    public Result(){

        setDescription();
        setGoal();

    }

    private void setDescription() {

        this.description = getStringInput("description");

    }

    private void setGoal(){

        this.goal = getStringInput("goal");

    }
}


