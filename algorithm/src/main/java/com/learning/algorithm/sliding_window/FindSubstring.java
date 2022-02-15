package com.learning.algorithm.sliding_window;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author sfx
 * @Description
 */
public class FindSubstring {

  public static void main(String[] args) {

  }
  public List<Integer> findSubstring(String s, String[] words) {
    HashMap<Character, List<Integer>> map = new HashMap<>();
    for (int i=0;i<words.length;i++){
      char c = words[i].charAt(0);
      if (map.containsKey(c)){
        List<Integer> list = map.get(c);
        list.add(i);
      }else {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        map.put(c,list);
      }
    }
    int step = words[0].length();
    int l=0,r=0;
   /* while (l<r){
      s.charAt(l)
      if ()

    }*/

    return null;
  }
}
