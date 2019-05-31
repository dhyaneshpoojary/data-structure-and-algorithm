package com.example.sorting;

public class QuickSelect {

    public static int partition(int arr[], int left, int right){
        int pivot = arr[right];
        int pivotIndex=left;
        for(int start=left; start<right; start++){
            if(arr[start]<=pivot){
                swap(arr, start, pivotIndex);
                pivotIndex++;
            }
        }
        swap(arr, pivotIndex, right);
        return pivotIndex;
    }

    public static void swap(int arr[], int firstIndex, int secondIndex){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public static int find(int arr[], int left, int right, int k){
        int partitionIndex = partition(arr, left, right);
        if(partitionIndex == k){
            return arr[partitionIndex];
        }else if(k< partitionIndex){
            return find(arr, left, partitionIndex-1, k);
        }else{
            return find(arr, partitionIndex+1, right, k);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 7, 4, 6, 3, 9, 1 };
        System.out.println(find(arr, 0, arr.length-1, 2));
    }
}
