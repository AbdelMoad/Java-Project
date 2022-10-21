import java.util.Scanner;

public class SafeScanner {
    public int getInt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your age?");
        int answer = sc.nextInt();
        System.out.printf("Your age is %d%n", answer);
        sc.close();
        return answer; //Tes
    }
}
