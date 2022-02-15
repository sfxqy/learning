package com.learning.algorithm.sliding_window;

import java.util.HashMap;

/**
 * @author sfx
 * @Description leetcode:3
 */
public class LengthOfLongestSubstring {

  public static void main(String[] args) {
    LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
    System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("aabaab!bb"));
  }


  public int lengthOfLongestSubstring(String s) {
    int maxLength = 0;
    int l = 0, r = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    while (r < s.length()) {
      char c = s.charAt(r);
      if (!map.containsKey(c)) {
        map.put(c, 1);
        if (maxLength < map.size()) {
          maxLength = map.size();
        }
      } else {
        while (l < r) {
          if (s.charAt(l) == c) {
            l++;
            break;
          } else {
            map.remove(s.charAt(l));
          }
          l++;
        }
      }
      r++;
    }
    return maxLength;
  }
}
