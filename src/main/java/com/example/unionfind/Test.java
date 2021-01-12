package com.example.unionfind;

import java.util.Random;

public class Test {

    /**
     * 测试两种函数耗时大小
     *
     * @param uf
     * @param m
     * @return
     */
    private static double testUnionFind(UnionFind uf, int m) {
        int size = uf.size();
        Random random = new Random();

        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);

            uf.union(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);

            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
//        double t1 = testUnionFind(new UnionFindByArray(100000), 100000);
//        System.out.println(t1);
//        double t2 = testUnionFind(new UnionFindByTree(100000), 100000);
//        System.out.println(t2);
//        double t3 = testUnionFind(new UnionFindByTreeRefactor1(100000000), 100000000);
//        System.out.println(t3);
//        double t4 = testUnionFind(new UnionFindByTreeRefactor2(100000000), 100000000);
//        System.out.println(t4);
        double t5 = testUnionFind(new UnionFindByTreeRefactor3(100000000), 100000000);
        System.out.println(t5);
        double t6 = testUnionFind(new UnionFindByTreeRefactor4(100000000), 100000000);
        System.out.println(t6);
    }
}
