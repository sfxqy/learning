package com.learning.algorithm.binary_tree;


import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author SFX
 * @apiNote
 * @date 2022/9/19 9:45
 * 94. 二叉树的中序遍历
 **/

public class InorderTraversal {


    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        TreeNode treeNode1 = new TreeNode(1,null,null);
        TreeNode treeNode2 = new TreeNode(2,treeNode1,null);
        TreeNode treeNode3 = new TreeNode(3,null,null);
        TreeNode treeNode4 = new TreeNode(4,treeNode2,treeNode3);
        List<Integer> integers = inorderTraversal.inorderTraversal(treeNode4);

        List<Integer> integers2 = inorderTraversal.inorderTraversal2(treeNode4);
        System.out.printf("");
  //      System.out.println(StringUtils.join(integers,","));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        formate(root,result);
        return result;
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        formate1(root,result);
        return result;
    }


    /**
     * 递归方式
     * @param root
     * @param nodeList
     */
    public void formate(TreeNode root, List<Integer> nodeList){
        if (root == null){
            return;
        }
        formate(root.left,nodeList);
        nodeList.add(root.val);
        formate(root.right,nodeList);
    }




    public void formate1(TreeNode root, List<Integer> nodeList){
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.addLast(root);
                root = root.left;
            }
            root = stack.pollLast();
            nodeList.add(root.val);
            root = root.right;
        }

    }
}
