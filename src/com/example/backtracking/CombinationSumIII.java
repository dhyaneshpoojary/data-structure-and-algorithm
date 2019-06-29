package com.example.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    public static  List<List<Integer>> find(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> intermediateResult = new ArrayList<>();
        find(k, n, intermediateResult, result, 1);
        return result;
    }


    public static void find(int k, int remain, List<Integer> intermediateResult , List<List<Integer>> result, int start){

        if(intermediateResult.size()>k)
            return;

        if(intermediateResult.size() == k && remain==0){
            result.add(new ArrayList<>(intermediateResult));
            return;
        }

        for(int index=start; index<10; index++){
            intermediateResult.add(index);
            find(k, remain-index, intermediateResult, result, index+1);
            intermediateResult.remove(intermediateResult.size()-1);
        }

    }

    public static void main(String[] args) {
        System.out.println(find(3, 9));
    }
}
