package com.example;


import java.util.*;


public class Solution {
    /**
     * 将输入的十进制数字转换为对应的二进制字符串和十六进制字符串
     *
     * @param number string字符串 十进制数字字符串
     * @return string字符串
     */

    public static String changeFormatNumber(String number) {
        // write code here
        // 1. 将string转化为数字类型
        // 2. 如果超过最大值或最下值 返回NODATA
        // 3. 如果为非数字字符, 返回INPUTERROR
        // 4. 将数字类型转换为二进制和十六进制
        // 5. 如何表示一个负数
        char[] a = number.toCharArray();
        int len = number.length();
        // 是否为负数
        boolean flag = false;
        // 字符串代表的数字
        int num = 0;
        // 代表乘数
        int k = 1;

        if (a[0] == '-') {
            flag = true;
            for (int i = len - 1; i > 0; i--) {
                num = num + (a[i] - '0') * k;
                k = k * 10;
            }
        } else {
            for (int i = len - 1; i >= 0; i--) {
                num = num + (a[i] - '0') * k;
                k = k * 10;
            }
        }

        if (num > Integer.MAX_VALUE) {
            return "NODATA";
        }
        if (flag && -num < Integer.MIN_VALUE) {
            return "NODATA";
        }

        // 将num转换为16进制
        char[] res1 = new char[16];
        char[] res2 = new char[4];
        for (int i = 0; i < res1.length; i++) {
            res1[i] = '0';
        }
        for (int i = 0; i < res2.length; i++) {
            res2[i] = '0';
        }
        int i = 15;
        int tmpNum = num;
        while (tmpNum > 0) {
            res1[i--] = (char) (tmpNum % 2 + '0');
            tmpNum /= 2;
        }

        tmpNum = num;
        i = 3;
        while (tmpNum > 0) {
            if (tmpNum % 16 >= 10) {
                res2[i--] = (char) (tmpNum % 16 - 10 + 'A');
            } else {
                res2[i--] = (char) (tmpNum % 16 + '0');
            }
            tmpNum /= 16;
        }

        StringBuilder sb = new StringBuilder();
        for (int i1 = 0; i1 < res1.length; i1++) {
            sb.append(res1[i1]);
        }
        sb.append(",");
        for (int i1 = 0; i1 < res2.length; i1++) {
            sb.append(res2[i1]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = changeFormatNumber("-1");
        System.out.println(res);
    }


}
