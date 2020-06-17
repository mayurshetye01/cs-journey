package ch10.s2;

import common.ListTest;
import services.List;

public class SinglyLinkedListTest extends ListTest {
    @Override
    protected List<Integer> getListInstance() {
        return new SinglyLinkedList<>();
    }
}
