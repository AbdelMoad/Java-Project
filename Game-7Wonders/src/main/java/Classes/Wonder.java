import java.util.ArrayList;
import java.util.List;

public class Wonder {
    private String name;
    private boolean isTaken;
    private boolean side;
    private Resource startingResource;
    private MyStage stage1;
    private MyStage stage2;
    private MyStage stage3;
    public Wonder(String n, boolean s, Resource r, MyStage s1, MyStage s2, MyStage s3){
        name = n;
        isTaken = false;
        side = s;
        startingResource = r;
        stage1 = s1;
        stage2 = s2;
        stage3 = s3;
    }
    public void MakeTaken(){
        isTaken = true;
    }
    public void addMilitaryToken(militaryToken m){
        myMilitaryTokens.add(m);
    }
    public void addAgeCard(ageCard card){
        myCards.add(card);
    }
    public void addTreasure(Treasure t){
        myTreasures.add(t);
    }
    List<ageCard> myCards = new ArrayList<ageCard>();
    List<militaryToken> myMilitaryTokens = new ArrayList<militaryToken>();
    List<Treasure> myTreasures = new ArrayList<Treasure>();

    public int countWinningPoint(){
        int result = 0;
        return result;
    }
}
