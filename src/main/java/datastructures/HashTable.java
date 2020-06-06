package datastructures;

import java.util.Set;

public interface HashTable<K, V> {

    void put(K key, V value);

    V get(K key);

    void remove(K key);

    boolean containsKey(K key);

    Set<Entry<K, V>> entrySet();

    int size();

    interface Entry<K, V> {
        K getKey();

        V getValue();

        void setValue(V value);
    }
}
