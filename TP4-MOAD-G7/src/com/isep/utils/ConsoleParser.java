package com.isep.utils;
import com.isep.rpg.Game;

import java.util.Scanner;
public class ConsoleParser implements InputParser {
    public static void main(String[] args) {
        // Il faudra initialiser un "InputParser"...
        Game game = new Game(null);
        game.start();
    }



    public void parseInput(String input, Game game) {

    }


}
