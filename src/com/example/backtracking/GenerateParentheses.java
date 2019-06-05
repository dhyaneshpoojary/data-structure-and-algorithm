package com.example.backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class GenerateParentheses {

    public static List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        generate(n,n,"",result);
        return result;
    }

    public static void generate(int numOfLeftParentheses, int numOfRightParentheses, String str, List<String> result){

        if(numOfLeftParentheses==0 && numOfRightParentheses==0){
            result.add(str);
            return;
        }

        if(numOfLeftParentheses>0){
            generate(numOfLeftParentheses-1, numOfRightParentheses, str+"(",result);
        }

        if(numOfLeftParentheses < numOfRightParentheses){
            generate(numOfLeftParentheses, numOfRightParentheses-1, str+")",result);
        }

    }

    public static void main(String[] args) {
        System.out.println(generate(3));
    }
}
