package com.learning.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sfx
 * @Description
 */
public class FourSum {


  public static void main(String[] args) {
    FourSum fourSum = new FourSum();
    System.out.println(fourSum.fourSum(new int[]{-3,-1,0,2,4,5},0));
  }


  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    int left = 0, right = nums.length - 1;
    while ((left + 3) <= right) {
      int l = left + 1, r = right - 1;
      int dif = target - nums[left] - nums[right];

      while (l < r) {
        if (dif == (nums[l] + nums[r])) {
          result.add(Arrays.asList(nums[left], nums[l], nums[r], nums[right]));
          if (nums[l] != nums[l + 1]){
            l++;
          }else {
            while (nums[l] == nums[l + 1]&&l<r) {
              l++;
            }
          }
          if (nums[r]!=nums[r-1]&&r>=l){
            r--;
          }else {
            while (nums[r] == nums[r - 1]&&r>l) {
              r--;
            }
          }
        } else {
          if ((nums[l] + nums[r]) < dif) {
            l++;
          } else {
            r--;
          }

        }

      }
      left++;
      right--;

    }
    return result;
  }
}
