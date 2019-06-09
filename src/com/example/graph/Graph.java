package com.example.graph;

import java.util.*;

public class Graph {

    static class Node{
        private int id;
        private int inDegree;
        private int weight;

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getInDegree() {
            return inDegree;
        }

        public void setInDegree(int inDegree) {
            this.inDegree = inDegree;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return id == node.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    '}';
        }
    }

    private Map<Node, List<Node>> nodeVsAdjacentNodesMap = new HashMap<>();
    private Map<Integer, Node> nodeMap = new HashMap<>();

    public void addNode(int id){
        Node node = new Node();
        node.setId(id);
        if(nodeMap.containsKey(id)){
            throw new IllegalArgumentException("Node already exists");
        }
        nodeMap.put(id, node);
        List<Node> adjacencyList = new LinkedList<>();
        nodeVsAdjacentNodesMap.put(node, adjacencyList);
    }

    public void addEdge(int source, int destination){
        Node sourceNode = getNode(source);
        Node destinationNode = getNode(destination);
        if(!nodeVsAdjacentNodesMap.containsKey(sourceNode)){
            throw new IllegalArgumentException("Source Node does not exists");
        }
        if(!nodeVsAdjacentNodesMap.containsKey(destinationNode)){
            throw new IllegalArgumentException("Destination Node does not exists");
        }

        nodeVsAdjacentNodesMap.get(sourceNode).add(destinationNode);
    }

    public List<Node> getAdjacentNodes(Node node){
        return nodeVsAdjacentNodesMap.get(node);
    }

    public Node getNode(int id){
        return nodeMap.get(id);
    }

    public Set<Node> getAllNodes(){
        return nodeVsAdjacentNodesMap.keySet();
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(1,3);
    }


}


