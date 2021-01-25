package com.example.mainshiti;

public class Solution {

    /**
     * @param arr
     * @return
     */
    public static int maxSonArraySum0(int[] arr) {
        // 处理边界
        if (arr == null || arr.length == 0)
            return 0;
        int n = arr.length;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 临时最大值
                int tmpMax = 0;
                for (int k = i; k <= j; k++) {
                    tmpMax += arr[k];
                }
                if (tmpMax > sum)
                    sum = tmpMax;
            }
        }

        return sum;
    }

    /**
     * 贪心
     * 前面的和 < 0
     * 则从当前值开始计算
     * 否则相加
     *
     * @param arr
     * @return
     */
    public static int maxSonArraySum(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int res = Integer.MIN_VALUE, sum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (sum <= 0)
                sum = arr[i];
            else
                sum += arr[i];

            res = Math.max(res, sum);
        }

        return res;
    }

    /**
     * 动态规划做法
     *
     * @param arr
     * @return
     */
    public static int maxSonArraySum1(int[] arr) {
        int n = arr.length;
        int[] f = new int[n];
        f[0] = arr[0];
        int res = f[0];

        for (int i = 1; i < n; i++) {
            if (f[i - 1] <= 0)
                f[i] = arr[i];
            else
                f[i] = f[i - 1] + arr[i];

            res = Math.max(res, f[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int res = maxSonArraySum(new int[]{1, -2, 3, 10, -4, 7, 2, -5});
        System.out.println(res);
        res = maxSonArraySum1(new int[]{1, -2, 3, 10, -4, 7, 2, -5});
        System.out.println(res);
        res = maxSonArraySum0(new int[]{1, -2, 3, 10, -4, 7, 2, -5});
        System.out.println(res);
    }
}
