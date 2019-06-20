package com.example.dfs;

import java.util.Arrays;

/**
 * Let's play the minesweeper game (Wikipedia, online game)!
 *
 * You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.
 *
 * Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:
 *
 * If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
 * If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 *
 *
 * Example 1:
 *
 * Input:
 *
 * [['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'M', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E']]
 *
 * Click : [3,0]
 *
 * Output:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * Explanation:
 *
 * Example 2:
 *
 * Input:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * Click : [1,2]
 *
 * Output:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'X', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * Explanation:
 *
 *
 *
 * Note:
 *
 * The range of the input matrix's height and width is [1,50].
 * The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least one clickable square.
 * The input board won't be a stage when game is over (some mines have been revealed).
 * For simplicity, not mentioned rules should be ignored in this problem.
 * For example, you don't need to reveal all the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.
 *
 */
public class Minesweeper {

    private static int[] x = {-1,0,1,-1,0,1,-1,0,1};
    private static int[] y = {-1,-1,-1,0,0,0,1,1,1};

    public static char[][] updateBoard(char[][] board, int[] click) {
        int clickRow = click[0];
        int clickCol = click[1];

        if(board[clickRow][clickCol]=='M'){
            board[clickRow][clickCol]='X';
            return board;
        }

        updateBoard(board, clickRow, clickCol);
        return board;
    }

    public static void updateBoard(char[][] board, int row, int col){
        if(row<0 || col<0 || row>board.length-1 || col>board[0].length-1 ||board[row][col]!='E')
            return;

        int totalNumberOfAdjacentBombs = getTotalNumberOfAdjacentBombs(board, row, col);

        if(totalNumberOfAdjacentBombs==0){
            board[row][col]='B';
            for(int index=0; index<x.length; index++){
                int newRow = row+x[index];
                int newCol = col+y[index];
                updateBoard(board, newRow, newCol);
            }
        }else{
            board[row][col]=(char)('0'+totalNumberOfAdjacentBombs);
        }

    }

    public static int getTotalNumberOfAdjacentBombs(char[][] board, int row, int col){
        int count=0;
        for(int index=0; index<x.length; index++){
            int newRow = row+x[index];
            int newCol = col+y[index];

            if(newRow<0 || newCol<0 || newRow>board.length-1 || newCol>board[0].length-1)
                continue;

            if(board[newRow][newCol]=='M')
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] board = {
                "EEEEE".toCharArray(),
                "EEMEE".toCharArray(),
                "EEEEE".toCharArray(),
                "EEEEE".toCharArray()
        };
        int[] click = {0,0};
        System.out.println(Arrays.deepToString(updateBoard(board, click)));
    }
}
