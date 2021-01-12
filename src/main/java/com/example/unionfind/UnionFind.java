package com.example.unionfind;

/**
 * 定义并查集通用接口
 */
public interface UnionFind {

    int size();

    boolean isConnected(int p, int q);

    void union(int p, int q);
}
