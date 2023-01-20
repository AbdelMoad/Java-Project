import java.util.Scanner;

public class GUIParser implements IActions{
    public String askName() {
        System.out.println("What's your name ?");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        return name;
    }

}
