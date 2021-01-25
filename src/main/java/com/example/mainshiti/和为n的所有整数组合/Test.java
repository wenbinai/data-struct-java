package com.example.mainshiti.和为n的所有整数组合;

/**
 * 给定一个正整数n，求解出所有和为n 的整数组合，
 * 要求组合按照递增方式展示，而且唯一。
 * 例如，4=1+1+1+1、1+1+2、1+3、2+2、4（即4+0）。
 */

//思路

/**
 * 以数值4为例，
 * 和为4的所有的整数组合一定都小于4（1,2,3,4）。
 * 首先选择数字1，
 * 然后用递归的方法求和为3（即4-1）的组合，
 * 一直递归下去直到用递归求和为0的组合时，
 * 所选的数字序列就是一个和为4的数字组合。
 * 然后第二次选择2，接着用递归求和为2（即4-2）的组合；
 * 同理下一次选3，然后用递归求和为1（即4-3）的所有组合。
 * 依此类推，直到找出所有的组合为止
 */
public class Test {
    public static void getAllCombination(int sum, int[] result, int count) {
        if (sum < 0) return;
        int i;
        if (sum == 0) {
            for (int i1 = 0; i1 < count; i1++) {
                System.out.println(result[i1] + " ");
            }
            System.out.println();
            return;
        }



    }
}
