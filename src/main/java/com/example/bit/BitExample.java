package com.example.bit;

import com.sun.javaws.jnl.ResourceVisitor;

/**
 * 位运算的相关技巧
 * 相关学习文章: https://juejin.cn/post/6844904098123218957
 */
public class BitExample {

    /**
     * 计算二进制中1的个数
     *
     * @param a
     * @return
     */
    public static int count0(int a) {
        int count = 0;
        while (a != 0) {
            if ((a & 1) == 1) {
                count++;
            }
            // Java中无符号右移时需要加>>>
            // 如果使用 >>, 则会添加1而不是0
            a >>>= 1;
        }

        return count;
    }

    public static int count1(int a) {
        int count = 0;
        while (a != 0) {
            a &= (a - 1);
            count++;
        }

        return count;
    }

    /**
     * Java 官方二进制统计
     * 0x表示16进制
     *
     * @param i
     * @return
     */
    public static int bitCount(int i) {
        // HD, Figure 5-2
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }

    /**
     * Java 源码中二进制反转的操作
     *
     * @param i
     * @return
     */
    public static int reverse(int i) {
        // HD, Figure 7-1
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
        i = (i << 24) | ((i & 0xff00) << 8) |
                ((i >>> 8) & 0xff00) | (i >>> 24);
        return i;
    }

    public static void main(String[] args) {
        int res = bitCount(3);
        System.out.println(res);
        res = count0(3);
        System.out.println(res);
        res = count1(3);
        System.out.println(res);
        res = reverse(3);
        System.out.println(res);

        
    }


}
