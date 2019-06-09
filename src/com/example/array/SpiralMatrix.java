package com.example.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0)
            return result;

        int lowCol=0, highCol=matrix[0].length-1, lowRow=0, highRow=matrix.length-1;

        while(lowCol<=highCol && lowRow<=highRow){

            for(int col=lowCol; col<=highCol; col++){
                result.add(matrix[lowRow][col]);
            }

            for(int row=lowRow+1; row<=highRow; row++){
                result.add(matrix[row][highCol]);
            }

            if(lowCol<highCol && lowRow<highRow) {
                for (int col = highCol-1; col > lowCol; col--) {
                    result.add(matrix[highRow][col]);
                }
                for (int row = highRow; row > lowRow; row--) {
                    result.add(matrix[row][lowCol]);
                }
            }
            lowRow++;
            highRow--;
            lowCol++;
            highCol--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }
}
