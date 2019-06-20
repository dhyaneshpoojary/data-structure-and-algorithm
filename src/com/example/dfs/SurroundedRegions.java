package com.example.dfs;

import java.util.Arrays;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 */
public class SurroundedRegions {

    public static void solve(char[][] board) {
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[row].length; col++){
                if(row==0 || row== board.length-1 || col==0 || col==board[row].length-1)
                    mark(board, row, col, '*');
            }
        }

        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[row].length; col++){
                if(board[row][col]=='*')
                    board[row][col]='O';
                else if(board[row][col]=='O')
                    board[row][col]='X';
            }
        }
    }

    public static void mark(char[][] board, int row, int col, char ch){
        if(row<0 || col<0 || row>board.length-1 || col>board[row].length-1)
            return;
        if(board[row][col]=='X' || board[row][col]==ch)
            return;

        board[row][col] = ch;

        mark(board, row+1, col, ch);
        mark(board, row, col+1, ch);
        mark(board, row-1, col, ch);
        mark(board, row , col-1, ch);
    }

    public static void main(String[] args) {
        char[][] board = {"XXXX".toCharArray(), "XOOX".toCharArray(), "XXOX".toCharArray(), "XOXX".toCharArray()};
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
