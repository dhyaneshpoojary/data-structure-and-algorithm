package com.example.linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 */
public class AddTwoNumbers {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static ListNode calculate(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode currentNode = dummyHead;
        while(l1 != null || l2 != null){
            int digit1 = (l1!=null)?l1.val:0;
            int digit2 = (l2!=null)?l2.val:0;
            int addDigitResult = digit1+digit2+carry;
            carry = addDigitResult/10;
            int remDigitResult = addDigitResult%10;
            ListNode result = new ListNode(remDigitResult);
            currentNode.next = result;
            currentNode = result;
            if(l1!=null) l1 = l1.next;
            if(l2!=null ) l2 = l2.next;
        }

        if(carry>0) {
            ListNode result = new ListNode(carry);
            currentNode.next = result;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(7);

        ListNode l2 = new ListNode(6);
        l2.next = new ListNode(7);

        ListNode result = AddTwoNumbers.calculate(l1, l2);

        while(result!=null){
            System.out.print(result.val+" ");
            result = result.next;
        }

    }

}


