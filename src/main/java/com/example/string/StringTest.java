package com.example.string;

/**
 * 全面探索了解Java String类的所有用法
 */
public class StringTest {
    public static void main(String[] args) {
        testString();
    }

    public static void testString() {
        String str = "string";
        System.out.println(str);
        str =  str.substring(0, 1);
        System.out.println(str);
        String s = str.valueOf(1);
        new StringBuilder(str).reverse();
        System.out.println(s);
        StringBuilder sb = new StringBuilder(str);
        System.out.println("before reverse ==>" + sb);
        sb.reverse();
        System.out.println("after reverse ==>" + sb);
    }
}
