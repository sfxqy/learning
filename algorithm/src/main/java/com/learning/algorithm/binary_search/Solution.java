package com.learning.algorithm.binary_search;

/**
 * @author sfx
 * @Description
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.findDuplicate(new int[]{1, 3, 4, 2, 2}));
  }



  public int findDuplicate(int[] nums) {
    int fast = 0;
    int slow = 0;
    do {
      fast = nums[nums[fast]];
      slow = nums[slow];
    }while (fast!=slow);
    int befor=0;
    int after=slow;
    while (befor!=after){
      befor=nums[befor];
      after=nums[after];
    }
    return after;
  }
}
