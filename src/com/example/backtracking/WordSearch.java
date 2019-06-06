package com.example.backtracking;

/**
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where 'adjacent' cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = 'ABCCED', return true.
 * Given word = 'SEE', return true.
 * Given word = 'ABCB', return false.
 *
 */
public class WordSearch {

    public static boolean find(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[0].length; col++){
                if(board[row][col] == word.charAt(0) && find(board, word, row, col, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean find(char[][] board, String word, int row, int col, int strPos, boolean[][] visited){

        if(strPos == word.length()){
            return true;
        }

        if(row<0 || row>board.length-1 || col<0 || col>board[0].length-1 || board[row][col] != word.charAt(strPos) || visited[row][col]){
            return false;
        }

        visited[row][col] = true;
        boolean result = find(board, word, row+1, col, strPos+1, visited) ||
                find(board, word, row-1, col, strPos+1, visited) ||
                find(board, word, row, col-1, strPos+1, visited) ||
                find(board, word, row, col+1, strPos+1, visited);
        visited[row][col] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(find(board, word));
    }
}
