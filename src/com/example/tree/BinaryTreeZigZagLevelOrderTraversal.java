package com.example.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
public class BinaryTreeZigZagLevelOrderTraversal {

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            List<Integer> intermediateResult = new ArrayList<>();

            while(!stack1.isEmpty()){

                TreeNode node = stack1.pop();
                if(node.left != null)
                    stack2.push(node.left);
                if(node.right != null)
                    stack2.push(node.right);
                intermediateResult.add(node.val);
            }

            if(!intermediateResult.isEmpty()){
                result.add(intermediateResult);
            }

            intermediateResult = new ArrayList<>();
            while(!stack2.isEmpty()){

                TreeNode node = stack2.pop();
                if(node.right != null)
                    stack1.push(node.right);
                if(node.left != null)
                    stack1.push(node.left);
                intermediateResult.add(node.val);

            }

            if(!intermediateResult.isEmpty()){
                result.add(intermediateResult);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);

        System.out.println(traverse(root));
    }
}
