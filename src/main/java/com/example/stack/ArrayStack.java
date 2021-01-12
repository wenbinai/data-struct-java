package com.example.stack;

/**
 * 利用简单数组模拟栈
 * <p>
 * 大部分操作的时间复杂度为O(1)
 * 但最大的局限性为必须预先声明数组最大空间, 且不能改变
 */
public class ArrayStack {
    // 栈顶指针
    private int top;
    // 存储数组
    private int[] array;
    // 数组最大容量
    private int capacity;

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public void push(int data) {
        if (top == capacity) {
            System.out.println("Stack Overflow");
        } else {
            array[++top] = data;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty, can not pop any element");
            return -1;
        } else {
            return array[top--];
        }
    }

    /**
     * 删除整个栈
     */
    public void deleteStack() {
        top = -1;
    }
}
