package com.learning.algorithm.array;

/**
 * @author sfx
 * @Description
 */
public class RotateImage {

  public static void main(String[] args) {
    int[][] image=new int[][]{
        {1,2,3},
        {4,5,6},
        {7,8,9}
    };
    int[][] image1=new int[][]{
        {1,4,7},
        {2,5,8},
        {3,6,9}
    };

    int[][] image8=new int[][]{
        {1,2,3},
        {4,5,6},
        {7,8,9}
    };
    int[][] image3=new int[][]{
        {7,4,1},
        {8,5,2},
        {9,6,3}
    };



    int[][] image4=new int[][]{
        {1 ,2 ,3 ,4},
        {5 ,6 ,7 ,8},
        {9 ,10,11,12},
        {13,14,15,16}
    };
    int[][] image51=new int[][]{
        {1 ,5 ,9  ,13},
        {2 ,6 ,10 ,14},
        {3 ,7 ,11 ,15},
        {4 ,8 ,12 ,16}
    };
    int[][] image35=new int[][]{
        {7,4,1},
        {8,5,2},
        {9,6,3}
    };
    RotateImage rotateImage = new RotateImage();
    rotateImage.mathImage(image4);
  }


  public void mathImage(int[][] image){
    int l = image.length;
    //获得转置矩阵
    for (int i=0;i<l;i++){
      for (int j=i+1;j<image[i].length;j++){
        int temp=image[i][j];
        image[i][j]=image[j][i];
        image[j][i]=temp;
      }
    }
    int left=0,right=image[0].length-1;
    while (left<right){
      for (int i = 0; i < image.length; i++) {
        int temp=image[i][left];
        image[i][left]=image[i][right];
        image[i][right]=temp;
      }
      left++;
      right--;
    }

    for (int i = 0; i <image.length ; i++) {
      for (int j = 0; j < image[i].length; j++) {
        System.out.print(image[i][j]+"\t");
      }
      System.out.println();
    }
  }

}
