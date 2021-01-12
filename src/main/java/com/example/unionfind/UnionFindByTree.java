package com.example.unionfind;

/**
 * 通过树实现并查集
 * <p>
 * (通过数组模拟树(子节点指向父节点))
 * <p>
 * 时间复杂度和空间复杂度都为O(h)
 * 其中h为树的高度
 */
public class UnionFindByTree implements UnionFind {

    private int[] parent;

    public UnionFindByTree(int size) {
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int size() {
        return parent.length;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        while (p != parent[p]) p = parent[p];
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        parent[pRoot] = qRoot;
    }
}
