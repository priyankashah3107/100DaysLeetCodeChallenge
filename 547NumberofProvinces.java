/*
 547. Number of Provinces

 There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 */

 class Solution {
    public void dfs(int[][] graph, int i) {
        graph[i][i] = 0;
        for (int j=0; j<graph.length; j++) {
            if(graph[i][j] ==1) {
                graph[i][j] =0;
                if(graph[j][j] ==1) {
                    dfs(graph,j);
                }
            }
        }
    }
    public int findCircleNum(int[][] graph) {
        int ans =0;
        int n = graph.length;
        for (int i=0; i<n; i++) {
            if(graph[i][i] ==0) continue;
            ans++;
            dfs(graph,i);
        }
        return ans;
    }
}
