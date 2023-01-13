public abstract class Resource {
    private String category;
    private String name;
    public Resource(String c, String n){
        category = c;
        name = n;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
