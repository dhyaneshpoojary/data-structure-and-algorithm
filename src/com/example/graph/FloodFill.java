package com.example.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    private static int[] row = {-1,-1,-1,0,0,1,1,1};
    private static int[] col = {-1,0,1,-1,1,-1,0,1};

    public static boolean isSafe(char[][] matrix, int x, int y, char replacement){
        return x >= 0 && x <= matrix.length - 1 && y >= 0 && y <= matrix[0].length - 1 && matrix[x][y] == replacement;
    }

    public static void findAndReplace(char[][] matrix, int x, int y, char replacement){
        char target = matrix[x][y];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x,y));

        while(!queue.isEmpty()){
            Pair pair = queue.remove();

            matrix[pair.x][pair.y] = replacement;

            for(int index=0; index<8; index++){
                if(isSafe(matrix, pair.x+row[index], pair.y+col[index], target)){
                    queue.add(new Pair(pair.x+row[index], pair.y+col[index]));
                }
            }
        }

    }


    public static void main(String[] args) {
        char[][] matrix =  {
                            "RRB".toCharArray(),
                            "BRB".toCharArray(),
                            "RBR".toCharArray()
                            };

        findAndReplace(matrix, 1,1,'W');

        System.out.println(Arrays.deepToString(matrix));
    }

    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x= x;
            this.y=y;
        }
    }

}
