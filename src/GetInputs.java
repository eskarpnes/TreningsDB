import java.util.Scanner;


public class GetInputs {

    public String getStringInput(String type, String info ){

        Scanner input = new Scanner(System.in);
        System.out.println("Your " + type + info + ": ");
        System.out.print(">>> ");
        String value = input.nextLine();
        input.close();
        return value;

    }

    public Integer getIntInput(String type, String info ){

        Scanner input = new Scanner(System.in);
        System.out.println("Your " + type + info + ": ");
        System.out.print(">>> ");
        int value = Integer.parseInt(input.nextLine());
        input.close();
        return value;

    }

    public String getStringInput(String type ){

        Scanner input = new Scanner(System.in);
        System.out.println("Your " + type + ": ");
        System.out.print(">>> ");
        String value = input.nextLine();
        input.close();
        return value;

    }

    public Integer getIntInput(String type ){

        Scanner input = new Scanner(System.in);
        System.out.println("Your " + type + ": ");
        System.out.print(">>> ");
        int value = Integer.parseInt(input.nextLine());
        input.close();
        return value;

    }
}
