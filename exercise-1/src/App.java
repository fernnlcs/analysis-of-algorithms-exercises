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

        bruteForce(knapsack, store);

        System.out.print("A melhor combinação é a dos itens ");
        System.out.print(knapsack.getItems());
        System.out.print(" cujo peso é " + knapsack.getTotalWeight());
        System.out.print(" e o valor é $ " + knapsack.getTotalValue());
    }

    public static void bruteForce(Knapsack knapsack, List<Item> store) {
        int totalAmountOfItems = store.size();
        List<List<Item>> combinations = new ArrayList<>();

        // Gerar listas de n itens
        for (int max = 0; max <= totalAmountOfItems; max++) {
            List<Item> accumulator = new ArrayList<>();
            generate(store, combinations, accumulator, max, -1);
        }

        for (List<Item> combination : combinations) {
            Knapsack test = new Knapsack();
            test.setItems(combination);

            if (test.isValid() && test.getTotalValue() > knapsack.getTotalValue()) {
                knapsack.setItems(combination);
            }
        }
    }

    public static void generate(List<Item> store, List<List<Item>> combinations, List<Item> accumulator, int max,
            int last) {
        if (max == 0) {
            combinations.add(List.copyOf(accumulator));
        }
        for (int i = last + 1; i < store.size(); i++) {
            if (accumulator.size() < max) {
                accumulator.add(store.get(++last));
                generate(store, combinations, accumulator, max, last);

                if (accumulator.size() >= max) {
                    combinations.add(List.copyOf(accumulator));
                }

                accumulator.remove(store.get(last));
            }
        }
    }
}
