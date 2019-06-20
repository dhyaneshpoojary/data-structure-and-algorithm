package com.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 *
 *
 * Note:
 *
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 *
 */
public class IntervalListIntersections {

    public static int[][] find(int[][] A, int[][] B) {
        int aIndex=0, bIndex=0;
        List<int[]> result = new ArrayList<>();

        while(aIndex<A.length && bIndex<B.length){
            int[] firstInterval = A[aIndex];
            int[] secondInterval = B[bIndex];

            int low = firstInterval[0] > secondInterval[0] ? firstInterval[0]: secondInterval[0];
            int high = firstInterval[1] < secondInterval[1] ? firstInterval[1]: secondInterval[1];

            if(low<=high){
                result.add(new int[]{low,high});
            }
            if(firstInterval[1]<secondInterval[1]){
                aIndex++;
            }else{
                bIndex++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] a = {{0,2},{5,10},{13,23},{24,25}};
        int[][] b = {{1,5},{8,12},{15,24},{25,26}};
        System.out.println(Arrays.deepToString(find(a, b)));
    }


}
