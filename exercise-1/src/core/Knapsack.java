package core;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private List<Item> items = new ArrayList<>();
    public static final double MAX_CAPACITY = 15;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void add(Item item) {
        items.add(item);
    }

    public void remove(Item item) {
        items.remove(item);
    }

    public double getTotalWeight() {
        double sum = 0;

        for (Item item : items) {
            sum += item.getWeight();
        }

        return sum;
    }

    public double getTotalValue() {
        double sum = 0;

        for (Item item : items) {
            sum += item.getValue();
        }

        return sum;
    }

    public boolean isValid() {
        return getTotalWeight() <= MAX_CAPACITY;
    }
}
