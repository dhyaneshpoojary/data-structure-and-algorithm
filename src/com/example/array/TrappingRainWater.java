package com.example.array;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 *
 */
public class TrappingRainWater {

    public static int find(int[] height){
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<height.length;i++){
            max = Math.max(max, height[i]);
            maxLeft[i] = max;
        }

        max = Integer.MIN_VALUE;
        for(int i=height.length-1; i>=0; i--){
            max = Math.max(max, height[i]);
            maxRight[i] = max;
        }

        int result =0;
        for(int i=0; i<height.length; i++){
            result+= Math.min(maxLeft[i], maxRight[i]) - height[i];
        }

        return result;
    }

    public static  int findInAnotherWay(int height[]){
        int left=0, right=height.length-1;
        int maxLeft=Integer.MIN_VALUE, maxRight=Integer.MIN_VALUE;
        int result=0;
        while(left<right){
            if(height[left]<=height[right]){
                maxLeft = Math.max(maxLeft, height[left]);
                result+=maxLeft-height[left];
                left++;
            }else{
                maxRight = Math.max(maxRight, height[right]);
                result+=maxRight-height[right];
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(find(height));
        System.out.println(findInAnotherWay(height));
    }
}
