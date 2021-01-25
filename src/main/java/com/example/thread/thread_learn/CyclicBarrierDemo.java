package com.example.thread.thread_learn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("集齐龙珠, 召唤神龙!");
        });
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "获得龙珠: " + finalI);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();

        }
    }
}
