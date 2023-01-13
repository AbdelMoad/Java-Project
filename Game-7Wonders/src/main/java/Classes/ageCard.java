import java.util.List;

public abstract class ageCard {
    private int age;
    private String name;
    private String description;
    private String category;
    private int minimumPlayers;
    private boolean direction;
    protected List<Resource> requiredResources;
    protected List<Effect> effects;

    public ageCard(int a, String n, String d, String c, int mp, boolean dir, List<Resource> r,List<Effect> ef){
        age = a;
        name = n;
        description = d;
        category = c;
        minimumPlayers = mp;
        direction = dir;
        requiredResources = r;
        effects = ef;
    }
}
