package generics;

/**
 * @author:
 */
public class Meat extends Food {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return hashCode() + "肉";
    }
}
