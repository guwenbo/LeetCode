package com.bobo.data.algorithm.array;

/**
 * 题目:  https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/770/
 *
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 *
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 * 解题思路:
 *
 * 先遍历整个数组，求出数组元素的总和
 *
 * 再次遍历数组，计算当前索引左侧元素的总和，如果满足: 左侧元素之和 * 2 = 元素总和 ，则该索引即为 "中心索引"。
 */
public class PivotIndex {

    private static int solution(int[] nums) {
        int len = nums.length;
        // 如果数组长度小于3，则可以直接返回 -1，效率高
        if (len < 3) return -1;
        // 求和
        int sum = 0, leftSum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        // 查找中心索引
        for (int i = 0; i < len; i++) {
            int value = nums[i];
            if (leftSum * 2 == (sum - value)) return i;
            leftSum += value;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        // int[] nums = {-1, -1, -1, -1, -1, 0};
        // int[] nums = {-1, -1, -1, -1, -1, -1};
        System.out.println(solution(nums));
    }

}
