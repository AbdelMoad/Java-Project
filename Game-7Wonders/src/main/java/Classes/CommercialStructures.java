import java.util.ArrayList;
import java.util.List;

public class CommercialStructures extends Effect{
    public CommercialStructures(int w, String c) {
        super("CommercialStructures", "Commercial Structures", w);
        category = c;
    }
    private String category;
    public int CountCategoryPoints(ArrayList<ageCard> cards){
        int k = 0;
        for (ageCard card : cards){
            if(card.getCategory() == category)
                k++;
        }
        return this.getWinningPoints() * k;
    }
}
