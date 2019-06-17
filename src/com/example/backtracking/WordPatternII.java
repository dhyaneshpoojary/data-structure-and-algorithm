package com.example.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 *
 * Example 1:
 *
 * Input: pattern = "abab", str = "redblueredblue"
 * Output: true
 * Example 2:
 *
 * Input: pattern = pattern = "aaaa", str = "asdasdasdasd"
 * Output: true
 * Example 3:
 *
 * Input: pattern = "aabb", str = "xyzabcxzyabc"
 * Output: false
 * Notes:
 * You may assume both pattern and str contains only lowercase letters.
 *
 */
public class WordPatternII {

    public static boolean exists(String pattern, String str){
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return exists(pattern,0,str,0,map,set);
    }

    public static boolean exists(String pattern, int patternIndex, String str, int strIndex, Map<Character, String> map, Set<String> set){

        if(strIndex==str.length() && patternIndex==pattern.length()) return true;
        if(strIndex==str.length() || patternIndex==pattern.length()) return false;

        char ch = pattern.charAt(patternIndex);

        if(map.containsKey(ch)){
            String prevWord = map.get(ch);
            if(!str.startsWith(prevWord, strIndex)){
                return false;
            }
            return exists(pattern, patternIndex+1, str, strIndex+prevWord.length(), map, set);
        }


        for(int index=strIndex; index<str.length(); index++) {

            String word = str.substring(strIndex, index+1);
            if(set.contains(word)) {
                continue;
            }
            map.put(ch, word);
            set.add(word);
            if(exists(pattern, patternIndex+1, str, index+1, map, set))
                return true;
            map.remove(ch, word);
            set.remove(word);

        }


        return false;
    }

    public static void main(String[] args) {
        System.out.println(exists("ab"  ,"aa"));
    }

}
