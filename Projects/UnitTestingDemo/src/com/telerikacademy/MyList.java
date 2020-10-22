package com.telerikacademy;

public interface MyList<E> extends Iterable<E> {
    
    E getLast();
    
    E getFirst();
    
    int getSize();
    
    E get(int index);
    
    int findIndexOf(E value);
    
    void add(E element);
    
    int getUsedPositions();
    
    void set(int index, E value);
    
}
