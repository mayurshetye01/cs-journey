package ch11.s4;

import common.BaseHashTableTest;
import datastructures.HashTable;

public class OpenAddressingHashTableTest extends BaseHashTableTest {
    @Override
    public HashTable<Integer, Integer> getHashTableInstance() {
        return new OpenAddressingHashTable<>(10000000);
    }
}
