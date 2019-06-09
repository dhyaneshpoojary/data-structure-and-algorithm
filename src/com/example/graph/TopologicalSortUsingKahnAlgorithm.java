package com.example.graph;

import java.util.*;
import com.example.graph.Graph.Node;

public class TopologicalSortUsingKahnAlgorithm {

    public static void sort(Graph graph){

        for(Node node : graph.getAllNodes()){
            for(Node adjacentNode  : graph.getAdjacentNodes(node)) {
                int inDegree = adjacentNode.getInDegree()+1;
                adjacentNode.setInDegree(inDegree);
            }
        }

        Queue<Node> queue = new LinkedList<>();

        for(Node node : graph.getAllNodes()){
            if(node.getInDegree()==0){
                queue.add(node);
            }
        }

        Set<Node> visited = new HashSet<>();

        while(!queue.isEmpty()){
            Node node = queue.remove();

            if(!visited.contains(node)){
                visited.add(node);
                for(Node adjacentNode : graph.getAdjacentNodes(node)){
                    int inDegree = adjacentNode.getInDegree()-1;
                    adjacentNode.setInDegree(inDegree);
                    if(adjacentNode.getInDegree()==0){
                        queue.add(adjacentNode);
                    }
                }
            }
        }

        if(visited.size() != graph.getAllNodes().size()){
            System.out.println("Contains Cycle");
            return;
        }

        for(Node node: visited){
            System.out.println(node);
        }
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

        sort(graph);
    }
}
