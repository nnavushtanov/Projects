package com.telerikacademy.set;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyHashSetImpl<T> implements MyHashSet<T> {

    //measure of how full the HashSet is allowed to get before its capacity is automatically increased
    // https://howtodoinjava.com/java/collections/java-hashset/
    private static final double LOAD_FACTOR = 0.75d;

    private int capacity = 16; // the number of buckets (in backing HashMap) when HashSet is created
    private int size = 0;
    private List<T>[] buckets = new ArrayList[capacity];

    @Override
    public void add(T value) {
        // check if is in the set
        if (contains(value)) {
            return;
        }

        // using index function find in what list should go (the list is in the index bucket)
        // get the list from buckets[index]
        List<T> bucketForThisValue = getBucket(value);

        // add the element
        bucketForThisValue.add(value);
        size++;
        if (sizeIsOverThreshold()) {
            resize();
        }
    }

    @Override
    public void remove(T value) {
        if (!contains(value)) {
            throw new IllegalArgumentException("Not in set");
        }

        List<T> bucket = getBucket(value);
        bucket.removeIf(el -> el.equals(value));
        size--;
    }

    @Override
    public boolean contains(T value) {
        // get bucket for this value
        List<T> bucket = getBucket(value);
        // check if is in the list for this bucket
        return bucket.contains(value);
    }

    @Override
    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    private List<T> getBucket(T value) {
        int indexForThisValue = index(value);

        // Why there are nulls?
        // All lists were initialized with their default value - null
        // If we haven't added value yet, the buckets are null.
        if (buckets[indexForThisValue] == null) {
            buckets[indexForThisValue] = new ArrayList<>();
        }

        return buckets[indexForThisValue];
    }

    private void resize() {
        capacity *= 2;
        List<T>[] oldBuckets = buckets;
        buckets = new ArrayList[capacity];

        size = 0;
        // add values from all non null buckets
        for (List<T> bucket : oldBuckets) {
            if (bucket != null) {
                for (T value : bucket) {
                    add(value);
                }
            }
        }
    }

    // input - egn (some unique value)
    // using hashcode of egn & reminder bucket's length
    // output int - valid index in buckets array
    private int index(T value) {
        // use Objects, so null is okay
        return Math.abs(Objects.hashCode(value)) % buckets.length;
    }

    private boolean sizeIsOverThreshold() {
        // This is called threshold and is equal to (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY).
        // When HashSet elements count exceed this threshold, HashSet is resized and new capacity is double the previous capacity.
        return size >= capacity * LOAD_FACTOR;
    }

}
