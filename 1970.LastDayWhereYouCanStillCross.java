/*
 1970. Last Day Where You Can Still Cross

 There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col representing the number of rows and columns in the matrix, respectively.

Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water. You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).

You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four cardinal directions (left, right, up, and down).

Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.

 

Example 1:


Input: row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]
Output: 2
Explanation: The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 2.
Example 2:


Input: row = 2, col = 2, cells = [[1,1],[1,2],[2,1],[2,2]]
Output: 1
Explanation: The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 1.
Example 3:


Input: row = 3, col = 3, cells = [[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]
Output: 3
Explanation: The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 3.
 

Constraints:

2 <= row, col <= 2 * 104
4 <= row * col <= 2 * 104
cells.length == row * col
1 <= ri <= row
1 <= ci <= col
All the values of cells are unique.
 */

 class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        // binary search 
        int[][] grid = new int[row][col];
        int[][] visited = new int [row][col];
        int l =0, r = cells.length-1;
        int days = 0;
        while (l<=r) {
            int mid = (l+r) /2;
            fillTheGrid(grid, cells, 0, mid);
            boolean isPossible = false;
            for (int i=0; i<col; i++) {
                isPossible = isPossible || check(0,i,row,col,grid,visited);
                visited = new int[row][col];
                if(isPossible)break;

            }
            if(isPossible) {
                days = Math.max(days, mid+1);
                l = mid+1;

            } else {
                unfillThegrid(grid, cells, 0, mid);
                r = mid-1;
            }
        }
        return days;
    }
    private boolean check(int i, int j, int row, int col, int[][] grid, int[][] visited) {
        if(i<0 || i>= row || j<0 || j>= col || grid[i][j] ==1 || visited[i][j] ==1) {
            return false;
        }
        if(i== row-1) {
            return true;
        }
        int[] x = new int[] {1,-1,0,0};
        int[] y = new int[] {0,0,1,-1};
        visited[i][j] = 1;
        boolean isPossible = false;
        for (int itr = 0; itr<4; itr++) {
            int tempX = i + x[itr];
            int tempY = j + y[itr];
            if(!(tempX <0 || tempX >= row || tempY < 0 || tempY >= col )) {
                isPossible = isPossible || check(tempX, tempY, row, col, grid, visited);

            }
            if(isPossible) {
                return true;
            }
        }
        return false;
    }

    private void fillTheGrid(int[][] grid, int[][] cells, int start, int end) {
        for (int i = start; i<=end; i++) {
            grid[cells[i][0]-1][cells[i][1]-1] = 1;

        }
    }

    private void unfillThegrid(int[][] grid, int[][] cells, int start, int end) {
        for (int i = start; i<= end; i++) {
            grid[cells[i][0] -1] [cells[i][1]-1] = 0;

        }
    }
}