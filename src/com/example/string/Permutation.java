package com.example.string;

import java.util.*;

public class Permutation {

    public static List<String> permute(String str){
        List<String> result = new ArrayList<>();
        permute(str.toCharArray(), result, 0);
        return result;
    }

    public static List<String> permuteInLexicographicalOrder(String str){
        List<String> result = new ArrayList<>();

        Map<Character, Integer> frequencyMap = new TreeMap<>();
        for(int i=0; i<str.length(); i++) {
            frequencyMap.put(str.charAt(i), frequencyMap.getOrDefault(str.charAt(i),0)+1);
        }

        int[] frequencyArray = new int[frequencyMap.size()];
        char[] uniqueCharArray = new char[frequencyMap.size()];
        int index=0;
        for(Map.Entry<Character,Integer> entry: frequencyMap.entrySet()){
            frequencyArray[index]=entry.getValue();
            uniqueCharArray[index]=entry.getKey();
            index++;
        }

        permute(uniqueCharArray , frequencyArray, 0, new char[str.length()], result);
        return result;
    }


    public static void permute(char[] charArray, List<String> result, int left){
        if(left == charArray.length){
            result.add(new String(charArray));
            return;
        }
        for(int i=left; i<charArray.length; i++){
            swap(charArray,left, i);
            permute(charArray, result, left+1);
            swap(charArray, i, left);
        }
    }

    public static void permute(char[] uniqueCharArray, int[] frequencyArray, int level, char[] intermediateResult, List<String> result){
        if(level > frequencyArray.length){
            result.add(new String(intermediateResult));
            return;
        }

        for(int i=0; i<frequencyArray.length; i++){
            if(frequencyArray[i]!=0){
                intermediateResult[level] = uniqueCharArray[i];
                frequencyArray[i]--;
                permute(uniqueCharArray,frequencyArray, level+1, intermediateResult, result);
                frequencyArray[i]++;
            }
        }

    }

    public static void swap(char[] charArray, int pos1, int pos2){
        char temp = charArray[pos1];
        charArray[pos1] = charArray[pos2];
        charArray[pos2] = temp;
    }


    public static void main(String[] args) {
        List<String> result = permute("AAB");
        result.forEach(System.out::println);
        System.out.println("----------------");
        List<String> resultInLexicographicalOrder = permuteInLexicographicalOrder("AAB");
        resultInLexicographicalOrder.forEach(System.out::println);
    }
}
