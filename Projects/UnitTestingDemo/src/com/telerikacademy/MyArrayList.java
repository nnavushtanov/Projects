package com.telerikacademy;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements MyList<E> {
    
    private Object[] data;
    private int usedPositions;
    
    public MyArrayList() {
        data = new Object[4];
        usedPositions = 0;
    }
    
    public MyArrayList(E[] e) {
        data = new Object[e.length];
        
        for (E value : e) {
            add(value);
        }
    }
    
    @Override
    public int getUsedPositions() {
        return usedPositions;
    }
    
    @Override
    public E getLast() {
        return get(getUsedPositions() - 1);
    }
    
    @Override
    public E getFirst() {
        return get(0);
    }
    
    @Override
    public int getSize() {
        return data.length;
    }
    
    @Override
    public void add(E element) {
        if (usedPositions == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[usedPositions] = element;
        usedPositions++;
    }
    
    @Override
    public E get(int index) {
        checkIndexIsValid(index);
        return (E) data[index];
    }
    
    @Override
    public void set(int index, E value) {
        checkIndexIsValid(index);
        data[index] = value;
    }
    
    @Override
    public int findIndexOf(E value) {
        for (int i = 0; i < usedPositions; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
    
    private void checkIndexIsValid(int index) {
        if (index < 0 || index >= getUsedPositions()) {
            throw new IndexOutOfBoundsException();
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }
    
    private class MyIterator implements Iterator<E> {
        
        int currentPosition;
        
        MyIterator() {
            currentPosition = 0;
        }
        
        @Override
        public boolean hasNext() {
            return currentPosition < usedPositions;
        }
        
        @Override
        public E next() {
            E result = (E) data[currentPosition];
            currentPosition++;
            return result;
        }
        
    }
    
}
