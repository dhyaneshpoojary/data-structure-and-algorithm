package com.example.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
 *
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 *
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 *
 *
 *
 * Example 1:
 *
 * Input: [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 *
 * Input: [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 *
 * Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 *
 *
 * Note:
 *
 * 1 <= A.length = A[0].length <= 100
 * A[i][j] == 0 or A[i][j] == 1
 *
 */
public class ShortestBridge {

    public static int find(int[][] grid) {
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        for(int row=0; row<grid.length; row++){
            if(found)
                break;
            for(int col=0; col<grid[row].length; col++){
                if(grid[row][col]==1){
                    findIsland(grid, row, col, visited, queue);
                    found= true;
                    break;
                }
            }
        }
        int step=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] cell = queue.remove();
                int row = cell[0];
                int col = cell[1];
                for(int[] direction : directions){
                    int newRow = row+direction[0];
                    int newCol = col+direction[1];
                    if(newRow>=0 && newCol>=0 && newRow<=grid.length-1 && newCol<=grid[0].length-1 && !visited[newRow][newCol]){
                        if(grid[newRow][newCol]==1){
                            return step;
                        }
                        visited[newRow][newCol] = true;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void findIsland(int[][] grid, int row, int col, boolean[][] visited, Queue<int[]> queue){
        if(row<0 || col<0 || row>grid.length-1 || col>grid[row].length-1 || grid[row][col]==0 || visited[row][col])
            return;
        visited[row][col]=true;
        queue.add(new int[]{row,col});
        findIsland(grid, row+1, col, visited, queue);
        findIsland(grid, row-1, col, visited, queue);
        findIsland(grid, row, col+1, visited, queue);
        findIsland(grid, row, col-1, visited, queue);
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0},{0,0,0},{0,0,1}};
        System.out.println(find(grid));
    }
}
