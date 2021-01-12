package com.example.array;

public class TestArray {
    public static void main(String[] args) {
        Array arr = new Array(20);

        for (int i = 0; i < 10; i++)
            arr.addLast(i);

        arr.addFirst(-1);
        System.out.println(arr);
    }
}
