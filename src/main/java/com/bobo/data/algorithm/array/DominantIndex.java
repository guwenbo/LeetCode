package com.bobo.data.algorithm.array;

/**
 * 题目:  https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/771/
 *
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 *
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 *
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 * 解题思路:
 *
 * 核心: 找出最大的元素，以及第二大的元素，若满足条件: 最大元素 / 第二大元素 >= 2，则返回最大元素的索引
 *
 * 首先遍历数组，依次找出 1.最大的元素，2.最大元素的索引，3.以及第二大元素
 *
 * 如果第二大元素为0，比较最大的元素，如果最大的元素也是0，则返回-1，否则返回最大元素的索引
 *
 * 如果最大元素 / 第二大元素 >= 2，则返回最大元素的索引，否则返回-1
 */
public class DominantIndex {

    private static int solution(int[] nums) {
        int len = nums.length;
        if (len < 1) return -1;
        int max_1_index = 0, max_1_val = 0, max_2_val = 0;
        for (int i = 0; i < len; i++) {
            int curVal = nums[i];
            if (curVal > max_1_val) {
                max_2_val = max_1_val;
                max_1_val = curVal;
                max_1_index = i;
            } else if (curVal > max_2_val) {
                max_2_val = curVal;
            }
        }
        if (max_2_val == 0) {
            return max_1_val > 0 ? max_1_index : -1;
        }
        return max_1_val / max_2_val >= 2 ? max_1_index : -1;
    }

    public static void main(String[] args) {
//        int[] nums = {3, 6, 1, 0};
//        int[] nums = {1, 2, 3, 4};
        int[] nums = {0, 0, 0, 1};
//        int[] nums = {1};
        System.out.println(solution(nums));
    }

}
