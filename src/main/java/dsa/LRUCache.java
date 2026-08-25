package main.java.dsa;

import java.util.HashMap;
import java.util.Map;

/**
 * Demonstrates an LRU (Least Recently Used) Cache.
 *
 * <p>The cache uses a HashMap for O(1) key lookup and a doubly linked
 * list to maintain the order of recently used entries.
 *
 * <p>The most recently used entry is kept near the head and the
 * least recently used entry near the tail.
 *
 * <p>Time complexity:
 * <br>get: O(1) average
 * <br>put: O(1) average
 *
 * <p>Space complexity: O(capacity)
 */
public class LRUCache {

    private static class Node {

        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;

    private final Map<Integer, Node> cache = new HashMap<>();

    private final Node head = new Node(0, 0);
    private final Node tail = new Node(0, 0);

    public LRUCache(int capacity) {

        this.capacity = capacity;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        Node node = cache.get(key);

        if (node == null) {
            return -1;
        }

        remove(node);
        addToFront(node);

        return node.value;
    }

    public void put(int key, int value) {

        Node existing = cache.get(key);

        if (existing != null) {
            existing.value = value;

            remove(existing);
            addToFront(existing);

            return;
        }

        Node node = new Node(key, value);

        cache.put(key, node);
        addToFront(node);

        if (cache.size() > capacity) {

            Node leastRecentlyUsed = tail.prev;

            remove(leastRecentlyUsed);
            cache.remove(leastRecentlyUsed.key);
        }
    }

    private void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 100);
        cache.put(2, 200);

        System.out.println(cache.get(1));

        cache.put(3, 300);

        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}