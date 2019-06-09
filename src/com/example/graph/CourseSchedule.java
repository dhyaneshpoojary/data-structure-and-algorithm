package com.example.graph;

import com.example.graph.Graph.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 * Note:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 *
 */
public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph();

        for(int index=0; index<numCourses; index++){
            graph.addNode(index);
        }

        for(int[] prerequisite : prerequisites){
            graph.addEdge(prerequisite[1],  prerequisite[0]);
        }

        for(Node node: graph.getAllNodes()){
            for(Node adjacentNode: graph.getAdjacentNodes(node)){
                int inDegree = adjacentNode.getInDegree();
                adjacentNode.setInDegree(++inDegree);
            }
        }

        Queue<Node> queue = new LinkedList<>();

        for(Node node: graph.getAllNodes()){
            if(node.getInDegree()==0) queue.add(node);
        }

        Set<Node> visited = new HashSet<>();
        while(!queue.isEmpty()){
            Node node = queue.remove();
            if(!visited.contains(node)){
                visited.add(node);
                for(Node adjacentNode: graph.getAdjacentNodes(node)){
                    int inDegree = adjacentNode.getInDegree();
                    adjacentNode.setInDegree(--inDegree);
                    if(adjacentNode.getInDegree()==0){
                        queue.add(adjacentNode);
                    }
                }
            }
        }
        return visited.size()==numCourses;
    }

    public static void main(String[] args) {
        int [][] nums = {{1,0}};
        System.out.println(canFinish(2, nums));
    }
}
