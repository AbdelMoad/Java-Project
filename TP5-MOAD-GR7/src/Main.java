
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Main {
    static int[]tableau = new int[Integer.MAX_VALUE / 1000];
    static int SIZE = Integer.MAX_VALUE / 1000;
    initialiserTableau()


    public static void initialiserTableau() {
        Instant start = Instant.now();
        System.out.println("Debut d’initialisation...");
        Random random = new Random();
        int[] tableau= new int[1000];
        for (int i = 0; i < tableau.length; i++) { tableau[i] = random.nextInt(SIZE);
        }
        Instant end = Instant.now(); long duration = Duration.between(start, end).toMillis();
        System.out.println("L’initialisation a pris " + duration + " ms");
    }
}