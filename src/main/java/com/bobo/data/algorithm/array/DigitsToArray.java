package com.bobo.data.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 如何将数字按位转换为数组?
 *
 * 例如:
 *
 * 123 -> [1, 2, 3]
 *
 * 解题思路:
 *
 * 1. 循环将数字进行取余运算，每次得到当前最低位的数字，然后将数字进行除等运算，使位数缩减一，将所得数字存入动态数组中，再将数组反转即可
 *
 * 2.
 */
public class DigitsToArray {

    private static Integer[] solution(int digits) {
        List<Integer> results = new ArrayList<>();
        while (digits > 0) {
            int result = digits % 10;
            digits /= 10;
            results.add(result);
        }
        // reverse
        Collections.reverse(results);
        Integer[] res = new Integer[results.size()];
        return results.toArray(res);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(123456)));
    }

}
