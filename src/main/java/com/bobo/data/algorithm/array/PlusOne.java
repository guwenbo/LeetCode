package com.bobo.data.algorithm.array;

import java.util.Arrays;

/**
 * 题目:  https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/772/
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 解题思路:
 *
 * 倒序遍历数组，若元素小于9，则对相应元素进行加一操作，并返回修改后的数组
 *
 * 若不小于9，则说明当前元素是9，需要进位，将当前元素设为0，并进行下一次迭代
 *
 * 若迭代结束仍未返回，则说明该整数进行加一操作后位数增加一位，则需要生成一个新的数组，长度为原数组长度+1
 *
 * 生成新的数组后，将数组首元素置为1，然后返回新的数组
 */
public class PlusOne {

    private static int[] solution(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        int[] results = new int[len + 1];
        results[0] = 1;
        return results;
    }

    public static void main(String[] args) {
        int[] digits = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(Arrays.toString(solution(digits)));
    }

}
