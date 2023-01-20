import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyStage {
    private int age;
    private int victoryPoints;
    private List<Resource> resources;
    private boolean isBuild;

    public MyStage(int a, int v, List<Resource>  r){
        age = age;
        victoryPoints = v;
        resources = r;
        isBuild = false;
    }

    public int getVictoryPoints() {
        return victoryPoints;
    }

    public boolean isBuild() {
        return isBuild;
    }

    public List<Resource> getResources() {
        return resources;
    }
    public boolean IsEnoughResources(List<Resource> availableResources){
        List<Resource> rest = this.resourcesNeed(availableResources);
        if (rest.isEmpty())
            return true;
        else return false;
    }
    public List<Resource> resourcesNeed(List<Resource> availableResources){
        ArrayList<Resource> copyAvailable = new ArrayList<Resource>();
        ArrayList<Resource> copyResources = new ArrayList<Resource>();
        Collections.copy(availableResources, copyAvailable);
        Collections.copy(resources, copyResources);
        copyResources.removeAll(copyAvailable);
        return copyResources;
    }
    public void BuildStage(ArrayList<Resource> availableResources){
        if (IsEnoughResources(availableResources))
            isBuild = true;
        else return;
    }
    public int getAge() {
        return age;
    }
}
