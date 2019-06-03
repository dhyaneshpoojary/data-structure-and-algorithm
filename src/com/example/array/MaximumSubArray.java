package com.example.array;

/**
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 */
public class MaximumSubArray {

    public static int find(int[] nums) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for(int index=0; index<nums.length; index++){
            sum = Math.max(nums[index], sum+nums[index]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int nums[] = {-2,1};
        System.out.println(find(nums));
    }
}
