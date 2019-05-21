package com.example.hashtable;

import java.util.HashMap;

/**
 * Minimum Window Substring
 * Hard
 *
 * 2213
 *
 * 156
 *
 * Favorite
 *
 * Share
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 *
 */
public class MaximumWindowSubstring {

    public static String find(String s, String t){
        HashMap<Character, Integer> tMap = new HashMap<>();

        for(int index=0; index<t.length(); index++){
            tMap.put(t.charAt(index), tMap.getOrDefault(t.charAt(index), 0)+1);
        }

        int start=0, end=0, count=0;
        int[] ans = {-1, 0, 0};
        HashMap<Character, Integer> sMap = new HashMap<>();

        while(end<s.length()){
            Character character = s.charAt(end);
            sMap.put(character, sMap.getOrDefault(character,0)+1);
            if(tMap.containsKey(character) && tMap.get(character).intValue() == sMap.get(character).intValue()){
                count++;
            }
            while(start<end && count == tMap.size()){
                if(ans[0]==-1 || end-start+1<ans[0]){
                    ans[0] = end-start+1;
                    ans[1] = start;
                    ans[2] = end;
                }
                sMap.put(s.charAt(start), sMap.get(s.charAt(start))-1);
                if(tMap.containsKey(s.charAt(start)) && tMap.get(s.charAt(start)) > sMap.get(s.charAt(start))){
                        count--;
                }
                start++;
            }
            end++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
    }

    public static void main(String[] args) {
        System.out.println(find("ADOBECODEBANC", "ABC"));
    }
}
