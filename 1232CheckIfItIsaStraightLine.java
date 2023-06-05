/*
 1232. Check If It Is a Straight Line

 You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 

 

Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.
 */

 // find the slope and compare each slope and if all slope are comes same then the line is
// straight line otherwise it is not.


// find the slope and compare each slope and if all slope are comes same then the line is
// straight line otherwise it is not.

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates == null || coordinates.length == 0 || coordinates[0].length == 0) {
            return false;
        }
        int p = coordinates[0][0], q = coordinates[0][1], u = coordinates[1][0], v = coordinates[1][1];
        for (int[] c : coordinates) {
            if((c[0] - p)* (c[1]-v) != (c[0]-u) * (c[1]-q)){
                return false;
            }
        } return true;
    }
}