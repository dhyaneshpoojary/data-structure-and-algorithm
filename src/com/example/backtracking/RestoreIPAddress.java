package com.example.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * Example:
 *
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIPAddress {

    public static List<String> build(String s) {
        List<Integer> intermediateResult = new ArrayList<>();
        List<String> result = new ArrayList<>();
        build(s, 0, intermediateResult, result);
        return  result;
    }

    public static void build(String input, int start, List<Integer> intermediateResult, List<String> result) {

        if(intermediateResult.size()==4 && start == input.length()){
            String ipAddress = intermediateResult.get(0)+"."+ intermediateResult.get(1)+"."+ intermediateResult.get(2)+"."+ intermediateResult.get(3);
            result.add(ipAddress);
            return;
        }

        if(intermediateResult.size()>4 || start>input.length()-1){
            return;
        }

        for(int index=1; index<=3 && start + index <= input.length(); index++){
            int num = Integer.parseInt(input.substring(start, start+index));
            if(num>255 || index>1 && input.charAt(index)=='0'){
                break;
            }
            intermediateResult.add(num);
            build(input, start+index,  intermediateResult, result);
            intermediateResult.remove(intermediateResult.size()-1);
        }

    }


    public static void main(String[] args){
        System.out.println(build("25525511135"));
    }


}
