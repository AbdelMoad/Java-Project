import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        egaliteStr();
    }
    public static void discriminant() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Quelle est la valeur de a ?");
        int a = scanner1.nextInt();
        System.out.println("Quelle est la valeur de b ?");
        int b = scanner1.nextInt();
        System.out.println("Quelle est la valeur de c ?");
        int c = scanner1.nextInt();

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
        int entier1 = scanner2.nextInt();
        System.out.println("Selectionner l'entier 2 ?");
        int entier2 = scanner2.nextInt();
        if (entier1 > entier2) {
            System.out.println("Le maximum est "+ entier1);
        } else { System.out.println("Le maximum est " + entier2 ); }
    }
    public static void egaliteStr() {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Selectionner la premiere chaine de caractère");
        String chaine1 = scanner2.nextLine();
        System.out.println("Selectionner la deuxieme chaine de caractère");
        String chaine2 = scanner2.nextLine();
        boolean test3 = chaine1.equals(chaine2);
        System.out.println(test3); //test3

    }

}