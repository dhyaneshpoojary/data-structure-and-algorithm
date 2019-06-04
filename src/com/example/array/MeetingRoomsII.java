package com.example.array;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 *
 */
public class MeetingRoomsII {

    public static int find(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int index=0; index<intervals.length; index++){
            start[index]=intervals[index][0];
            end[index]=intervals[index][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int x=0, y=0, count=0, maxCount=0;
        while(x<start.length && y<end.length){
            if(start[x]<end[y]){
                count++;
                x++;
            }else{
                count--;
                y++;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0,30},{15,20},{25,30}};
        System.out.println(find(intervals));
    }
}
