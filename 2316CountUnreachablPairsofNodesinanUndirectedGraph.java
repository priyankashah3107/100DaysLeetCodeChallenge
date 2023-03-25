/*
 2316. Count Unreachable Pairs of Nodes in an Undirected Graph

 You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.

Return the number of pairs of different nodes that are unreachable from each other.

 

Example 1:
Input: n = 3, edges = [[0,1],[0,2],[1,2]]
Output: 0
Explanation: There are no pairs of nodes that are unreachable from each other. Therefore, we return 0.
Example 2:
Input: n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
Output: 14
Explanation: There are 14 pairs of nodes that are unreachable from each other:
[[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]].
Therefore, we return 14.
 */

 // Approach nodes*(nodes-1)) /2;
// TC: O(n)
// SC: O(h)

class Solution {
    List<List<Integer>> adj;
    boolean vis[];
    public long countPairs(int n, int[][] edges) {
        adj = new ArrayList<>();
        vis = new boolean[n];

        for (int i = 0; i<n; i++) 
        adj.add(new ArrayList<>());

        for (int edge[] : edges) {
            int a = edge[0];
            int b = edge[1];

            adj.get(a).add(b);
            adj.get(b).add(a);

        }

        long total = ((long) n * (n-1)) /2;
        for (int i=0; i<n; i++) {
            if(!vis[i]) {
               int nodes = dfs(i);
               long pairs = ((long)nodes*(nodes-1)) /2;
               total -= pairs;

            }
        }
        return total;
    }

    int dfs(int u) {
        vis[u] = true;
        int count = 1;
        for (int v : adj.get(u)) {
            if(!vis[v]) 
            count+= dfs(v);
        }
        return count;
    }
}