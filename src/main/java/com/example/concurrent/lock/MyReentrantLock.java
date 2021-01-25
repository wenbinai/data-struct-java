//package com.example.concurrent.lock;
//
//import com.sun.corba.se.impl.orbutil.concurrent.Sync;
//
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.AbstractQueuedSynchronizer;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//
//public class MyReentrantLock implements Lock {
//
//    private final Sync sync;
//
//    abstract static class Sync extends AbstractQueuedSynchronizer {
//        abstract void lock();
//
//        final boolean nonfairTryAcquire(int acquires) {
//            return false;
//        }
//
//
//    }
//
//    @Override
//    public void lock() {
//
//    }
//
//    @Override
//    public void lockInterruptibly() throws InterruptedException {
//
//    }
//
//    @Override
//    public boolean tryLock() {
//        return false;
//    }
//
//    @Override
//    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
//        return false;
//    }
//
//    @Override
//    public void unlock() {
//
//    }
//
//    @Override
//    public Condition newCondition() {
//        return null;
//    }
//}
