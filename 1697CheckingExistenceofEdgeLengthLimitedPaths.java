/*
 1697. Checking Existence of Edge Length Limited Paths
An undirected graph of n nodes is defined by edgeList, where edgeList[i] = [ui, vi, disi] denotes an edge between nodes ui and vi with distance disi. Note that there may be multiple edges between two nodes.

Given an array queries, where queries[j] = [pj, qj, limitj], your task is to determine for each queries[j] whether there is a path between pj and qj such that each edge on the path has a distance strictly less than limitj .

Return a boolean array answer, where answer.length == queries.length and the jth value of answer is true if there is a path for queries[j] is true, and false otherwise.

 

Example 1:


Input: n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],[0,2,5]]
Output: [false,true]
Explanation: The above figure shows the given graph. Note that there are two overlapping edges between 0 and 1 with distances 2 and 16.
For the first query, between 0 and 1 there is no path where each distance is less than 2, thus we return false for this query.
For the second query, there is a path (0 -> 1 -> 2) of two edges with distances less than 5, thus we return true for this query.
Example 2:


Input: n = 5, edgeList = [[0,1,10],[1,2,5],[2,3,9],[3,4,13]], queries = [[0,4,14],[1,4,13]]
Output: [true,false]
Exaplanation: The above figure shows the given graph.
 */

 class DSU {
    private int[] parent;
    private int[] rank;
    public DSU(int n) {
    
    parent = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; i++) {
    parent[i] = i;
    }
    }
    public int find(int x) {
    if (parent[x] == x) {
    return x;
    }
    return parent[x] = find(parent[x]);
    }
    public boolean union(int x, int y) {
    int xset = find(x), yset = find(y);
    if (xset != yset) {
    if (rank[xset] < rank[yset]) {
    parent[xset] = yset;
    } else {
    parent[yset] = xset;
    }
    if (rank[xset] == rank[yset]) {
    rank[xset]++;
    }
    return true;
    }
    return false;
    }
    }
    class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][]
    queries) {
    DSU dsu = new DSU(n);
    for (int i = 0; i < queries.length; i++) {
    queries[i] = new int[] { queries[i][0], queries[i][1], queries[i]
    
    [2], i };
    }
    Arrays.sort(queries, (a, b) -> Integer.compare(a[2], b[2]));
    Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));
    int i = 0;
    boolean[] res = new boolean[queries.length];
    for (int[] q : queries) {
    while (i < edgeList.length && edgeList[i][2] < q[2]) {
    dsu.union(edgeList[i][0], edgeList[i][1]);
    i++;
    }
    if (dsu.find(q[0]) == dsu.find(q[1])) {
    res[q[3]] = true;
    }
    }
    return res;
    }
    }
