import com.isep.rpg.Dragon;
import com.isep.rpg.Game;
import com.isep.rpg.Warrior;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // Il faudra initialiser un "InputParser"...
        Game game = new Game(null);
        game.start();




    }
}