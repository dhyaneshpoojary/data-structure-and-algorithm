package com.example.array;

import java.util.Arrays;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 *
 *
 * Example 1:
 *
 * Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 *
 *
 * Note:
 *
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 *
 */
public class ReorderLogFiles {

    public static String[] execute(String[] logs) {

        Arrays.sort(logs, (log1, log2)->{

            String[] log1Array = log1.split(" ",2);
            String[] log2Array = log2.split(" ",2);

            boolean isDigit1 = Character.isDigit(log1Array[1].charAt(0));
            boolean isDigit2 = Character.isDigit(log2Array[1].charAt(0));

            if(!isDigit1 && !isDigit2){
                int comparisonResult = log1Array[1].compareTo(log2Array[1]);
                if(comparisonResult != 0) return comparisonResult;
                return log1Array[0].compareTo(log2Array[0]);
            }

            return isDigit1?(isDigit2?0:1):-1;
        });

        return logs;
    }

    public static void main(String[] args) {
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        for(String log:execute(logs)){
            System.out.println(log);
        }
        System.out.println(Integer.MIN_VALUE);
    }

}
