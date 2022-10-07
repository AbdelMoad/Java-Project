import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        parite();
    }
    public static void discriminant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle est la valeur de a ?");
        int a = scanner.nextInt();
        System.out.println("Quelle est la valeur de b ?");
        int b = scanner.nextInt();
        System.out.println("Quelle est la valeur de c ?");
        int c = scanner.nextInt();

        int delta = (int) (Math.pow(b, 2)- 4 * a * c);
        float s1 = (float) ((-b+Math.sqrt(delta))/(2*a));
        float s2 = (float) ((-b-Math.sqrt(delta))/(2*a));
        float s = (float) ((-b)/(2*a));
        if (delta < 0) {
            System.out.println("Ce polynome n’a pas de racine reelle");
        } else if (delta == 0) {System.out.println("L'unique solution est " + s);
        } else { System.out.println("Les solutions sont " +s1+ " et "+ s2); } }
    public static void parite() {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Selectionner l'entiet ?");
        int entier = scanner2.nextInt();
        if (entier%2==0) {
            System.out.println("Cet entier est pair");
        } else { System.out.println("Cet entier est impair" ); }
    }
    public static void max() {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Selectionner l'entier 1 ?");
        int entier = scanner2.nextInt();
        if (entier%2==0) {
            System.out.println("Cet entier est pair");
        } else { System.out.println("Cet entier est impair" ); }
    }
}