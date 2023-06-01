/*
1091. Shortest Path in Binary Matrix.

Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

 

Example 1:


Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:


Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1

 */

 class Solution {
    static class Node {
        int x;
        int y;
        int dist;
        Node (int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if(grid[0][0] ==1 || grid[row-1][col-1] ==1) {
            return -1;
        }

        int[][] direction = {{0,1}, {1,0}, {-1,0}, {0,-1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0,1));
        grid[0][0] = 1;
        while(!queue.isEmpty()) {
           int size = queue.size();
           for (int i=0; i<size; i++) {
               Node temp = queue.poll();
               int x = temp.x;
               int y = temp.y;
               int cost = temp.dist;
            
            if(x == row-1 && y==col-1)
            return cost;
            
            for (int[] way: direction) {
                int nextX = x + way[0];
                int nextY = y + way[1];
                if (nextX >= 0 && nextX < row && nextY >=0 && nextY < col && grid[nextX][nextY] ==0) {
                    queue.add(new Node (nextX, nextY, cost +1));
                    grid[nextX][nextY] =1;

                }
            }
           }
        }
        return -1;
    }
}