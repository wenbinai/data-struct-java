package com.example.unionfind;

/**
 * 通过数组初始化并查集
 */
public class UnionFindByArray implements UnionFind {
    /**
     * 注意: 数组存储的元素为对应所在的集合编号
     */
    private int[] id;

    public UnionFindByArray(int size) {
        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public int size() {
        return id.length;
    }

    /**
     * 查询的操作耗时: O(1)的时间复杂度
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并的复杂度: O(n)
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) id[i] = qId;
        }
    }

    // 查找元素p所对应的集合编号
    private int find(int p) {
        // 1. 判断p的合法性
        if (p < 0 && p >= id.length)
            throw new IllegalArgumentException("p is out of bound.");
        return id[p];
    }
}
