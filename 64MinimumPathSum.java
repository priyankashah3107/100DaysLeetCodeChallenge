/*
 64. Minimum Path Sum
 Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 */

 class Solution {
    public int minPathSum(int[][] grid) {
      if(grid == null || grid.length ==0) 
      return 0;
      int m = grid.length, n= grid[0].length;
      int[][] result = new int[m][n];
      result[m-1][n-1] = grid[m-1][n-1];
      // Value of last column
      if(m>1) {
          for (int i = m-2; i>=0; i--) {
              result[i][n-1] = grid[i][n-1] + result[i+1][n-1];

          }
      }  
      // Value of last row
      if (n>1) {
          for (int j= n-2; j>=0; j--) {
              result[m-1][j] = grid[m-1][j] + result[m-1][j+1];

          }
      }
      // this is rest of the code for right and down move.
      for (int i=m-2; i>=0; i--) {
          for(int j = n-2; j>=0; j--) {
              result[i][j] = grid[i][j] + Math.min(result[i+1][j], result[i][j+1]);
          }
      }
      return result [0][0];
    }
}