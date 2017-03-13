import java.util.Scanner;

/**
 * Created by tsm121 on 13/03/2017.
 */
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
        int value = input.nextInt();
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
        int value = input.nextInt();
        input.close();
        return value;

    }
}
