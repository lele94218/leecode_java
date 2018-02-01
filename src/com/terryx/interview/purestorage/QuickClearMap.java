package com.terryx.interview.purestorage;

import java.util.*;

/**
 * @author taoranxue on 11/1/17 8:37 PM.
 */
public class QuickClearMap<K, V> {
    private Object[] table;
    private List<V> list = new LinkedList<>();
    private int version = 0;

    public QuickClearMap() {
        table = new Object[1024];
    }

    public void add(K key, V value) {
        table[key.hashCode()] = value;
        list.add(value);
    }

    public void delete(K key) {
        if (table[key.hashCode()] != null) {
            list.remove(table[key.hashCode()]);
        }
        table[key.hashCode()] = null;

    }

    public V lookup(K key) {
        return (V) table[key.hashCode()];
    }

    public void clear() {
        list = new LinkedList<>();
    }

    public V[] iterative() {
        Object[] res = new Object[list.size()];
        int idx = 0;
        for (V v : list) {
            res[idx++] = v;
        }
        return (V[]) res;
    }

}
