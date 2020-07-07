package common;

import model.Item;
import org.junit.jupiter.api.Test;
import services.KnapSackSelector;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class KnapSackSelectorTest {

    protected abstract KnapSackSelector getKnapSackSelector();

    @Test
    void testSelection() {
        double sackCapacity = 80.0;
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, 10, 60));
        items.add(new Item(2, 20, 100));
        items.add(new Item(3, 30, 120));
        items.add(new Item(4, 50, 130));

        final KnapSackSelector knapSackSelector = getKnapSackSelector();
        List<Item> result = knapSackSelector.select(items, sackCapacity);

        List<Item> expected = new ArrayList<>();
        if(knapSackSelector.isFractionalSelector()){
            expected.add(new Item(4, 50, 130));
            expected.add(new Item(3, 30, 120));
        }
        else {
            expected.add(new Item(1, 10, 60));
            expected.add(new Item(2, 20, 100));
            expected.add(new Item(4, 50, 130));
        }
        assertEquals(expected.size(), result.size());
        assertTrue(expected.containsAll(result));
    }
}
