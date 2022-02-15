package com.learning.algorithm.array;

import java.util.Arrays;

/**
 * @author sfx
 * @Description
 */
public class ThreeSumClosest {


  public static void main(String[] args) {

    ThreeSumClosest threeSumClosest = new ThreeSumClosest();
    System.out.println(threeSumClosest.threeSumClosest(new int[]{0,0,0}, 1));
  }


  public int threeSumClosest(int[] nums,int target){
    Arrays.sort(nums);
    int result=0;
   // int closes1=0;
    int difference=0;
    boolean first=true;
    for (int i=0;i<nums.length-2;i++){
      int left=i+1;
      int right=nums.length-1;
      while (left<right){
        int closes=nums[i]+nums[left]+nums[right];
        int dif=Math.abs(closes-target);
        if (first){
          first=false;
          difference=dif;
          result=closes;
        }else {
          if (dif<difference){
            result=closes;
            difference=dif;

          }
        }

        if (closes<target){
          left++;
        }else {
          right--;
        }

      }
    }
    return result;
  }

}
