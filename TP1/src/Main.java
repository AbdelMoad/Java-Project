import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        volume();
        Scanner scanner = new Scanner(System.in);
        int unEntier = scanner.nextInt();
        float unReel = scanner.nextFloat();

        System.out.println("J’ai recupere un entier: " + unEntier);
        System.out.println("J’ai aussi recupere un reel: " + unReel);
    }
    public static void somme() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le premier entier");
        int premierEntier = scanner.nextInt();
        System.out.println("Veuillez saisir le deuxieme entier");
        int deuxiemeEntier = scanner.nextInt();
        int somme = premierEntier + deuxiemeEntier;
        System.out.println("La somme de " + premierEntier + " avec " + deuxiemeEntier + " est egale a " + somme);
    }


    public static void volume() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir la hauteur");
        int premierEntier = scanner.nextInt();
        System.out.println("Veuillez saisir la longueur");
        int deuxiemeEntier = scanner.nextInt();
        System.out.println("Veuillez saisir la largeur");
        int troisiemeEntier = scanner.nextInt();
        float volume = (float) premierEntier*deuxiemeEntier*troisiemeEntier;
        System.out.println(" Le volume est " + volume );

    }
}

