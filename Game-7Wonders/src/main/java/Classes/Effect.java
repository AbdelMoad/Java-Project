public abstract class Effect {
    private String name;
    private String description;
    private int winningPoints;

    public Effect(String n,String d, int w){
        name = n;
        description = d;
        winningPoints = w;
    }

    public int getWinningPoints() {
        return winningPoints;
    }

    public String getName() {
        return name;
    }
    public String getDescription(){
        return description;
    }
}
