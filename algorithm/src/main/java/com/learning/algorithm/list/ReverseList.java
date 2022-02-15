package com.learning.algorithm.list;


import java.util.List;

/**
 * @author sfx
 * @Description
 */
public class ReverseList {


  public static void main(String[] args) {

    //  [1,2,3,4,5]
    int[] a = new int[]{1};
    ListNode listNode6 = new ListNode(5,null);
    ListNode listNode1 = new ListNode(4,listNode6);
    ListNode listNode2 = new ListNode(3,listNode1);
    ListNode listNode3 = new ListNode(2,listNode2);
    ListNode listNode4 = new ListNode(1,listNode3);

      ReverseList reverseList = new ReverseList();

    ListNode listNode = reverseList.reverseList(listNode4);
    while (listNode.next != null) {
      System.out.println(listNode.val + "->");
      listNode = listNode.next;
    }
  }

  public ListNode reverseList(ListNode head) {
    ListNode point = new ListNode();
    ListNode root ;
    root=head;
    while (head!=null){
      if (root==head){
        root = new ListNode();
        root.val=head.val;
        head=head.next;
      }else {
        root = new ListNode(head.val, root);
        head=head.next;
      }

    }
    return root;


  }
}

class ListNode {

  Integer val;
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
