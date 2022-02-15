package com.learning.algorithm.other;

/**
 * @author sfx
 * @Description leetcode 2
 */
public class AddTwoNumbers {


  public static void main(String[] args) {
    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
    ListNode listNode1 = new ListNode(2);
    ListNode listNode2 = new ListNode(4);
    ListNode listNode3 = new ListNode(3);
    ListNode listNode4 = new ListNode(5);
    ListNode listNode5 = new ListNode(6);
    ListNode listNode6 = new ListNode(4);
    listNode1.next=listNode2;
    listNode2.next=listNode3;
    listNode4.next=listNode5;
    listNode5.next=listNode6;
    ListNode listNode = addTwoNumbers.addTwoNumbers(listNode1,listNode4);
    while (listNode.next!=null){
      System.out.println(listNode.val);
      listNode=listNode.next;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry=0;
    ListNode rootNode = new ListNode(0);
    ListNode listNode=rootNode;
    while (l1!=null||l2!=null||carry!=0){
      int v1=0,v2=0;
      if (l1!=null){
        v1=l1.val;
        l1=l1.next;
      }
      if (l2!=null){
        v2=l2.val;
        l2=l2.next;
      }
      int v=v1+v2+carry;
      int c=v%10;
      carry=v/10;

      ListNode listNode1=new ListNode(c);
      listNode.next=listNode1;
      listNode=listNode1;

    }
    return rootNode.next;
  }
}

class ListNode {

  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}