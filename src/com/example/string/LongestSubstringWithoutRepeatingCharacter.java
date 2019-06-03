package com.example.string;

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
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
public class LongestSubstringWithoutRepeatingCharacter {

    public static int find(String str) {
        HashMap<Character, Integer> characterVsIndexMap = new HashMap<>();
        int startIndex = 0, maxLen = 0;
        for(int index=0; index<str.length(); index++){
            Character ch = str.charAt(index);
            if(characterVsIndexMap.containsKey(ch) && characterVsIndexMap.get(ch) >= startIndex){
                startIndex = characterVsIndexMap.get(ch)+1;
            }
            maxLen = Math.max(maxLen, index - startIndex+ 1);
            characterVsIndexMap.put(ch, index);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(find("abccbdefgh"));
    }
}
