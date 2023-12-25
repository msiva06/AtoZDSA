package StacksAndQueues;

import java.util.HashMap;
import java.util.Map;

// LRU cache
public class Problem_08 {
    class Node{
    Node prev,next;
    int key, value;
    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}
public class LRUCache
{
    Map<Integer,Node> map = new HashMap<>();
    int capacity;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    LRUCache(int capacity)
    {   
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key)
    {
        if(map.containsKey(key)){
            Node keyNode = map.get(key);
            remove(keyNode);
            insert(keyNode);
            return keyNode.value;
        }
        else{
            return -1;
        }
    }

    public void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node newNode){
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
        map.put(newNode.key,newNode);
    }

    public void put(int key, int value)
    {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        Node newNode = new Node(key,value);
        insert(newNode);
    }
}
}
