package com.learning.algorithm.array;

/**
 * @author sfx
 * @Description
 */
public class SearchMatrix {


  public static void main(String[] args) {

    SearchMatrix searchMatrix = new SearchMatrix();
    int[][] a = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    System.out.println(searchMatrix.searchMatrix(a, 3));
  }

  //   1 3 5 7 10 11 16 20 23 30 34 60


  public boolean searchMatrix(int[][] matrix, int target) {
    int min = matrix[0][0], max = matrix[matrix.length - 1][matrix[0].length - 1];
    if (matrix.length == 0) {
      return false;
    }
    if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
      return false;
    }
    if (target == matrix[0][0] || target == matrix[matrix.length - 1][matrix[0].length - 1]) {
      return true;
    }
    int l = 0, r = matrix.length * matrix[0].length - 1;
    while (l <= r) {
      int mid = (l + r) / 2;
      int n = mid / matrix[0].length;
      int m = mid % matrix[0].length;
      int value = matrix[n][m];
      if (value > target) {
        r = mid-1;
      } else if (value < target) {
        l = mid+1;
      } else {
        System.out.println("n:" + n + "\t m:" + m);
        return true;
      }
    }
    return false;
  }
}
