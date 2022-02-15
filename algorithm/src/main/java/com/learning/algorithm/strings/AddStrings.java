package com.learning.algorithm.strings;

/**
 * @author sfx
 * @Description:leetcode 415  字符串相加 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-strings
 */
public class AddStrings {


  public static void main(String[] args) {
    AddStrings addStrings = new AddStrings();
    System.out.println(addStrings.addStrings("129", "9"));
  }


  public String addStrings(String num1, String num2) {
    int l1 = num1.length() - 1;
    int l2 = num2.length() - 1;
    StringBuilder str = new StringBuilder();
    int carry = 0;
    while (l1 >= 0 || l2 >= 0 || carry != 0) {
      int c1 = 0;
      int c2 = 0;
      if (l1 >= 0) {
        c1 = num1.toCharArray()[l1] - '0';
      }
      if (l2 >= 0) {
        c2 = num2.toCharArray()[l2] - '0';
      }
      int i = c1 + c2 + carry;
      if (i >= 10) {
        carry = i / 10;
        i = i % 10;
      } else {
        carry = 0;
      }
      str.append(i);
      l1--;
      l2--;
    }
    return str.reverse().toString();
  }

}
