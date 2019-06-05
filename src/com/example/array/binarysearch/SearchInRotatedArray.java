package com.example.array.binarysearch;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 */
public class SearchInRotatedArray {


    public static int search(int[] nums, int target) {

        if(nums.length==0)
            return -1;
        if(nums.length==1)
            return nums[0]==target?0:-1;

        int rotatedIndex = findRotatedIndex(nums);

        if(nums[rotatedIndex]==target){
            return rotatedIndex;
        }else if(rotatedIndex == 0){
            return searchTargetIndex(nums, 0, nums.length-1, target);
        }else if(nums[0] <= target){
            return searchTargetIndex(nums,0,rotatedIndex, target);
        }else{
            return searchTargetIndex(nums,rotatedIndex,nums.length-1, target);
        }
    }

    public static int searchTargetIndex(int nums[], int low, int high, int target){
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }


    public static int findRotatedIndex(int[] nums){
        int low=0, high=nums.length-1;
        if(nums[low]<nums[high]){
            return 0;
        }
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>nums[mid+1]){
                return mid+1;
            }else if(nums[mid]>=nums[0]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int nums[] = {8,9,2,3,4};
        int target = 9;
        System.out.println(search(nums, target));
    }
}
