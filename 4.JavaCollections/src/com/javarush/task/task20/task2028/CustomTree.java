package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;
    private Entry<String> last;
    private int size = 0;

    public CustomTree() {
        this.root = new Entry<>("elementRoot");
    }

    @Override
    public String get(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String set(int index, String element){
        throw new UnsupportedOperationException();
    }

    public void add(int index, String element){
        if(root.isAvailableToAddChildren()) {
            last = root;
           if (root.availableToAddLeftChildren) {
               last = root;
           } else if (root.availableToAddRightChildren){
               last = root.leftChild;
           }
        }

        Entry<String> newElement = new Entry<>(element);
        if(last.availableToAddLeftChildren){
            last.leftChild = newElement;
            last.availableToAddLeftChildren = false;
            newElement.parent = last;
        } else if(last.availableToAddRightChildren){
            last.rightChild = newElement;
            last.availableToAddRightChildren = false;
            newElement.parent = last;
        }
        size++;
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

    public Entry<String> getParent(String s){
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty(){
        return root == null;
    }

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
}
