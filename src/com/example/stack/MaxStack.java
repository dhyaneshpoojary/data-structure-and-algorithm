package com.example.stack;

import java.util.Stack;

public class MaxStack {

    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        if(maxStack.isEmpty()){
            maxStack.push(x);
        }else{
            int max = maxStack.peek();
            if(max<x){
                maxStack.push(x);
            }else{
                maxStack.push(max);
            }
        }
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack<>();
        while(max != top()){
            buffer.push(pop());
        }
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(2);
        maxStack.push(1);
        maxStack.push(1);

        maxStack.popMax();
    }

}
