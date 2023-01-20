import java.util.ArrayList;
import java.util.Arrays;

public class ScientificStructures extends Effect {
    public ScientificStructures() {
        super("ScientificStructures", "Scientific Structures", 1);
    }
    public int ReturnGreenPoints(ArrayList<ageCard> cards){
        int result = 0;
        int Compass = 0;
        int Wheel = 0;
        int Stone = 0;
        for (ageCard card : cards){
            if (card.getCategory() == "GreenCompass")
                Compass++;
            if (card.getCategory() == "GreenWheel")
                Wheel++;
            if (card.getCategory() == "GreenStone")
                Stone++;
        }
        int[] greens = {Compass,Wheel,Stone};
        Arrays.sort(greens);
        result += greens[0] * 7 + greens[0]*greens[0] + greens[1]*greens[1] + greens[2]*greens[2];
        return result;
    }
}
