package com.example.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class Maze {

    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] directions={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] currentCell = queue.remove();
            if (currentCell[0] == destination[0] && currentCell[1] == destination[1])
                return true;
            for (int[] direction: directions) {
                int newRow = currentCell[0] + direction[0];
                int newCol = currentCell[1] + direction[1];
                while (newRow >= 0 && newCol >= 0 && newRow < maze.length && newCol < maze[0].length && maze[newRow][newCol] == 0) {
                    newRow += direction[0];
                    newCol += direction[1];
                }
                if (!visited[newRow - direction[0]][newCol - direction[1]]) {
                    queue.add(new int[] {newRow - direction[0], newCol - direction[1]});
                    visited[newRow - direction[0]][newCol - direction[1]] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {{1,1,0,0},{0,0,0,0},{0,0,0,1},{0,0,1,1}};
        System.out.println(hasPath(maze, new int[]{0,3}, new int[]{1,0}));
    }
}
