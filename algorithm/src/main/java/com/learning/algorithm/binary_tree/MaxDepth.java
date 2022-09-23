package com.learning.algorithm.binary_tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SFX
 * @apiNote
 * @date 2022/9/19 11:36
 */

public class MaxDepth {


    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        TreeNode treeNode1 = new TreeNode(1,null,null);
        TreeNode treeNode2 = new TreeNode(2,treeNode1,null);
        TreeNode treeNode3 = new TreeNode(3,null,null);
        TreeNode treeNode4 = new TreeNode(4,treeNode2,treeNode3);
        int i = maxDepth.maxDepth1(treeNode4,0);
        System.out.printf("");
        //      System.out.println(StringUtils.join(integers,","));
    }

    public int maxDepth(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList();
        int count = 0;
        int x=1;
        linkedList.add(root);
        while (!linkedList.isEmpty()){
            int y = x;
            x=0;
            for (int i=0;i<y;i++){
                TreeNode treeNode = linkedList.pollFirst();
                if (treeNode.left!=null){
                    linkedList.addLast(treeNode.left);
                    x++;
                }
                if (treeNode.right!=null){
                    linkedList.addLast(treeNode.right);
                    x++;
                }
            }
            count++;
        }
        return count;
    }








    public int maxDepth1(TreeNode root,int deep) {
        if (root==null){
            return deep;
        }
        int max = Math.max(maxDepth1(root.left,deep+1), maxDepth1(root.right,deep+1));
        return max;
    }
}
