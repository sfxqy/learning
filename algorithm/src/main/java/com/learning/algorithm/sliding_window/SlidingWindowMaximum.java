package com.learning.algorithm.sliding_window;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sfx
 * @Description
 */
public class SlidingWindowMaximum {

  Integer[] heap = null;

  public static void main(String[] args) {

    SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
    int[] ints = slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    for (int i = 0; i < ints.length; i++) {
      System.out.println(ints[i]);
    }
  }


  public int[] maxSlidingWindow(int[] nums, int k) {
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    int[] resultArray = new int[nums.length - k+1];
    for (int i=0;i<k;i++){
      while (!deque.isEmpty()&&nums[deque.getLast()]<nums[i]){
        deque.removeLast();
      }
      deque.addLast(i);
    }
    resultArray[0]=nums[deque.getFirst()];
    for (int i=k;i<nums.length;i++){
      if (!deque.isEmpty()&&deque.getFirst()==i-k){
        deque.removeFirst();
      }
      while (!deque.isEmpty()&&nums[deque.getLast()]<nums[i]){
        deque.removeLast();
      }
      deque.addLast(i);
      resultArray[i-k+1]=nums[deque.getFirst()];
    }

    return resultArray;

  }



  public int[] maxSlidingWindow1(int[] nums, int k) {
    heap = new Integer[k];
    int[] ints = new int[nums.length-k+1];

    for (int i=0;i<k;i++){
      heap[i]=nums[i];
    }

    Arrays.sort(heap, Collections.reverseOrder());
    ints[0]=heap[0];
    int index=1;
    for (int i=k-1;i<nums.length-k;i++){
      ints[index]=pop();
      add(nums[i+1]);
      index++;
    }
    return ints;
  }


  public void add(int data){
    heap[heap.length-1]=data;
    int index=heap.length-1;
    while (heap[index]>heap[index/2]){
      int temp = heap[index/2];
      heap[index/2]=heap[index];
      heap[index]=temp;
      index=index/2;
    }

  }

  public int pop(){
    int result = heap[0];
    heap[0]=heap[heap.length-1];
    int index = 0;
    while (index<=heap.length-1&&(heap[index]<heap[2*index+1]||heap[index]<heap[2*index+2])){
      int maxIndex=index;
      if (heap[index]<heap[2*index+1]){
        maxIndex=2*index+1;
      }
      if (heap[index]<heap[2*index+2]&&heap[2*index+1]<heap[2*index+2]){
        maxIndex=2*index+2;
      }
      int temp=heap[index];
      heap[index]=heap[maxIndex];
      heap[maxIndex]=temp;
    }
    return result;
  }







}
