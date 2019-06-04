package com.example.array;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        LinkedList<int[]> mergedIntervals = new LinkedList<>();
        for(int[] interval: intervals){
            if(mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] <  interval[0]){
                mergedIntervals.add(interval);
            }else{
                mergedIntervals.getLast()[1] = Math.max(interval[1], mergedIntervals.getLast()[1]);
            }
        }

        int[][] result = new int[mergedIntervals.size()][2];
        for(int index=0; index<mergedIntervals.size(); index++){
            result[index]=mergedIntervals.get(index);

        }

        return result;
    }

    public static void main(String[] args) {
        int[][] nums =  {{1,4},{0,4}};
        int[][] result = merge(nums);
        for(int index=0; index<result.length; index++) {
            System.out.print("("+result[index][0]+","+result[index][1]+")");
            System.out.println();
        }
    }
}
