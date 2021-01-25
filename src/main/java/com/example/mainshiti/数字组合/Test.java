package com.example.mainshiti.数字组合;

import java.util.HashSet;

/**
 * 用1、2、2、3、4、5这6个数字，写一个main函数，
 * 打印出所有不同的排列。例如， 512234、412345
 * 等，要求：“4”不能在第三位，“3”与“5”不能相连
 */
public class Test {
    private int[] numbers;
    private int n = 6;

    public Test(int[] arr) {
        numbers = arr;
        visited = new boolean[numbers.length];
        graph = new int[numbers.length][numbers.length];
    }

    private boolean[] visited;

    private int[][] graph;

    private StringBuffer combination = new StringBuffer();

    private HashSet<String> s = new HashSet<>();

    public void getAllCombination() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = 1;
                }
            }
        }

        graph[3][5] = 0;
        graph[5][3] = 0;

        for (int i = 0; i < n; i++) {
            depthSearch(i);
        }
    }

    private void depthSearch(int start) {
        visited[start] = true;
        combination.append(numbers[start]);
        // 递归的结束条件
        if (combination.length() == n) {
            if (combination.indexOf("4") != 2) {
                s.add(combination.toString());
            }
        }

        for (int i = 0; i < n; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                depthSearch(i);
            }
        }

        combination.delete(combination.length() - 1, combination.length());
        visited[start] = false;
    }

    public void printAllCombinations() {
        for (String s1 : s) {
            System.out.println(s1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 5};
        Test t = new Test(arr);

        t.getAllCombination();
        t.printAllCombinations();
    }

}
