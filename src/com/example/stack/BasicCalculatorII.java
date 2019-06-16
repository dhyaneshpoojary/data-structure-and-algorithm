package com.example.stack;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: " 3+5 / 2 "
 * Output: 5
 *
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class BasicCalculatorII {


    public static int calculate(String expression){
        int result = 0, num = 0;
        char prevSign = '+';
        Stack<Integer>  stack = new Stack<>();
        stack.push(0);
        for(int index=0; index<expression.length(); index++){
            char character = expression.charAt(index);

            if(Character.isDigit(character)){
                num = num*10+character-'0';
            }

            if((!Character.isDigit(character) && character!=' ') || index == expression.length()-1) {
                if (prevSign == '+') {
                    stack.push(num);
                }

                if (prevSign == '-') {
                    stack.push(-num);
                }

                if (prevSign == '*') {
                    stack.push(stack.pop() * num);
                }

                if (prevSign == '/') {
                    stack.push(stack.pop() / num);
                }

                prevSign = character;
                num = 0;
            }
        }

        while(!stack.isEmpty()){
            result+=stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2-2+2*3+1"));
    }
}
