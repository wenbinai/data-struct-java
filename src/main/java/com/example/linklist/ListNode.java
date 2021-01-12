package com.example.linklist;

/**
 * 利用Java 定义一个链表节点
 */
public class ListNode {
    private int data;
    private ListNode next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode(int data) {
        this.data = data;
    }
}
