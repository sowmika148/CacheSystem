package com.sowmika;

class Node {
    Object data;
    Node prev;
    Node next;

    Node(Object obj) {
        this.data = obj;
        this.prev = null;
        this.next = null;
    }
}
