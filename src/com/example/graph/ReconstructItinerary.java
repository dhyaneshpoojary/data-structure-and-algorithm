package com.example.graph;

import java.util.*;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 *
 */
public class ReconstructItinerary {

    public static List<String> findItinerary(List<List<String>>  tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket: tickets){
            PriorityQueue<String> minHeap =  map.getOrDefault(ticket.get(0), new PriorityQueue<>());
            minHeap.add(ticket.get(1));
            map.put(ticket.get(0), minHeap);
        }
        List<String> result = new ArrayList<>();
        visit("JFK", map, result);
        return result;
    }

    public static void visit(String airport, Map<String, PriorityQueue<String>> map, List<String> result){
        while(map.containsKey(airport) && !map.get(airport).isEmpty()){
            visit(map.get(airport).remove(), map , result);
        }
        result.add(0, airport);
    }


    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));
        System.out.println(findItinerary(tickets));
    }

}
