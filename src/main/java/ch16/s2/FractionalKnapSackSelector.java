package ch16.s2;

import model.Item;
import services.KnapSackSelector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapSackSelector implements KnapSackSelector {
    @Override
    public List<Item> select(List<Item> items, double sackCapacity) {
        //Sort items by value
        Collections.sort(items, Comparator.comparing(Item::getValue));
        java.util.List<Item> collected = new ArrayList<>();
        double remainingCapacity = sackCapacity;
        for (int i = items.size() - 1; i > 0; i--) {
            if (remainingCapacity <= 0)
                break;
            Item current = items.get(i);
            double weightToAdd = current.getWeight() <= remainingCapacity ? current.getWeight() : remainingCapacity;
            Item item = new Item(current.getId(), weightToAdd, current.getValue());
            remainingCapacity -= weightToAdd;
            collected.add(item);
        }
        return collected;
    }

    @Override
    public boolean isFractionalSelector() {
        return true;
    }
}
