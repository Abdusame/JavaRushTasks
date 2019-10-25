package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>((int)Math.max(16, Math.ceil(collection.size()/.75f)));
        this.addAll(collection);
    }

    @Override
    public boolean add(E e){
        return null == map.put(e, PRESENT);
    }

    @Override
    public Iterator iterator() {
        Set<E> keySet = map.keySet();
        return keySet.iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public Object clone() {
        try {
            AmigoSet amigo = this;
            amigo.map = (HashMap) map.clone();
            return amigo;
        } catch (Exception e) {
            throw new InternalError();
        }
    }
}
