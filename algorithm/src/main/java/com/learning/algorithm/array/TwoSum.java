package com.learning.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sfx
 * @Description:
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {


  public static void main(String[] args) {

  }
  public int[] twoSum(int[] nums, int target) {
    Map<Integer,Integer> map=new HashMap<>();
    int n=0;
    int[] array=new int[2];
    for(int i=0;i<nums.length;i++){
      n=target-nums[i];
      Integer val=Integer.valueOf(n);
      if(map.containsKey(val)){
        if (i>map.get(val)){
          array[0]=map.get(val);
          array[1]=i;
        }else {
          array[0]=i;
          array[1]=map.get(val);
        }
        return array;
      }
      map.put(nums[i],i);
    }
    return null;

  }
}
