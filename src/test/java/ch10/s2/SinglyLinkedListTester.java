package ch10.s2;

import common.ListTester;
import services.List;

public class SinglyLinkedListTester extends ListTester {
    @Override
    protected List<Integer> getListInstance() {
        return new SinglyLinkedList<>();
    }
}
