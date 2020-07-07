package ch16.s2;

import model.Item;
import services.KnapSackSelector;

import java.util.ArrayList;
import java.util.List;

public class WholeKnapSackSelector implements KnapSackSelector {
    @Override
    public List<Item> select(List<Item> items, double sackCapacity) {
        if (items == null || items.isEmpty() || sackCapacity <= 0)
            return null;
        int numberOfItems = items.size();
        List<List<Item>> collectedItemsByIndex = new ArrayList<>();
        for (int i = 0; i < numberOfItems; i++) {
            Item current = items.get(i);
            double currWeight = current.getWeight();
            List<Item> collected = new ArrayList<>();
            if (currWeight <= sackCapacity) {
                collected.add(current);
                List<Item> remaining = removeItem(i, items);
                List<Item> collectedFromRemaining = select(remaining, sackCapacity - currWeight);
                if (collectedFromRemaining != null && !collectedFromRemaining.isEmpty())
                    collected.addAll(collectedFromRemaining);
            }
            collectedItemsByIndex.add(collected);
        }
        return findOptimal(collectedItemsByIndex);
    }


    @Override
    public boolean isFractionalSelector() {
        return false;
    }

    private List<Item> findOptimal(List<List<Item>> collectedItemsByIndex) {
        if (collectedItemsByIndex == null || collectedItemsByIndex.isEmpty())
            return null;

        int indexWithMaxValue = Integer.MIN_VALUE;
        double maxValue = -Double.MIN_VALUE;
        for (int i = 0; i < collectedItemsByIndex.size(); i++) {
            double currValue = getTotalValue(collectedItemsByIndex.get(i));
            if (currValue > maxValue) {
                indexWithMaxValue = i;
                maxValue = currValue;
            }
        }
        return collectedItemsByIndex.get(indexWithMaxValue);
    }

    private List<Item> removeItem(int index, List<Item> items) {
        List<Item> remainingItems = new ArrayList<>();
        remainingItems.addAll(items);
        remainingItems.remove(index);
        return remainingItems;
    }

    private double getTotalValue(List<Item> optimalItemsFromRemaining) {
        double totalValue = 0;
        for (Item item : optimalItemsFromRemaining)
            totalValue += item.getValue();
        return totalValue;
    }
}
