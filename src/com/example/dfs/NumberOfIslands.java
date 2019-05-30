package com.example.dfs;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length==0) return 0;
        int result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[row].length; col++){
                if(grid[row][col]=='1' && find(grid, row, col, visited))
                   result+=1;
            }
        }


        return result;
    }

    public static boolean find(char[][] grid, int row, int col, boolean[][] visited){

        if(row<0 || row>grid.length-1 || col<0 || col>grid[0].length-1 || visited[row][col] || grid[row][col]=='0') {
            return false;
        }

        visited[row][col]=true;
        find(grid, row+1, col, visited);
        find(grid, row-1, col, visited);
        find(grid, row, col+1, visited);
        find(grid, row, col-1, visited);
        return true;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }
}
