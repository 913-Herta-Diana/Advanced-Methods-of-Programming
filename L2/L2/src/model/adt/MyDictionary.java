package model.adt;

import java.util.HashMap;
import java.util.Map;

public class MyDictionary<K,V> implements MyIDictionary<K,V>{

    Map<K,V> dictionary;
    public MyDictionary() {
        dictionary = new HashMap<>();
    }
    @Override
    public boolean isDefined(K key) {
        return dictionary.containsKey(key);
    }

    @Override
    public void put(K key, V value) {
        dictionary.put(key, value);
    }

    @Override
    public V lookUp(K key) {
        return dictionary.get(key);
    }
    @Override
    public void update(K key, V value) {
        dictionary.put(key, value);
    }

    @Override
    public String toString() {
        return this.dictionary.toString();
    }
}
