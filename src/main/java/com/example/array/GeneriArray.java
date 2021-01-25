package com.example.array;


import org.omg.CORBA.Object;

/**
 * TODO 将IntArray 改为泛型 GenericArray
 * 引用比较 和 值比较的区别
 * @param <E>
 */
public class GeneriArray<E> {
    private E[] data;
    private int size;

    public GeneriArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public GeneriArray() {
        this(10);
    }

    //todo 传入的是一个数组

    // 获取数组元素个数
    public int getSize() {
        return size;
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    // 数组添加元素(从尾部添加)
    public void addLast(E e) {
//        if (size == data.length)
//            throw new IllegalArgumentException("AddLast failed. Array is full");
//
//        data[size++] = e;

        add(size, e);
    }

    // 向数组指定位置添加元素
    public void add(int index, E e) {
        if (size == data.length)
            throw new IllegalArgumentException("AddLast failed. Array is full");


        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. index is out of bound");

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is out of bound");
        return data[index];
    }

    void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is out of bound");
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return true;
        }

        return false;
    }

    // 获取元素e的索引
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return i;
        }
        return -1;
    }

    // 从数组中删除指定位置的元素
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Index is out of bound");

        E res = data[index];

        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;
        return res;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * TODO 如何删除找到所有重复元素
     *
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);

    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }

        res.append(']');
        return res.toString();
    }
}
