package com.example.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 */
public class GroupAnagrams {

    public static List<List<String>> execute(String[] words) {
        int[] countTable = new int[26];
        HashMap<String, List<String>> map = new HashMap<>();
        for(String word : words){
            Arrays.fill(countTable,0);

            for(int index=0; index<word.length(); index++){
                countTable[word.charAt(index)-'a']+=1;
            }

            StringBuilder countStringBuilder = new StringBuilder();
            for(int index=0; index<26; index++){
                countStringBuilder.append("#");
                countStringBuilder.append(countTable[index]);
            }
            String countString = countStringBuilder.toString();

            if(map.containsKey(countString)){
                map.get(countString).add(word);
            }else{
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(countString, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] words ={"eat","tea","tan","ate","nat","bat"};
        System.out.println(execute(words));
    }
}
