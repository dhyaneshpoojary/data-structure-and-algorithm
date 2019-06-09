package com.example.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import com.example.graph.Graph.Node;

public class TopologicalSort {

    private Graph graph;

    public TopologicalSort(Graph graph){
        this.graph = graph;
    }

    public Deque<Node> sort(){
        Set<Node> nodes = graph.getAllNodes();
        Set<Node> visited = new HashSet<>();
        Deque<Node> stack = new ArrayDeque<>();
        for(Node node : nodes){
            if(!visited.contains(node)) {
                sort(visited,stack,node);
            }
        }
        return stack;
    }

    public void sort(Set<Node> visited, Deque<Node> stack, Node node){
        visited.add(node);
        for(Node adjacentNode : graph.getAdjacentNodes(node)){
            if(!visited.contains(adjacentNode)){
                sort(visited, stack, adjacentNode);
            }
        }
        stack.push(node);
    }




    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.addNode(7);
        graph.addNode(8);

        graph.addEdge(1,2);
        graph.addEdge(1,6);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(2,7);
        graph.addEdge(4,5);
        graph.addEdge(4,8);
        graph.addEdge(7,8);
        graph.addEdge(5,8);

        TopologicalSort topologicalSort = new TopologicalSort(graph);
        Deque<Node> result = topologicalSort.sort();
        while(!result.isEmpty()){
            System.out.println(result.pop());
        }
    }
}
