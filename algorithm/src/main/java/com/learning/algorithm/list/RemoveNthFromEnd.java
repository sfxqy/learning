package com.learning.algorithm.list;

/**
 * @author sfx
 * @Description
 */
public class RemoveNthFromEnd {


  public static void main(String[] args) {
    RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
    ListNode listNode6 = new ListNode(5,null);
    ListNode listNode1 = new ListNode(4,listNode6);
    ListNode listNode2 = new ListNode(3,listNode1);
    ListNode listNode3 = new ListNode(2,listNode2);
    ListNode listNode4 = new ListNode(1,null);
    ListNode listNode = removeNthFromEnd.removeNthFromEnd(listNode4, 1);
    while (listNode != null) {
      System.out.println(listNode.val + "->");
      listNode = listNode.next;
    }
  }


  public ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode root = new ListNode();
    root.next = head;
    ListNode first=root,second=root;
    for(int i=0;i<n+1;i++){
      first=first.next;
    }

    while(first!=null){
      first=first.next;
      second=second.next;
    }
    second.next=second.next.next;
    return root.next;

  }


  public ListNode removeNthFromEnd1(ListNode head, int n) {
    ListNode sentinel = new ListNode(-1);
    sentinel.next = head;
    ListNode first = sentinel, second = sentinel;
    for ( int i = 0; i < n + 1; i++ ){
      first = first.next;
    }
    while ( first != null ){
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    return sentinel.next;


  }

}
