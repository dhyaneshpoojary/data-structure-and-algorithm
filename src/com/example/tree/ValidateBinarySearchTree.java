package com.example.tree;

public class ValidateBinarySearchTree {

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    private static TreeNode prev = null;

    public static boolean isValidBST(TreeNode root) {

        if(root== null) return true;

        if(!isValidBST(root.left))
            return false;

        if(prev!=null && prev.val>=root.val){
            System.out.println(root.val+" "+prev.val);
            return false;
        }

        prev = root;

        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(isValidBST(root));
    }
}
