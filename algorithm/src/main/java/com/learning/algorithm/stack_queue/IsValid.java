package com.learning.algorithm.stack_queue;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author sfx
 * @Description   20
 */
public class IsValid {


  public static void main(String[] args) {
    IsValid isValid = new IsValid();
    System.out.println(isValid.isValid("{]}"));
  }


  public boolean isValid(String s) {

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(')');
      } else if (c == '[') {
        stack.push(']');
      } else if (c == '{') {
        stack.push('}');
      } else {
        if (stack.isEmpty() || stack.pop() != c) {
          return false;
        }
      }
    }
    if (!stack.isEmpty()) {
      return false;
    } else {
      return true;
    }

  }



  public boolean isValid1(String s) {
    if (s.length()%2!=0)return false;


    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(')');
      } else if (c == '[') {
        stack.push(']');
      } else if (c == '{') {
        stack.push('}');
      } else {
        if (stack.isEmpty() || stack.pop() != c) {
          return false;
        }
      }
    }
    if (!stack.isEmpty()) {
      return false;
    } else {
      return true;
    }

  }


}
