package com.isep.rpg;

import java.util.List;
import java.util.Scanner;

public class Healer extends SpellCaster {

    public Healer(String n) {
    // Le guerrier possède 5 points de vie
        super(n, 4);
        this.sign = "⚕";
}

    // Implémentation de la méthode abstraite "fight" par le guerrier
    @Override
    public void fight(Combatant combatant) {
        combatant.lose( weapon.getDamagePoints() );
    }

    // Implémentation de la méthode abstraite "take" par le guerrier :
    //   Le guerrier ne peut utiliser que les objets de type "Weapon"


    @Override
    public void doAction(List<Combatant> enemies, List<Combatant> heros, int ixHero){
        Scanner scanner = new Scanner(System.in);
        int index;
        while (true) {
            System.out.println("Il reste  "+ mana + " mana, quelle action veut tu faire ?");
            System.out.println("    (1) Attaquer (-"+ weapon.getDamagePoints()+"Pts d'Attaque) ");
            System.out.println("    (2) Guérrir (-15 mana)");
            System.out.println("    (3) Se Nourrir (+5 Pts de Vie)");
            System.out.println("    (4) Utiliser Potion  (+20 mana)");
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    if (enemies.size() == 1 ){
                        fight(enemies.get(0));
                        System.out.println(heros.get(ixHero).getName() + " attaque " + enemies.get(0).getName() + " ! " );
                        if (isAlive(enemies, 0)) {
                            System.out.println(enemies.get(0).getName() + " a été battu !");
                            enemies.remove(0);

                        }
                    } else {
                        System.out.println("Qui veux tu attaquer(-" +  weapon.getDamagePoints()+")");
                        for (int k = 1; k<enemies.size()+1; k++){
                            System.out.println("    ("+ k + ")" + enemies.get(k-1).getName() +" Pts de vie"+ enemies.get(k-1).getHealthPoint());
                        }
                        while(true) {
                            index = scanner.nextInt()-1;
                            if(index >= 0 && index<enemies.size()){
                                break;
                            } else {
                                System.out.println("Mauvaise touche, tape sur les bonnes touches !");
                            }
                        }
                        fight(enemies.get(index));
                        System.out.println("> "+ heros.get(ixHero).getName() + " attaque " + enemies.get(index).getName() + " ! " );
                        if (isAlive(enemies, index)) {
                            System.out.println(enemies.get(index).getName() + " a été battu !");
                            enemies.remove(index);
                        }
                    }
                    return;
                case "2":
                    if (mana >=15){
                        System.out.println("Qui veut tu guérrir ?");
                        for (int i = 0; i<heros.size(); i++){
                            System.out.println("("+ i + ")" + heros.get(i).getName() + " ");
                        }
                        System.out.println();
                        int indey = scanner.nextInt();
                        System.out.println();
                        heros.get(indey).healerHeal();
                        System.out.println(heros.get(indey).getName() + " a été guérri !" );
                        mana -= 15;
                    } else {
                        System.out.println("La Guérisseuse n'a plus de mana");
                    }
                    return;
                case "3":
                    useFood();
                    System.out.println(heros.get(ixHero).getName() + " se nourrit !" );
                    return;
                case "4","use potion":
                    usePotion();
                    System.out.println(heros.get(ixHero).getName() + " a bu une potion de mana !" );
                    return;
                default:
                    System.out.println("Mauvaise touche, tape sur les bonnes touches !");
            }
        }
    }
    @Override
    public void chooseReward(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Que veut tu comme récompense ?");
            System.out.println("    (1) Plus d'Attaque (+2 Pts d'Attaque)");
            System.out.println("    (2) Plus de Nourriture (+1)");
            System.out.println("    (3) Plus de  Potion de Mana (+1)");
            System.out.println("    (4) increase meal efficiency (+2 Pts de Vie)");
            System.out.println("    (5) Potion plus efficace (+5 mana)");
            String reward = scanner.nextLine();
            switch (reward) {
                case "1":
                    this.weapon.increaseDamagePoints();
                    return;
                case "2":
                    food.add(new Food("Repas"));
                    return;
                case "3":
                    potions.add(new Potion());
                    return;
                case "4":
                    for (Food value : food) value.setHpToHeal();
                    return;
                case "5":
                    for (Potion potion : potions) potion.setManaToRegenerate();
                    return;
                default:
                    System.out.println("Mauvaise touche, tape sur les bonnes touches !");
            }
        }
    }

}

