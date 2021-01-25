package com.example.string;

import java.util.Arrays;

public class StringFormat {
    /**
     * 最大数
     *
     * @param nums int整型一维数组
     * @return string字符串
     */
    public static String solve(int[] nums) {
        // write code here
        // 1. 按照首字母排序, 首字母相同按照后面数字进行排序
        // 2. 排完序后, 进行拼接
        int len = nums.length;
        String[] strs = new String[len];

        for (int i = 0; i < len; i++) {
//            strs[i] = String.format("%d", nums[i]);
            strs[i] = String.valueOf(nums[i]);
            System.out.println(strs[i]);
        }
        // Java 数组自定义排序
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder res = new StringBuilder();

        for (String str : strs) {
            res.append(str);
        }

        if (res.charAt(0) == '0') return "0";

        return res.toString();
    }

    public static void main(String[] args) {
        String res = solve(new int[]{10, 1});
        System.out.println(res);
    }
}
