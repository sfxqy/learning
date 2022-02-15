package com.learning.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sfx
 * @Description：双指针法，先将数组排序，然后取基准指针（从第一个开始），然后取左指针和右指针
 *
 *
 *  -2   -1   0   0   1   2   10
 *   ^    l                    r    ->结果大于0，移动左指针
 *   ^        l                r    ->结果大于0，移动左指针
 *   ^            l            r    ->结果大于0，移动左指针
 *   ……
 *   ^                         lr   ->左指针和右指针相遇，结束以-2为基准的查询,移动基准指针
 *        ^   l                 r   ->左指针和右指针相遇，结束以-2为基准的查询
 */
public class ThreeSum {

  public static void main(String[] args) {
    int[] nums=new int[]{0,0,0};

    ThreeSum threeSum = new ThreeSum();
    List<List<Integer>> lists = threeSum.threeSum(nums);
    lists.forEach(x->{
      x.forEach(l->{
        System.out.print(l+"\t");
      });
      System.out.println();
    });
  }

  @SuppressWarnings("all")
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    //核心指针
    for (int i=0;i<nums.length-2;i++){
      if (nums[i]>0){
        break;
      }
      if (i>0&&nums[i]==nums[i-1]){
        continue;
      }
      int left=i+1,right=nums.length-1;
      while (true){
        if (left>=right){
          break;
        }
        int sum=nums[i]+nums[left]+nums[right];
        if (sum==0){
          result.add(Arrays.asList(nums[i],nums[left],nums[right]));
          left++;
          right--;
          while (left<right&&nums[left]==nums[left-1]){
            left++;
          }
          while (left>right&&nums[right]==nums[right+1]){
            right--;
          }
        }else if (sum<0){
          left++;
        }else {
          right--;
        }
      }
    }
    return result;
  }

}
