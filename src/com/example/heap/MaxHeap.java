package com.example.heap;

import java.util.Arrays;

public class MaxHeap {

    int capacity = 10;
    int size = 0;
    int arr[] = new int[capacity];

    private int getLeftChildIndex(int parentIndex){
        return parentIndex*2+1;
    }
    private int getRightChildIndex(int parentIndex){
        return parentIndex*2+2;
    }
    private int getParentIndex(int childIndex){
        return (childIndex-1)/2;
    }

    private boolean hasParent(int childIndex){
        return (childIndex-1)/2 < size;
    }

    private boolean hasLeftChild(int parentIndex){
        return parentIndex*2+1 < size;
    }

    private boolean hasRightChild(int parentIndex){
        return parentIndex*2+2 < size;
    }

    private int getLeftChild(int parentIndex){
        return arr[getLeftChildIndex(parentIndex)];
    }

    private int getRightChild(int parentIndex){
        return arr[getRightChildIndex(parentIndex)];
    }

    private int getParent(int childIndex){
        return arr[getParentIndex(childIndex)];
    }

    private void swap(int firstIndex, int secondIndex){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }


    private void ensureExtraCapacity(){
        if(size == capacity){
            arr = Arrays.copyOf(arr, capacity*2);
            capacity *= 2;
        }

    }

    public int peek(){
        if(size==0) throw new IllegalStateException();
        int element = arr[0];
        return element;
    }

    public void add(int element){
        ensureExtraCapacity();
        arr[size] = element;
        size++;
        heapifyUp();
    }

    public int remove(){
        int element =arr[0];
        arr[0] = arr[size-1];
        size--;
        heapifyDown();
        return element;
    }

    public void heapifyUp(){
        int index = size-1;
        while(hasParent(index) && getParent(index) < arr[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int greaterChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChild(index) > arr[greaterChildIndex]){
                greaterChildIndex = getRightChildIndex(index);
            }

            if(arr[index] > arr[greaterChildIndex]){
                break;
            }else{
                swap(index, greaterChildIndex);
            }
            index = greaterChildIndex;
        }

    }

    public boolean isEmpty(){
        return size==0;
    }

    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap();
        maxHeap.add(20);
        maxHeap.add(10);
        maxHeap.add(40);
        maxHeap.add(30);
        while(!maxHeap.isEmpty()){
            System.out.println(maxHeap.remove());
        }
    }
}
