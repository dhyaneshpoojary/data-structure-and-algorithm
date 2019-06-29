package com.example.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationII {

    public static  List<List<Integer>> find(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> intermediateResult = new ArrayList<>();
        find(candidates, target, intermediateResult, result, 0);
        return result;
    }


    public static void find(int[] candidates, int remain, List<Integer> intermediateResult , List<List<Integer>> result, int start){

        if(remain<0)
            return;

        if(remain==0){
            result.add(new ArrayList<>(intermediateResult));
            return;
        }

        for(int index=start; index<candidates.length; index++){
            if(index > start && candidates[index] == candidates[index-1]) continue;
            intermediateResult.add(candidates[index]);
            find(candidates, remain-candidates[index], intermediateResult, result, index+1);
            intermediateResult.remove(intermediateResult.size()-1);
        }

    }

    public static void main(String[] args) {
        int[] candidates = {1,2,1,1,2};
        System.out.println(find(candidates, 5));
    }
}
