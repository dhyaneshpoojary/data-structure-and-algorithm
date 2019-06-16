package com.example.backtracking;

import java.util.*;
import java.util.stream.Collectors;


/**
 *A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].
 *
 * Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.
 *
 * Note:
 *
 * A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
 * Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
 * Example 1:
 *
 * Input:
 * [[0,1,10], [2,0,5]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * Person #0 gave person #1 $10.
 * Person #2 gave person #0 $5.
 *
 * Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.
 * Example 2:
 *
 * Input:
 * [[0,1,10], [1,0,1], [1,2,5], [2,0,5]]
 *
 * Output:
 * 1
 *
 * Explanation:
 * Person #0 gave person #1 $10.
 * Person #1 gave person #0 $1.
 * Person #1 gave person #2 $5.
 * Person #2 gave person #0 $5.
 *
 * Therefore, person #1 only need to give person #0 $4, and all debt is settled.
 *
 */
public class OptimalAccountBalancing {

    public static int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] transaction: transactions){

            int lender = transaction[0];
            int borrower = transaction[1];
            int amount = transaction[2];

            map.put(lender, map.getOrDefault(lender, 0)+amount);
            map.put(borrower, map.getOrDefault(borrower,0)-amount);

        }

        List<Integer> debts = map.entrySet().stream().map(entry->entry.getValue()).collect(Collectors.toList());

        return findMinTransfers(0, debts);
    }

    public static int findMinTransfers(int start, List<Integer> debts){
        while(start<debts.size() && debts.get(start)==0) start++;
        if(start==debts.size()) return 0;
        int result = Integer.MAX_VALUE;
        for(int i=start+1; i<debts.size(); i++){
            if(debts.get(start)*debts.get(i)<0){
                debts.set(i, debts.get(i)+debts.get(start));
                result = Math.min(result, 1+findMinTransfers(start+1, debts));
                debts.set(i, debts.get(i)-debts.get(start));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] transactions = {{0,3,2},{1,4,3},{2,3,2},{2,4,2}};
        minTransfers(transactions);
    }
}
