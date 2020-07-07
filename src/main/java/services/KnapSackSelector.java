package services;

import model.Item;
import java.util.List;

/**
 * Select the items which can be fitted in a sack, so that the total value of items in the sack is the highest
 */
public interface KnapSackSelector {
    List<Item> select(List<Item> items, double sackCapacity);

    boolean isFractionalSelector();
}
