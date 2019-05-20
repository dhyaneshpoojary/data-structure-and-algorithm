package com.example.hashtable;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 *
 * return [0, 1]
 *
 */
public class TwoSum {

    public static int[] find(int arr[], int desiredSum){
        HashMap<Integer, Integer> history = new HashMap<>();
        int result[] = new int[2];
        for(int index=0; index<arr.length; index++){
            int currentElement = arr[index];
            if(history.containsKey(desiredSum - currentElement)){
                result[0] = history.get(desiredSum - currentElement);
                result[1] = index;
            }
            history.put(currentElement, index);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] =  {2, 7, 11, 15};
        int desiredSum = 9;
        int[] result = TwoSum.find(arr, desiredSum);
        System.out.println("Index of the two sums if found are : ");
        for(int index=0; index< result.length; index++){
            System.out.print(result[index]);
            System.out.print(" ");
        }
    }
}
