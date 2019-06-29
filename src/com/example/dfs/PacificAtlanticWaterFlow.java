package com.example.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 *
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 *
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 *
 * Note:
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * Example:
 *
 * Given the following 5x5 matrix:
 *
 *   Pacific ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * Atlantic
 *
 * Return:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 *
 */
public class PacificAtlanticWaterFlow {

    private static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public static List<int[]> find(int[][] matrix) {

        List<int[]> result = new ArrayList<>();

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }

        boolean[][] canReachPacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] canReachAtlantic = new boolean[matrix.length][matrix[0].length];

        for(int index=0; index<matrix.length; index++){
            find(matrix, canReachPacific, Integer.MIN_VALUE, index, 0);
            find(matrix, canReachAtlantic, Integer.MIN_VALUE, index, matrix[0].length-1);
        }

        for(int index=0; index<matrix[0].length; index++){
            find(matrix, canReachPacific, Integer.MIN_VALUE, 0, index);
            find(matrix, canReachAtlantic, Integer.MIN_VALUE, matrix.length-1, index);
        }

        for(int row=0; row<matrix.length; row++){
            for(int col=0; col<matrix[0].length; col++){
                if(canReachPacific[row][col] && canReachAtlantic[row][col])
                    result.add(new int[] {row,col});
            }
        }

        return result;
    }

    public static void find(int[][] matrix, boolean[][] canReach, int height, int row, int col){
        if(row<0 || col<0 || col>matrix[0].length-1 || row>matrix.length-1 || matrix[row][col] < height || canReach[row][col])
            return;

        canReach[row][col]=true;

        for(int[] direction: directions){
            find(matrix, canReach, matrix[row][col], row+direction[0], col+direction[1]);
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        for(int[] result : find(matrix)){
            System.out.println(result[0]+","+result[1]);
        }
    }
}
