package com.learning.algorithm.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author sfx
 * @Description
 */
public class LongestConsecutive {


  public static void main(String[] args) {
    LongestConsecutive longestConsecutive = new LongestConsecutive();
    System.out.println(longestConsecutive.longestConsecutive(new int[]{01}));

  }

  public int longestConsecutive(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    int max=0;
    for (int i=0;i<nums.length;i++){
      set.add(nums[i]);
    }
    for (int i=0;i<nums.length;i++){
      int num = nums[i];
      int max1=0;
      if (!set.contains(num-1)){
        while (set.contains(num)){
          max1++;
          num++;
        }

      }
      if (max<max1){
        max=max1;
      }
    }

    return max;
  }

}
