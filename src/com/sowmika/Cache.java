package com.sowmika;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cache {

    private HashMap<Object, Node> map;
    private Node head;
    private Node tail;

    public Cache() {
        this.map = new HashMap<>();
        this.head = new Node(-1);
        this.tail = this.head;
    }

    public boolean contains(Object object) {
        return map.containsKey(object);
    }

    public boolean isFull(int size) {
        return map.size() >= size;
    }

    public void addElement(Object object) {
        Node node = new Node(object);
        map.put(object, node);
        node.prev = tail;
        tail.next = node;
        tail = tail.next;
    }

    public List<Object> getElements() {
        List<Object> cacheElements = new ArrayList<>();
        Node temp = head.next;
        while (temp != null) {
            cacheElements.add(temp.data);
            temp = temp.next;
        }
        return cacheElements;
    }

    public void reRankObject(Object object) {
        Node node = this.map.get(object);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = tail;
        tail.next = node;
        tail = tail.next;
        tail.next = null;
    }

    public void deleteLeastRecentlyUsedElement() {
        Node node = head.next;
        map.remove(node.data);
        head.next = node.next;
        if (head.next == null) {
            tail = head;
        } else {
            node.next.prev = head;
        }
    }

    public void deleteMostRecentlyUsedElement() {
        Node node = tail;
        map.remove(node.data);
        tail = node.prev;
        tail.next = null;
    }
}
