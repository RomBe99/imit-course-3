package ru.omsu.imit.multithreading.task12;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentHashMap<K, V> {
    private Map<K, V> map;
    private ReadWriteLock lock;

    public ConcurrentHashMap() {
        this.map = new HashMap<>();
        this.lock = new ReentrantReadWriteLock();
    }

    public boolean isEmpty() {
        lock.writeLock().lock();

        try {
            return this.map.isEmpty();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void clear() {
        lock.readLock().lock();

        try {
            this.map.clear();
        } finally {
            lock.readLock().unlock();
        }
    }

    public boolean containsKey(K key) {
        lock.writeLock().lock();

        try{
            return this.map.containsKey(key);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public boolean containsValue(V value) {
        lock.writeLock().lock();

        try{
            return this.map.containsValue(value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public V remove(K key) {
        lock.readLock().lock();

        try{
            return this.map.remove(key);
        } finally {
            lock.readLock().unlock();
        }
    }

    public int size() {
        lock.readLock().lock();

        try{
            return this.map.size();
        } finally {
            lock.readLock().unlock();
        }
    }

    public V put(K key, V value) {
        lock.writeLock().lock();

        try{
            return this.map.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }
}