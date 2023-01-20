import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wonder {
    private String name;
    private boolean isTaken;
    private boolean side;
    private MyStage localStage;
    private Resource startingResource;
    private List<Resource> availableResources = new ArrayList<>();
    private MyStage stage1;
    private MyStage stage2;
    private MyStage stage3;
    public Wonder(String n, boolean s, Resource r, MyStage s1, MyStage s2, MyStage s3){
        availableResources.add(r);
        localStage = s1;
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
        if (this.IsEnoughResources(card.requiredResources))
            myCards.add(card);
        else return;
    }
    public void addTreasure(Treasure t){
        myTreasures.add(t);
    }
    List<ageCard> myCards = new ArrayList<ageCard>();
    List<militaryToken> myMilitaryTokens = new ArrayList<militaryToken>();
    List<Treasure> myTreasures = new ArrayList<Treasure>();

    public String getName() {
        return name;
    }

    public boolean isSide() {
        return side;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public MyStage getLocalStage() {
        return localStage;
    }
    public void setLocalStage(MyStage localStage) {
        this.localStage = localStage;
    }
    public void fight(){

    }
    public Resource getStartingResource() {
        return startingResource;
    }
    public List<Resource> getResourceLocalStage(){
         return  localStage.getResources();
    }
    public void nextStage(){
        if (localStage.equals(stage1))
            localStage = stage2;
        else if (localStage.equals(stage2))
            localStage = stage2;
        else return;
    }
    public int countWinningPoint(){
        int result = 0;
        for (militaryToken mil : myMilitaryTokens) {
            result += mil.getAmount();
        }
        int treasAmount = 0;
        for (Treasure treas : myTreasures) {
            treasAmount += treas.getAmount();
        }
        result += treasAmount/3;
        return result;
    }
    public boolean IsEnoughResources(List<Resource> resourcesWeNeed){
        List<Resource> rest = this.resourcesNeed(resourcesWeNeed);
        if (rest.isEmpty())
            return true;
        else return false;
    }
    public List<Resource> resourcesNeed(List<Resource> resourcesWeNeed){
        ArrayList<Resource> copyAvailable = new ArrayList<Resource>();
        Collections.copy(availableResources, copyAvailable);
        resourcesWeNeed.removeAll(copyAvailable);
        return resourcesWeNeed;
    }
}
