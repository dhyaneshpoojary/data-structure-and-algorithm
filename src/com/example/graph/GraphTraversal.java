package com.example.graph;

import java.util.HashSet;
import java.util.LinkedList;
import com.example.graph.Graph.Node;


public class GraphTraversal {

    private Graph graph;

    public GraphTraversal(Graph graph) {
        this.graph = graph;
    }

    public boolean hasPathDFS(int source, int destination){
        Node sourceNode = graph.getNode(source);
        Node destinationNode = graph.getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(sourceNode, destinationNode, visited);
    }

    public boolean hasPathDFS(Node sourceNode, Node destinationNode, HashSet<Integer> visited) {

        if(visited.contains(sourceNode.getId())){
            return false;
        }

        if(sourceNode.equals(destinationNode)){
            return true;
        }

        visited.add(sourceNode.getId());

        for(Node adjacentNode: graph.getAdjacentNodes(sourceNode)){
            if(hasPathDFS(adjacentNode, destinationNode, visited)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasPathBFS(int source, int destination){
        Node sourceNode = graph.getNode(source);
        Node destinationNode = graph.getNode(destination);

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(sourceNode);

        HashSet<Integer> visited = new HashSet<>();
        visited.add(source);

        while(!queue.isEmpty()){
            Node node = queue.remove();
            if(node.equals(destinationNode)){
                return true;
            }

            if(visited.contains(node)){
                continue;
            }

            visited.add(node.getId());

            for(Node adjacentNode: graph.getAdjacentNodes(node)){
                queue.add(adjacentNode);
            }
        }

        return false;
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
        graph.addNode(9);

        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(3,4);
        graph.addEdge(2,5);
        graph.addEdge(3,5);
        graph.addEdge(4,5);
        graph.addEdge(2,6);
        graph.addEdge(6, 7);
        graph.addEdge(8,9);

        GraphTraversal graphTraversal = new GraphTraversal(graph);

        System.out.println(graphTraversal.hasPathDFS(1,9));
        System.out.println(graphTraversal.hasPathDFS(1,5));

        System.out.println(graphTraversal.hasPathBFS(1,9));
        System.out.println(graphTraversal.hasPathBFS(1,5));

    }

}

