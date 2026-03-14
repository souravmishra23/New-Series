package linkedlist;

import java.util.HashMap;

public class LRUCache {

    HashMap<Integer, Node> cache;
    Node head;
    Node tail;
    int capacity;


    public static void main(String[] args) {

    }

    public void put(int key, int data) {
        if (!cache.containsKey(key)) {
             Node newNode = new Node();
             newNode.data = data;
             newNode.key = key;
             if (cache.size() == capacity) {
                 Node lru_node = tail.prev;
                 cache.remove(lru_node.key);
                 removeNode(lru_node);
             } else {
                 cache.put(key, newNode);
                addNode(newNode);
             }

        } else {
            Node node = cache.get(key);
            node.data = data;
            moveToFront(node);
        }
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToFront(node);
            return node.data;
        } else {
            return -1;
        }
    }

    public void addNode(Node node) {
        Node nbr = head.next;

        nbr.prev = node;
        node.next = nbr;
        node.prev = head;
        head.next = node;
    }

    public void removeNode(Node node) {
        Node prevNbr = node.prev;
        Node nextNbr = node.next;

        prevNbr.next = nextNbr;
        nextNbr.prev = prevNbr;

        node.next = node.prev = null;
    }

    public void moveToFront(Node node) {
        removeNode(node);
        addNode(node);
    }
}


class Node {
    int key,data;
    Node prev;
    Node next;


}