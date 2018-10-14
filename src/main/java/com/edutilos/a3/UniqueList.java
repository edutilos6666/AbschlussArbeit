package com.edutilos.a3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by edutilos on 12.05.18.
 */

/**
 * Diese Klasse ist als ob die Kombination von Klasse ArrayList<T> und HashSet<T>
 * @param <T>
 */
public class UniqueList<T> {
    private HashSet<T> masterSet = new HashSet<>();
    private ArrayList<T> innerList;
    private Object[] returnable;

    /**
     * Default Konstruktor
     */
    public UniqueList() {
        innerList = new ArrayList<>();
    }

    /**
     * Konstruktor
     * @param size vom Typ int
     */
    public UniqueList(int size) {
        innerList = new ArrayList<>(size);
    }

    /**
     * Konstruktor
     * @param els vom Typ ...
     */
    public UniqueList(T ...els) {
        innerList = new ArrayList<>();
        for(T el: els) {
            add(el);
        }
    }

    /**
     *
     * @param thing vom Typ T
     */
    public void add(T thing) {
        if (!masterSet.contains(thing)) {
            masterSet.add(thing);
            innerList.add(thing);
        }
    }

    /**
     *
     * @return vom Typ int
     */
    public int size() {
        return innerList.size();
    }

    /**
     *
     * @return vom Typ List<T>
     */
    public List<T> getList() {
        return innerList;
    }

    /**
     *
     * @param index vom Typ int
     * @return vom Typ T
     */
    public T get(int index) {
        return innerList.get(index);
    }

    /**
     *
     * @param el vom Typ T
     * @return vom Typ boolean
     */
    public boolean contains(T el) {
        return innerList.contains(el);
    }

    /**
     *
     * @return vom Typ Object[]
     */
    public Object[] toObjectArray() {
        int size = innerList.size();
        returnable = new Object[size];
        for (int i = 0; i < size; i++) {
            returnable[i] = innerList.get(i);
        }
        return returnable;
    }
}
