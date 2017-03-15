import java.util.Scanner;

/**
 * Created by Thomas on 13.03.2017.
 */

public class GetInputs {
    Scanner input;

    public String getStringInput(String text ){

        this.input = new Scanner(System.in);
        System.out.println(text);
        System.out.print(">>> ");
        String value = "";
        if (this.input.hasNextLine()) {
            value = this.input.nextLine();
        }

        return value;
    }

    public Integer getIntInput(String text ){

        this.input = new Scanner(System.in);
        System.out.println(text);
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
