package com.learning.algorithm.array;

import java.util.Arrays;

/**
 * @author sfx
 * @Description
 */
public class NextPermutaion {


  public static void main(String[] args) {
    int[] nums = new int[]{5,1,1};
    NextPermutaion nextPermutaion = new NextPermutaion();
    nextPermutaion.nextPermutation(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + "\t");
    }

  }

  //1 2 5 4
  public void nextPermutation(int[] nums) {
    int point = nums.length - 2;
    while (point >= 0 && nums[point] >= nums[point + 1]) {
      point--;
    }
    if (point == -1) {
      Arrays.sort(nums);
    } else {
      int x = point + 2;
      while (x < nums.length  && nums[x] > nums[point]) {
        x++;
      }
      int temp = nums[point];
      nums[point] = nums[x - 1];
      nums[x - 1] = temp;
      int l = point + 1, r = nums.length - 1;
      while (l < r) {
        int t = nums[r];
        nums[r] = nums[l];
        nums[l] = t;
        l++;
        r--;
      }
    }


  }

}
