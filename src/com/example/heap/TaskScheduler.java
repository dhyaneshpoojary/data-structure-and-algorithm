package com.example.heap;

import java.util.*;

/**
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 *
 *
 * Example:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 *
 * Note:
 *
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 *
 */
public class TaskScheduler {

    public  static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char task: tasks){
            map.put(task, map.getOrDefault(task, 0)+1);
        }

        Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int value: map.values()){
            priorityQueue.add(value);
        }
        int result=0;
        while(!priorityQueue.isEmpty()){
            int index=0;
            List<Integer> list = new ArrayList<>();
            while(index<=n) {
                int count = 0;
                if(!priorityQueue.isEmpty()){
                    count = priorityQueue.remove();
                }
                if(count>1) {
                    list.add(count - 1);
                }
                result++;
                if (priorityQueue.isEmpty() && list.size() == 0) break;
                index++;
            }
            for(int value : list){
                priorityQueue.add(value);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        char [] tasks = {'A','B','C','A','B','A','B'};
        System.out.println(leastInterval(tasks, 3));

    }
}
