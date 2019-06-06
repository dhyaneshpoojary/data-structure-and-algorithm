package com.example.array;

/**
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 */
public class NextPermutation {

    public static void permute(int[] nums){
        int i = nums.length-2;
        while(i>=0 && nums[i+1] <= nums[i]){
            i--;
        }

        if(i>=0){
            int j = i;
            while(j<nums.length-1 && nums[j]<=nums[i]){
                j++;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1, nums.length-1);
    }

        public static void swap(int[]nums, int pos1, int pos2){
            int temp = nums[pos1];
            nums[pos1]=nums[pos2];
            nums[pos2]=temp;
        }

        public static void reverse(int[] nums, int start, int end){
            while(start<end){
                int temp = nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
                start++;
                end--;
            }
        }

    public static void main(String[] args) {
        int[] nums = {2,3,1};
        permute(nums);
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
