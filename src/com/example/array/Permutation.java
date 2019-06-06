package com.example.array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class Permutation {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }

    public static void permute(int[] nums, int left, List<List<Integer>> result){
        if(left == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }

        for(int i=left; i<nums.length; i++){
            swap(nums, left, i);
            permute(nums, left+1, result);
            swap(nums, i, left);
        }
    }

    public static void swap(int[] nums, int pos1, int pos2){
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = permute(nums);
        result.forEach(list->{
            list.forEach(System.out::print);
            System.out.println();
        });
    }
}
