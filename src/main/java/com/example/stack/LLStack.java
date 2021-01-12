package com.example.stack;


/**
 * 利用链表模拟栈
 * <p>
 * 思想: 通过在链表的表头插入元素实现push()操作
 * 删除链表的表头节点实现pop()操作
 */
public class LLStack {
    private LLNode headNode;

    /**
     * 栈的初始化
     */
    public LLStack() {
        this.headNode = new LLNode(null);
    }

    public void push(int data) {
        if (headNode == null) {
            headNode = new LLNode(data);
        } else if (headNode.getData() == null) {
            headNode.setData(data);
        } else {
            LLNode tmpNode = new LLNode(data);
            tmpNode.setNext(headNode);
            headNode = tmpNode;
        }
    }

    public Integer top() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cant pop any element");
            return null;
        } else {
            return headNode.getData();
        }
    }

    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cant pop any element");
            return null;
        } else {
            int data = headNode.getData();
            headNode = headNode.getNext();
            return data;
        }
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    public void deleteStack() {
        headNode = null;
    }
}

class LLNode {
    private Integer data;
    private LLNode next;

    public LLNode(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LLNode getNext() {
        return next;
    }

    public void setNext(LLNode next) {
        this.next = next;
    }
}
