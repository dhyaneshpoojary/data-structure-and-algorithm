package com.example.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 *
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 */
public class WordPattern {

    public static boolean exists(String pattern, String str) {
        Map<String, Character> wordToCharMapping = new HashMap<>();
        Map<Character, String> charToWordMapping = new HashMap<>();

        String[] words = str.split(" ");

        if(words.length != pattern.length()) return false;

        for(int index=0; index<words.length; index++){
            char ch = pattern.charAt(index);
            String word = words[index];

            if(charToWordMapping.containsKey(ch) &&
                    !word.equals(charToWordMapping.get(ch))) {
                return false;
            }

            if(wordToCharMapping.containsKey(word) &&
                    ch != wordToCharMapping.get(word)) {
                return false;
            }

            charToWordMapping.put(ch, word);
            wordToCharMapping.put(word, ch);
        }


        return true;
    }

    public static void main(String[] args) {
        System.out.println(exists("abab", "dog cat dog cat"));
    }
}
