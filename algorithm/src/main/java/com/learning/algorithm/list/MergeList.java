package com.learning.algorithm.list;

/**
 * @author sfx
 * @Description
 */
public class MergeList {


  public static void main(String[] args) {
    ListNode listNode2 = new ListNode(4, null);
    ListNode listNode3 = new ListNode(2, listNode2);
    ListNode listNode4 = new ListNode(1, listNode3);
    ListNode listNode21 = new ListNode(4, null);
    ListNode listNode31 = new ListNode(3, listNode21);
    ListNode listNode41 = new ListNode(1, listNode31);

    ListNode r = new ListNode();
    ListNode t = new ListNode(0, null);
    MergeList mergeList = new MergeList();
    ListNode listNode = mergeList.mergeTwoLists(listNode41, listNode4);
    while (listNode != null) {
      System.out.print(listNode.val + "->");
      listNode = listNode.next;
    }
  }


  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode sentinel = new ListNode(-1);
    ListNode root = sentinel;
    while (list1 != null && list2 != null) {
      if (list1 != null && list1.val < list2.val) {
        sentinel.next = list1;
        sentinel = list1;
        list1 = list1.next;
      } else if (list2 != null && list1.val >= list2.val) {
        sentinel.next = list2;
        sentinel = list2;
        list2 = list2.next;
      }
     /* if (list1 == null) {
        sentinel.next = list2;
      }
      if (list2 == null) {
        sentinel.next = list1;
      }*/
      sentinel.next = (list1 == null) ? list2 : list1;
    }
    return root.next;
  }
}


