/* 1857. Largest Color Value in a Directed Graph
There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.

You are given a string colors where colors[i] is a lowercase English letter representing the color of the ith node in this graph (0-indexed). You are also given a 2D array edges where edges[j] = [aj, bj] indicates that there is a directed edge from node aj to node bj.

A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge from xi to xi+1 for every 1 <= i < k. The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.

Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.

 

Example 1:



Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
Output: 3
Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a" (red in the above image).
Example 2:



Input: colors = "a", edges = [[0,0]]
Output: -1
Explanation: There is a cycle from 0 to 0.
 

Constraints:

n == colors.length
m == edges.length
1 <= n <= 105
0 <= m <= 105
colors consists of lowercase English letters.
0 <= aj, bj < n
 */


 // TC : O(N+E)
// SC: O(N+E)

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[]  inDegree = new int[n];
        for (int[] e : edges) {
            graph.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            inDegree[e[1]]++;

        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i<n; i++) {
            if(inDegree[i] ==0 ) {
                q.offer(i);

            }
        }

        int[][] colorDp = new int[n][26];
        int visited = 0, ans =1;
        while (!q.isEmpty()) {
            int node = q.poll();
            int color = colors.charAt(node) - 'a';
            colorDp[node][color]++;
            visited++;
            ans = Math.max(ans, colorDp[node][color]);
            if(!graph.containsKey(node)) {
                continue;
            }

            for (int nextNode : graph.get(node)) {
                for (int i =0; i<26; i++) {
                    colorDp[nextNode][i] = Math.max(colorDp[node][i], colorDp[nextNode][i]);

                }
                inDegree[nextNode]--;
                if(inDegree[nextNode] == 0) {
                    q.offer(nextNode);
                }
            }
        }
        return visited < n ? -1 : ans;
    }
} 
