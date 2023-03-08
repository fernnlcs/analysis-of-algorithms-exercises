package core;

public class Item {
    private final int id;
    private final double weight;
    private final double value;

    private static int currentId = 0;
    
    public Item(double weight, double value) {
        this.weight = weight;
        this.value = value;
        this.id = currentId++;
    }

    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }
    
    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "#" + getId();
        // return "Item [weight=" + weight + ", value=" + value + "]";
    }
}
