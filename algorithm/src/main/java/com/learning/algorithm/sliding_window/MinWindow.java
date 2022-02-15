package com.learning.algorithm.sliding_window;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author sfx
 * @Description
 */
public class MinWindow {

  public static void main(String[] args) {
    MinWindow minWindow = new MinWindow();
    System.out.println(minWindow.minWindow("ADOBECODEBANC",
        "ABC"));
  }

  public String minWindow(String s, String t) {
    String result = "";
    int left = 0, right = 1;
    Map<Character, Integer> tMap = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
    }
    Map<Character, Integer> subMap = new HashMap<>();
    Integer tCount = 0;
    while (right <= s.length()) {
      char c = s.charAt(right-1);
      if (tMap.containsKey(c)) {
        subMap.put(c, subMap.getOrDefault(c, 0) + 1);
        if (subMap.getOrDefault(c, 0) <= tMap.get(c)) {
          tCount++;
        }

      }
      while (tCount == t.length() && left < right) {
        char c1 = s.charAt(left);
        if (result.equals("") || s.substring(left, right).length() < result.length()) {
          result = s.substring(left, right);
        }
        if (tMap.containsKey(c1)) {
          subMap.put(c1, subMap.get(c1) - 1);
          if (subMap.getOrDefault(c1, 0) < tMap.get(c1)) {
            tCount--;
          }
        }
        left++;
      }
      right++;
    }

    return result;
  }

  public boolean check(Map<Character, Integer> checkMap, Map<Character, Integer> sourceMap) {
    Set<Entry<Character, Integer>> entries = sourceMap.entrySet();
    Iterator<Entry<Character, Integer>> iterator = entries.iterator();
    while (iterator.hasNext()) {
      Entry<Character, Integer> next = iterator.next();
      if (checkMap.getOrDefault(next.getKey(), 0) < next.getValue()) {
        return false;
      }
    }
    return true;
  }
}
