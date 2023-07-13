/*
 207. Course Schedule
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

*/


// Array 
// HashMap
// Queue.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     // corner cases
     if(prerequisites == null || prerequisites.length == 0) return true;
     int[] inDegree = new int[numCourses];
     Map<Integer, List<Integer>> map = new HashMap<>();
     for (int i=0; i< prerequisites.length; i++) {
         inDegree[prerequisites[i][0]]++;
         if(!map.containsKey(prerequisites[i][1])) {
             List<Integer> cur = new ArrayList<>();
             cur.add(prerequisites[i][0]);
             map.put(prerequisites[i][1], cur);
         } else {
             map.get(prerequisites[i][1]).add(prerequisites[i][0]);
         }

     } 

     Queue<Integer> queue = new LinkedList<>();
     for (int i =0; i< inDegree.length; i++) {
         if(inDegree[i]==0) queue.add(i);

     }
     while (!queue.isEmpty()) {
        int cur = queue.poll();
        List<Integer> list = map.get(cur);
        for (int x = 0; list != null && x < list.size(); x++) {
            inDegree[list.get(x)]--;
            if(inDegree[list.get(x)] == 0) queue.add(list.get(x));

        }
     }
     for (int i : inDegree) {
         if(i != 0) return false;
     }
     return true;

    }
}






















