package com.learning.algorithm.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author sfx
 * @Description
 */
public class FindAnagrams {

  public static void main(String[] args) {
    FindAnagrams findAnagrams = new FindAnagrams();
    findAnagrams.findAnagrams("abacbabc","abc").forEach(x -> {
      System.out.println(x);
    });
  }


  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    HashMap<Character, Integer> pMap = new HashMap<>();
    for (int i = 0; i < p.length(); i++) {
      pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
    }
    int length = p.length();
    int l = 0, r = 0;
    while (l<=s.length()-length){
      char c = s.charAt(l);
      if (!pMap.containsKey(c)){
        l++;
        continue;
      }else {
        r=l+1;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(c,1);
        while (r<l+length){
          char c1 = s.charAt(r);
          Integer num = pMap.getOrDefault(c1, 0);
          int v = map.getOrDefault(c1,0) + 1;
          if (num<v){
            if (pMap.containsKey(c1)){
              l=l+1;
            }else {
              l=r+1;
            }

            break;
          }
          map.put(c1,v);
          r++;
        }
      }
      result.add(l);
      l++;
      while (l+length-1<s.length()){
        char c1 = s.charAt(l-1);
        char c2 = s.charAt(l-1 + length );
        if (c1==c2){
          result.add(l);
          l++;
        }else {
          l=l + length - 1;
          break;
        }
      }
    }
    return result;
  }

}
