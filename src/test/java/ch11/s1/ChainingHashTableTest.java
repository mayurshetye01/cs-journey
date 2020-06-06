package ch11.s1;

import common.BaseHashTableTest;
import datastructures.HashTable;

public class ChainingHashTableTest extends BaseHashTableTest {

    @Override
    public HashTable<Integer, Integer> getHashTableInstance() {
        return new ChainingHashTable<>();
    }
}
