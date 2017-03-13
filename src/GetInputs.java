import java.util.Scanner;


public class GetInputs {

    Scanner input;

    public String getStringInput(String type, String info ){

        this.input = new Scanner(System.in);
        System.out.println("Your " + type + info + ": ");
        System.out.print(">>> ");
        String value = "";
        if (this.input.hasNextLine()) {
            value = this.input.nextLine();
        }

        return value;

    }

    public Integer getIntInput(String type, String info ){

        this.input = new Scanner(System.in);
        System.out.println("Your " + type + info + ": ");
        System.out.print(">>> ");
        int value = -1;
        if (this.input.hasNextLine()) {
            value = this.input.nextInt();
        }

        return value;

    }

    public String getStringInput(String type ){

        this.input = new Scanner(System.in);
        System.out.println("Your " + type + ": ");
        System.out.print(">>> ");
        String value = "";
        if (this.input.hasNextLine()) {
            value = this.input.nextLine();
        }

        return value;

    }

    public Integer getIntInput(String type ){

        this.input = new Scanner(System.in);
        System.out.println("Your " + type + ": ");
        System.out.print(">>> ");
        int value = -1;
        if (this.input.hasNextLine()) {
            value = this.input.nextInt();
        }

        return value;
    }

    public void closeScanner(){

        this.input.close();
    }
}
