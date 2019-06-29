package com.example.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * Example 1:
 *
 * Input: "code"
 * Output: false
 * Example 2:
 *
 * Input: "aab"
 * Output: true
 * Example 3:
 *
 * Input: "carerac"
 * Output: true
 */
public class PalindromePermutation {

    public static boolean isPalindrome(String s) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int index=0; index<s.length(); index++){
            Character ch = s.charAt(index);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            count+=entry.getValue()%2;
        }

        return count<=1;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("aab"));
    }
}
