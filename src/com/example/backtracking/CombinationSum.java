package com.example.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {

    public static  List<List<Integer>> find(int[] candidates, int target) {
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
            intermediateResult.add(candidates[index]);
            find(candidates, remain-candidates[index], intermediateResult, result, index);
            intermediateResult.remove(intermediateResult.size()-1);
        }

    }

    public static void main(String[] args) {
        int[] candidates = {1,2,1,1,2};
        System.out.println(find(candidates, 5));
    }
}
