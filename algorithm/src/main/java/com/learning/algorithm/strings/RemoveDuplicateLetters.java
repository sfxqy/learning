package com.learning.algorithm.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author sfx
 * @Description
 */
public class RemoveDuplicateLetters {


  public static void main(String[] args) {
    RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
  //  System.out.println(removeDuplicateLetters.removeDuplicateLetters("bcabc"));
    System.out.println(removeDuplicateLetters.removeDuplicateLetters1("bcabc"));
  }


  public String removeDuplicateLetters(String s) {
    if (null == s || s.length() == 0) {
      return "";
    }
    int[] array = new int[26];
    for (char c : s.toCharArray()) {
      array[c - 'a']++;
    }
    int position = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(position) > s.charAt(i)) {
        position = i;
      }
      if (--array[s.charAt(i) - 'a'] == 0) {
        break;
      }
    }

    return s.charAt(position) + removeDuplicateLetters(
        s.substring(position + 1).replaceAll(String.valueOf(s.charAt(position)), ""));
  }



  public String removeDuplicateLetters1(String s) {
    Stack<Character> stack = new Stack<>();
    HashSet<Character> seenSet = new HashSet<>();
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i=0;i<s.length();i++){
      map.put(s.charAt(i),i);
    }

    for (int i=0;i<s.length();i++){
      char c = s.charAt(i);
      if (!seenSet.contains(c)){
        while (!stack.isEmpty()&&stack.peek()>c&&map.get(stack.peek())>i){
          seenSet.remove(stack.pop());
        }
        seenSet.add(c);
        stack.push(c);
      }
    }

    StringBuilder str = new StringBuilder();
    int size = stack.size();
   /* for (int i=0;i<size;i++){
      str.append(stack.pop());
    }*/
    for (Character c:stack){
      str.append(c);
    }
    return str.toString();
  }

}
