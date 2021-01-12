package com.example.unionfind;

/**
 * 基于路径压缩进一步优化并查集
 * <p>
 * 注意: 优化思路 在查找过程中直接将其指向的父节点更换为根节点
 */
public class UnionFindByTreeRefactor4 implements UnionFind {
    private int[] parent;
    // 记录以parent[i]为根节点的树的高度
    private int[] rank;

    public UnionFindByTreeRefactor4(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int size() {
        return parent.length;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 在查找的过程种进行路径压缩, 进一步减少树的高度
     * parent[p] = parent[parent[p]]
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");

        /**
         * 利用递归直接找到根节点
         */
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }

        return parent[p];
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        /**
         * 根据两个元素
         */
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }
}
