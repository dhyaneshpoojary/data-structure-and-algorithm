package com.example.linkedlist;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedList {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode currentHead = dummyHead;
        while(l1 != null && l2 != null){

            if(l1.val < l2.val){
                currentHead.next =  l1;
                currentHead = currentHead.next;
                l1 = l1.next;
            }else{
                currentHead.next = l2;
                currentHead = currentHead.next;
                l2 = l2.next;
            }

        }

        if(l1 !=  null){
            currentHead.next = l1;
        }

        if(l2 != null){
            currentHead.next = l2;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);


        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(l1, l2);

        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
