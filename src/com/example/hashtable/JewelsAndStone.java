package com.example.hashtable;

import java.util.HashMap;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 *
 * Note:
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 *
 */
public class JewelsAndStone {

    public static int count(String J, String S) {
        HashMap<Character, Integer> characterFrequencyMap = new HashMap<>();

        for(int index=0; index<S.length(); index++){
            Character character = S.charAt(index);
            int frequency = characterFrequencyMap.getOrDefault(character, 0);
            characterFrequencyMap.put(character, frequency+1);
        }

        int result = 0;
        for(int index=0; index<J.length(); index++){
            result+=characterFrequencyMap.getOrDefault(J.charAt(index),0);
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(JewelsAndStone.count("aA", "aAAbbbb"));
    }

}
