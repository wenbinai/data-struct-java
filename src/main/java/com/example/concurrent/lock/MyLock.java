package com.example.concurrent.lock;

import java.util.concurrent.locks.Condition;

public interface MyLock {
    void lock();

    boolean tryLock();

    void unlock();

    Condition newCondition();
}
