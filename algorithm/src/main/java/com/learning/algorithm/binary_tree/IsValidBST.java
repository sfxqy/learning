package com.learning.algorithm.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SFX
 * @apiNote
 * @date 2022/9/21 9:41
 * <p>
 * 98. 验证二叉搜索树
 */

public class IsValidBST {


    public static void main(String[] args) {
      /*  TreeNode treeNode1 = new TreeNode(7, null, null);
        TreeNode treeNode2 = new TreeNode(3, null, null);
        TreeNode treeNode3 = new TreeNode(6, treeNode2, treeNode1);
        TreeNode treeNode4 = new TreeNode(4, null, null);

        TreeNode root = new TreeNode(5, treeNode4, treeNode3);

        TreeNode treeNode3 = new TreeNode(1, null, null);
        TreeNode treeNode4 = new TreeNode(4, null, null);

        TreeNode root = new TreeNode(0, null, treeNode3);

        [32,26,47,19,null,null,56,null,27]
        [32,26,47,19,null,null,56,null,27]
*/

        TreeNode treeNode1 = new TreeNode(27, null, null);
        TreeNode treeNode2 = new TreeNode(56, null, treeNode1);
        TreeNode treeNode3 = new TreeNode(19, null, null);
        TreeNode treeNode4 = new TreeNode(26, treeNode3, null);
        TreeNode treeNode5 = new TreeNode(47, null, treeNode2);
        TreeNode root = new TreeNode(32, treeNode4, treeNode5);
        IsValidBST isValidBST = new IsValidBST();
        boolean validBST2 = isValidBST.isValidBST(root);
        List<Integer> list = new ArrayList<>();
        isValidBST.isValidBST1(root,list);
        System.out.println("result:" + validBST2);
    }

    Integer num = null;


    public boolean isValidBST(TreeNode root) {
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        while (root!=null || !treeNodes.isEmpty()) {
            while (root != null){
                treeNodes.add(root);
                root = root.left;
            }

        //    System.out.printf("-------"+num+"\t");
            TreeNode treeNode = treeNodes.pollLast();
            if (num==null){
                num = treeNode.val;
            }else {
                if (num< treeNode.val){
                    num = treeNode.val;
                }else {
                    return false;
                }
            }
            root = treeNode.right;
        }
        return true;
    }



    Integer n = null;

    public boolean isValidBST1(TreeNode root) {
        if (root!=null){
            boolean validBST1 = isValidBST1(root.left);
            if (!validBST1){
                return false;
            }
            if (n==null){
                n= root.val;
            }else {
                if (n< root.val){
                    n=root.val;
                }else {
                    return false;
                }
            }
            boolean validBST11 = isValidBST1(root.right);
            if (!validBST11){
                return false;
            }
        }
        return true;
    }




}
