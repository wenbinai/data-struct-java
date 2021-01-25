package com.example.concurrent.atomic;

import sun.misc.Unsafe;

import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class MyAtomicInteger extends Number {
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset
                    (MyAtomicInteger.class.getDeclaredField("value"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private volatile int value;

    public final int get() {
        return value;
    }

    /**
     * 方法前加 final 表示不允许子类继承修改
     *
     * @param newValue
     */
    public final void set(int newValue) {
        value = newValue;
    }

    public final void lazySet(int newValue) {
        unsafe.putOrderedInt(this, valueOffset, newValue);
    }

    /**
     * 原子性的设置给定的值 newValue, 返回旧值
     *
     * @param newValue
     * @return
     */
    public final int getAndSet(int newValue) {
        return unsafe.getAndSetInt(this, valueOffset, newValue);
    }

    /**
     * CAS 操作: 原子性的将value设置给定的值update, 如果当前值等于expect值
     * 设置成功, 返回true ,设置失败, 返回false
     *
     * @param expect
     * @param update
     * @return
     */
    public final boolean compareAndSet(int expect, int update) {
        return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    /**
     * 可能会失败, 所以很少使用, 大部分情况使用compareAndSet
     *
     * @param expect
     * @param update
     * @return
     */
    public final boolean weakCompareAndSet(int expect, int update) {
        return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    /**
     * 原子性  +1
     *
     * @return
     */
    public final int getAndIncrement() {
        return unsafe.getAndAddInt(this, valueOffset, 1);
    }

    /**
     * 原子性 -1
     *
     * @return
     */
    public final int getAndDecrement() {
        return unsafe.getAndAddInt(this, valueOffset, -1);
    }

    /**
     * 原子性 + delta
     * 返回之前的值
     *
     * @param delta
     * @return
     */
    public final int getAndAdd(int delta) {
        return unsafe.getAndSetInt(this, valueOffset, delta);
    }

    public final int incrementAndGet() {
        return unsafe.getAndSetInt(this, valueOffset, 1) + 1;
    }

    public final int decrementAndGet() {
        return unsafe.getAndSetInt(this, valueOffset, -1) - 1;
    }

    public final int addAndGet(int delta) {
        return unsafe.getAndSetInt(this, valueOffset, delta) + delta;
    }

    /**
     * 返回旧值
     *
     * @param updateFunction
     * @return
     */
    public final int getAndUpdate(IntUnaryOperator updateFunction) {
        int prev, next;
        do {
            prev = get();
            next = updateFunction.applyAsInt(prev);
        } while (!compareAndSet(prev, next));

        return prev;
    }

    /**
     * 返回新值
     * 通过CAS 进行更新
     *
     * @param updateFunction
     * @return
     */
    public final int updateAndGet(IntUnaryOperator updateFunction) {
        int prev, next;
        do {
            prev = get();
            next = updateFunction.applyAsInt(prev);
        } while (!compareAndSet(prev, next));

        return next;
    }

    public final int getAndAccumulate(int x,
                                      IntBinaryOperator accumulatorFunction) {
        int prev, next;

        do {
            prev = get();
            next = accumulatorFunction.applyAsInt(prev, x);
        } while (!compareAndSet(prev, next));

        return prev;
    }

    public final int accumulateAndGet(int x,
                                      IntBinaryOperator accumulatorFunction) {
        int prev, next;
        do {
            prev = get();
            next = accumulatorFunction.applyAsInt(prev, x);
        } while (!compareAndSet(prev, next));
        return next;
    }


    public MyAtomicInteger(int initialValue) {
        value = initialValue;
    }

    @Override
    public int intValue() {
        return get();
    }

    @Override
    public long longValue() {
        return (long) get();
    }

    @Override
    public float floatValue() {
        return (float) get();
    }

    @Override
    public double doubleValue() {
        return (double) get();
    }
}
