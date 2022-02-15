package com.learning.algorithm.list;

/**
 * @author sfx
 * @Description
 */
public class Test {


  public static void main(String[] args) {
    System.out.println(2<<6);
  }
  public int singleNumber(int[] nums) {
    int result = 0;
    for(int i=0;i<nums.length;i++){
      result ^= nums[i];
    }
    return result;

  }
}
