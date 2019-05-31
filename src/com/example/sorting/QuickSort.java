package com.example.sorting;

public class QuickSort {

    public static int partition(int[] arr, int left, int right){
        int pivot = arr[right];
        int partitionIndex = left;
        for(int index=left; index<right; index++){
            if(arr[index]<= pivot){
                swap(arr, partitionIndex, index);
                partitionIndex++;
            }
        }
        swap(arr, partitionIndex, right);
        return partitionIndex;
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void sort(int[] arr, int left, int right){
      if(left<right){
          int partitionIndex = partition(arr, left, right);
          sort(arr, left, partitionIndex-1);
          sort(arr, partitionIndex+1, right);
      }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        sort(arr, 0, arr.length-1);
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
