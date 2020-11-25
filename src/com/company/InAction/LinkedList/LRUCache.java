package com.company.InAction.LinkedList;

/*
* https://leetcode-cn.com/problems/lru-cache/
*
* 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
  实现 LRUCache 类：

LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，
则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
* */

import java.util.HashMap;
import java.util.Map;

// 哈希表配合双向数据链表是实现
class LRUCache {

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node () { }
        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;

    private Node tail;

    private int capacity;

    private int size;

    private Map<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            if (size >= capacity) {
                Node tail = removeTail();
                cache.remove(tail.key);
            } else size++;
            Node element = new Node(key, value);
            addToHead(element);
            cache.put(key, element);
        } else {
            node.value = value;
            cache.put(key, node);
            moveToHead(node);
        }
    }

    // 移动到头部
    private void moveToHead(Node node) {
        deleteNode(node);
        addToHead(node);
    }

    // 增加到头部
    private void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    // 删除节点
    private Node deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    // 删除尾巴
    private Node removeTail() {
        Node node = tail.prev;
        deleteNode(node);
        return node;
    }
}

