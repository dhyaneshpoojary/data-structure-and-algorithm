package com.example.array;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */
public class MergeTwoSortedArrayIntoOneArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1=m-1, index2=n-1;
        int index3=m+n-1;

        while(index1>=0 && index2>=0){
            if(nums1[index1]>nums2[index2]){
                nums1[index3] = nums1[index1];
                index3--;
                index1--;
            }else{
                nums1[index3] = nums2[index2];
                index3--;
                index2--;
            }
        }

        while(index2>=0){
            nums1[index3] = nums2[index2];
            index3--;
            index2--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 ={1,2,3,0,0,0};
        int[] nums2 = {2,4,5};
        merge(nums1,3, nums2, 3);
        for(int i=0; i<nums1.length; i++){
            System.out.println(nums1[i]);
        }
    }
}
