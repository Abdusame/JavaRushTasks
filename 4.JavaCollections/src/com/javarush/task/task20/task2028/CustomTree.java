package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

    Entry<String> root;
    private int count = 0;
    private List<Entry<String>> list = new LinkedList<>();

    public CustomTree() {
        this.root = new Entry<String>("root");
    }

    @Override
    public boolean add(String s) {
        int i = 0;
        boolean res = false;
        do {
            Entry<String> el = list.get(list.size() - 1);
            if (el.leftChild == null){
                el.availableToAddLeftChildren = true;
                list.add(el);
            } else {
                el.leftChild = new Entry(s);
                el.leftChild.parent = el;
                el.availableToAddLeftChildren = false;
                count++;
                res = true;
                break;
            }
            if (el.rightChild == null){
                el.availableToAddRightChildren = true;
                list.add(el);
            } else {
                el.rightChild = new Entry<>(s);
                el.rightChild.parent = el;
                el.availableToAddRightChildren = false;
                count++;
                res = true;
                break;
            }
            i++;
        } while (i < list.size());

        return res;
    }

    public String getParent(String value){
        return null;
    }

    @Override
    public String get(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String set(int index, String element){
        throw new UnsupportedOperationException();
    }

    public void add(int index, String element){
        throw new UnsupportedOperationException();
    }

    public String remove(int index){
        throw new UnsupportedOperationException();
    }

    public List<String> subList(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }

    protected void removeRange(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends String> c){
        throw new UnsupportedOperationException();
    }
}
