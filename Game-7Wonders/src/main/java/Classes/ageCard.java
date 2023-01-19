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
    public int getAge() {
        return age;
    }

    public int getMinimumPlayers() {
        return minimumPlayers;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public boolean isDirection() {
        return direction;
    }

    public List<Effect> getEffects() {
        return effects;
    }

    public List<Resource> getRequiredResources() {
        return requiredResources;
    }

    public String getDescription() {
        return description;
    }
}
