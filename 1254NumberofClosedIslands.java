/*
 1254. Number of Closed Islands
 Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

 

Example 1:

Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).
Example 2:
Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1
Example 3:

Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2
 */

 // Step 1 find land using grid [i][j] = 0;
// step 2. land -> check -> direction -> 1 (water)
// if both condition true the island find
// conditions:
// top =  i-1 , j
 // down  = i +1, j
 // left  = i, j-1;
 // right = i, j+1;
 
// TC: m *n
// SC: m*n

class Solution {
    int [][] dir = new int[][] {{-1,0}, {0,-1}, {1,0}, {0,1}};
    private boolean helper(int[][] grid, int i, int j, int m , int n) {
        if (i<0 || j< 0 || i>= m || j>= n) {
            return false;
        } 
        if (grid[i][j]  == 1) {
            return true;
  
        }
  
        grid[i][j] = 1;
        boolean land = true;
        for (int[] d: dir) {
            land = land & helper(grid, i + d[0], j +d[1] , m ,n);
  
        }
        return land;
  
    }
  
      public int closedIsland(int[][] grid) {
          int m = grid.length;
          int n = grid[0].length;
          int noIsLand = 0;
          for (int i =0; i<m; i++) {
              for (int j =0; j< n; j++) {
                  if(grid[i][j] == 0 && helper(grid, i, j, m, n)) {
                      noIsLand++;
  
                  }
              }
          }
          return noIsLand;
      }
  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  