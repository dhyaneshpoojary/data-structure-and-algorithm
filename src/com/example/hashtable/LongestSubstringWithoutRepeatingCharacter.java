package com.example.hashtable;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacter {

    public static int find(String s) {
        HashMap<Character, Integer> characterLatestIndexMap = new HashMap<>();
        int startIndex=0, endIndex=0, maxLen=0;
        while(endIndex<s.length()){
            Character character = s.charAt(endIndex);
            if(characterLatestIndexMap.containsKey(character) &&
                    characterLatestIndexMap.get(character) >= startIndex){
                startIndex = characterLatestIndexMap.get(character)+1;
            }
            maxLen = Math.max(endIndex-startIndex+1, maxLen);
            characterLatestIndexMap.put(character, endIndex++);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(find("tmmzuxt"));
    }
}
