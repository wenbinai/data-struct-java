package com.example.thread.thread_learn;

import java.lang.reflect.Field;

public class ThreadLocalDemo {
    public static void main(String[] args) throws Exception {
        test_threadLocalHashCode();
    }

    public static void test_threadLocalHashCode() throws Exception {
        for (int i = 0; i < 5; i++) {
            ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
            Field threadLocalHashCode = objectThreadLocal.getClass().getDeclaredField("threadLocalHashCode");
            threadLocalHashCode.setAccessible(true);
            System.out.println("objectThreadLocal: " + threadLocalHashCode.get(objectThreadLocal));
        }
    }
}
