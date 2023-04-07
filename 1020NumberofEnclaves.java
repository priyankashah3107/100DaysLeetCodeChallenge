/*
 1020. Number of Enclaves
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

 

Example 1:Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
Example 2:

Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.

 */

 // Tc: m*n
// SC : m*n
class Solution {

    int[][] dir = new int[][] {{-1,0}, {0, -1}, {1,0}, {0,1}};
    private void helper(int[][] grid, int i, int j, int m, int n) {
        if( i<0 || j<0 || i>=m || j>=n || grid[i][j] ==0) {
            return;

        }
        grid[i][j] = 0;
        for (int[] d: dir) {
            helper(grid, i+d[0] , j+ d[1], m, n);

        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i =0; i<m; i++) {
            for (int j =0 ; j<n; j++) {
                if ( i== 0 || j== 0 || i == m-1 || j == n-1) {
                    helper(grid , i, j, m, n);
                    
                }
            }
        }
        int count = 0;
        for (int i =0; i<m; i++) {
            for ( int j =0; j < n; j++) {
                if (grid [i][j] ==1) {
                    count++;

                }
            }
        }
        return count;
        
    }
}