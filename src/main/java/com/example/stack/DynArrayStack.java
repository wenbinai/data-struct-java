package com.example.stack;

/**
 * 利用动态数组模拟栈
 * <p>
 * 主要思想: 每次push()时, 判断是否会溢出,
 * 如果会溢出, 则动态增长数组一倍(新建一个数组,
 * 将原数组元素复制拷贝到新数组中)
 * <p>
 * push() 的平均复杂度为O(1)
 * 缺点: 倍增太多次可能导致内存溢出
 */
public class DynArrayStack {
    private int top;
    private int capacity;
    private int[] array;

    public DynArrayStack(int capacity) {
        this.capacity = capacity;
        top = -1;
        array = new int[capacity];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, can not pop any element");
            return -1;
        } else {
            return array[top--];
        }
    }

    public int size() {
        return top + 1;
    }

    public void push(int data) {
        // stack will full
        if (top == capacity) {
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, capacity);
            capacity = capacity * 2;
            array = newArray;
        } else {
            array[++top] = data;
        }
    }

    public void deleteStack() {
        top = -1;
    }
}
