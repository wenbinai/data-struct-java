package com.example.thread.thread_learn;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteLockDemo {
    public static void main(String[] args) {

    }

}

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "写入" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入完成");
    }

    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "读取" + key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取成功");
    }

}
