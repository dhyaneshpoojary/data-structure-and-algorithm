package com.example.stack;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * Example 1:
 *
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class BasicCalculator {

    public static int calculate(String expression){
        int result = 0, num =0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        for(int index=0; index<expression.length(); index++){
            char character = expression.charAt(index);
            if(Character.isDigit(character)){
                num = num*10 + character-'0';
            }else if(character=='+'){
                    result+= sign*num;
                    sign = 1;
                    num=0;
            }else if(character=='-'){
                    result += sign*num;
                    sign = -1;
                    num=0;
            }else if(character == '('){
                    stack.push(result);
                    stack.push(sign);
                    result=0;
                    sign=1;
            }else if(character == ')'){
                    result += sign*num;
                    result *= stack.pop();
                    result += stack.pop();
                    num=0;
            }
        }

        if(num!=0) result+=sign*num;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate(" 2-1 + 2 "));
    }
}
