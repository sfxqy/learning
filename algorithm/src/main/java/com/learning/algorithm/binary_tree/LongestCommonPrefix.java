package com.learning.algorithm.binary_tree;

/**
 * @author SFX
 * @apiNote
 * @date 2022/9/23 10:22
 */

public class LongestCommonPrefix {


    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] s=new String[]["ab", "a"]
        String s = longestCommonPrefix.longestCommonPrefix();
        System.out.printf(s);
    }



    public String longestCommonPrefix(String[] strs) {
        char[] chars = strs[0].toCharArray();
        int index = 0;
        if (strs.length==1){
            return strs[0];
        }
        ok :for(int i=0;i<chars.length;i++){

            for(int j=1;j<strs.length;j++){
                if(chars[i]==strs[j].charAt(i)){
                    continue;
                }else {
                    index = i;
                    break ok;
                }
            }
        }
        return strs[0].substring(0,index);
    }
}
