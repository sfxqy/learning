package com.learning.algorithm.binary_tree;

/**
 * @author SFX
 * @apiNote
 * @date 2022/9/20 10:33
 * 96. 不同的二叉搜索树
 */

public class NumTrees {


    public static void main(String[] args) {

        NumTrees numTrees = new NumTrees();

        int calculate = numTrees.numTrees( 3);

        System.out.println("result："+calculate);
    }


    public int numTrees(int n) {
        NumTrees numTrees = new NumTrees();
         numTrees.calculate(0,n);
        return a;
    }


    int a= 1;
    public void calculate(int left, int right) {
        int base = left;

        int count = 1;
        for (int i=left;i<right;i++){
            if (base<i){
                count++;
            }
            if (i<right){
                count++;
            }

            a*=count;
            if (base<i){
                calculate( base, i-1);
            }
            if (i<right){
                calculate( i+1, right);
            }


        }

    }


}
