package com.telerikacademy.set;

public interface MyHashSet<T> {

    void add(T value);

    void remove(T value);

    int size();

    boolean contains(T value);
    
    int capacity();

}
