import java.util.ArrayList;
import java.util.List;

import core.Item;
import core.Knapsack;

public class App {
    public static void main(String[] args) throws Exception {
        Knapsack knapsack = new Knapsack();
        List<Item> store = List.of(
                new Item(12, 4),
                new Item(1, 1),
                new Item(2, 2),
                new Item(1, 2),
                new Item(4, 10));

        List<Item> bruteForceResult = bruteForce(knapsack, store);
    }

    public static List<Item> bruteForce(Knapsack knapsack, List<Item> store) {
        int totalAmountOfItems = store.size();
        List<List<Item>> possibilities = new ArrayList<>();

        // Gerar listas de n itens
        for (int n = 1; n < totalAmountOfItems; n++) {
            System.out.println("Listas de " + n + " itens:");
            List<Item> accumulator = new ArrayList<>();
            next(store, possibilities, accumulator, n, -1);
        }

        return possibilities.get(0);
    }

    public static void next(List<Item> store, List<List<Item>> possibilities, List<Item> accumulator, int max, int last) {
        if (accumulator.size() < max) {
            accumulator.add(store.get(++last));
            next(store, possibilities, accumulator, max, last);
            accumulator.remove(store.get(last));
        } else {
            possibilities.add(List.copyOf(accumulator));
            System.out.println("Possibilidade: " + accumulator.toString());
        }
    }
}
