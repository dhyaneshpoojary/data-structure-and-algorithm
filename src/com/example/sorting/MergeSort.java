package com.example.sorting;

public class MergeSort {

    public static void divide(int arr[], int left, int right){
        if(left<right) {
            int mid = (left + right) / 2;
            divide(arr, left, mid);
            divide(arr, mid + 1, right);
            sort(arr, left, mid, right);
        }
    }

    public static void sort(int[] arr, int left, int mid, int right){
        int i = left;
        int j  = mid+1;
        int[] temp = new int[right-left+1];
        int k=0;
        while(i<=mid && j<=right){
            if(arr[i]>arr[j]){
                temp[k++]= arr[j++];
            }else{
                temp[k++]=arr[i++];
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=right){
            temp[k++]=arr[j++];
        }
        for(int m=left; m<=right; m++){
            arr[m] = temp[m-left];
        }
    }


    public static void main(String[] args) {
        int[] arr = {5,4,1,2,6,3};
        divide(arr,0, arr.length-1);
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
