/*
 * 2360. Longest Cycle in a Graph
 * You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.

The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i]. If there is no outgoing edge from node i, then edges[i] == -1.

Return the length of the longest cycle in the graph. If no cycle exists, return -1.

A cycle is a path that starts and ends at the same node.

 

Example 1:


Input: edges = [3,3,4,2,3]
Output: 3
Explanation: The longest cycle in the graph is the cycle: 2 -> 4 -> 3 -> 2.
The length of this cycle is 3, so 3 is returned.
Example 2:

Input: edges = [2,-1,3,1]
Output: -1
Explanation: There are no cycles in this graph.
 */

 class Solution {
    public int longestCycle(int[] edges) {
        int maxCycleLength = -1;
        boolean[] visited =  new boolean[edges.length];
        int[] indexInCurrentPath = new int[edges.length];

        for (int i = 0; i<edges.length; i++) {
            if (!visited[i]) {
                maxCycleLength = Math.max(maxCycleLength, dfs(edges, visited, indexInCurrentPath , i, i));

            }
        }
        return maxCycleLength;


    }

    int dfs(int[] edges, boolean[] visited, int[] indexInCurrentPath, int src, int parent) {
        if (src == -1) {
            return -1;
        }
        if(visited[src]) {
            if (indexInCurrentPath[src] == 0) {
                return -1;
            }
            else {
                return indexInCurrentPath[parent] - indexInCurrentPath[src] +1;

            }
        }
        else {
            visited[src] = true;
            indexInCurrentPath[src] = indexInCurrentPath[parent] +1;

            int maxCycleLength = dfs(edges, visited, indexInCurrentPath, edges[src], src);

            indexInCurrentPath[src] = 0;

            return maxCycleLength;
            

        }
    }
}
