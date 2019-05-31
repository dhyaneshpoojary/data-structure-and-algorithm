package com.example.heap;

import java.util.Arrays;

public class MinHeap {

    private int capacity = 10;
    private int size = 0;
    private int[] arr = new int[capacity];

    public int getLeftChild(int parentIndex){
        return arr[2*parentIndex+1];
    }

    public int getRightChild(int parentIndex){
        return arr[2*parentIndex+2];
    }

    public int getParent(int childIndex){
        return arr[(childIndex-1)/2];
    }

    public boolean hasParent(int childIndex){
        return (childIndex-1)/2 >=0;
    }

    public boolean hasLeftChild(int parentIndex){
        return (2*parentIndex+1) < size;
    }

    public boolean hasRightChild(int parentIndex){
        return (2*parentIndex+2) < size;
    }

    public int getParentIndex(int childIndex){
        return (childIndex-1)/2;
    }

    public int getLeftChildIndex(int parentIndex){
        return 2*parentIndex+1;
    }

    public int getRightChildIndex(int parentIndex){
        return 2*parentIndex+2;
    }

    public void swap(int firstIndex, int secondIndex){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public void ensureExtraCapacity(){
        if(size==capacity){
            arr = Arrays.copyOf(arr, capacity*2);
            capacity*=2;
        }
    }


    public int remove(){
        if(size==0) throw new IllegalStateException();
        int element = arr[0];
        arr[0] = arr[size-1];
        size--;
        heapifyDown();
        return element;
    }

    public void add(int item){
        ensureExtraCapacity();
        arr[size]=item;
        size++;
        heapifyUp();
    }

    public void heapifyUp(){
        int index = size-1;
        while(hasParent(index) && getParent(index)>arr[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChild(index) < getLeftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }

            if(arr[index] <  arr[smallerChildIndex]){
                break;
            }else{
                swap(smallerChildIndex, index);
            }

            index = smallerChildIndex;
        }
    }

    public boolean isEmpty(){
        return size==0;
    }

    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap();
        minHeap.add(20);
        minHeap.add(10);
        minHeap.add(40);
        minHeap.add(30);
        while(!minHeap.isEmpty()){
            System.out.println(minHeap.remove());
        }
    }


}
