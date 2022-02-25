package com.learning.algorithm.HashTable;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import javax.xml.soap.Node;

/**
 * @author sfx
 * @Description
 */
public class LRUCache {

  private int capacity;

  private int size = 0;

  private NodeList tail = null;

  private NodeList head = null;


  HashMap<Integer, NodeList> map = new HashMap<>();

  public LRUCache(int capacity) {
    this.capacity = capacity;
    head = new NodeList(-1, -1, null, tail);
    tail = new NodeList(-1, -1, head, null);
  }

  public int get(int key) {
    int value = -1;
    NodeList nodeList = map.get(key);
    if (nodeList != null) {
      value = nodeList.val;
      NodeList nextNode=nodeList.next;
      NodeList prevNode=nodeList.prev;
      nextNode.prev=prevNode;
      prevNode.next=nextNode;
      moveToTail(nodeList);
    }
    return value;
  }

  public void put(int key, int value) {
    NodeList nodeList = new NodeList(key, value, null, null);
    if (map.containsKey(key)) {
      NodeList node = map.get(key);
      NodeList nextNode = node.next;
      NodeList prveNode = node.prev;
      prveNode.next = nextNode;
      nextNode.prev = prveNode;
      map.remove(key);
      size--;
    }
    map.put(key, nodeList);
    size++;
    moveToTail(nodeList);
    while (size > capacity) {
      Integer key1 = head.next.key;
      head.next.next.prev = head;
      head.next = head.next.next;
      map.remove(key1);
      size--;
    }
  }


  public void moveToTail(NodeList node) {
    NodeList prevNode = tail.prev;
    node.next = tail;
    node.prev = prevNode;
    prevNode.next = node;
    tail.prev = node;
  }


  public void addToTail(NodeList node) {
    node.next.prev = node.prev;
    node.prev.next = node.next;
    NodeList prevNode = tail.prev;
    node.next = tail;
    node.prev = prevNode;
    prevNode.next = node;
    tail.prev = node;
  }


  public static void main(String[] args) {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // 缓存是 {1=1}
    lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
    System.out.println(lRUCache.get(1));
    lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
    System.out.println(lRUCache.get(2));
    lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
    System.out.println(lRUCache.get(1));
    System.out.println(lRUCache.get(3));
    System.out.println(lRUCache.get(4));

  }
}

class NodeList {

  NodeList prev;

  NodeList next;

  Integer val;

  Integer key;

  public NodeList(Integer key, Integer val, NodeList prev, NodeList next) {
    this.prev = prev;
    this.next = next;
    this.val = val;
    this.key = key;
  }
}
