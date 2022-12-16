package com.isep.utils;
import com.isep.rpg.Game;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;
public class ConsoleParser implements InputParser {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // Il faudra initialiser un "InputParser"...
        Game game = new Game(null);
        game.start();
    }



    public void parseInput(String input, Game game) {

    }


}
