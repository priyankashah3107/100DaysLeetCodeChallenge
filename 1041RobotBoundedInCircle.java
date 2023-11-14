/*
 1041. Robot Bounded In Circle
On an infinite plane, a robot initially stands at (0, 0) and faces north. Note that:

The north direction is the positive direction of the y-axis.
The south direction is the negative direction of the y-axis.
The east direction is the positive direction of the x-axis.
The west direction is the negative direction of the x-axis.
The robot can receive one of three instructions:

"G": go straight 1 unit.
"L": turn 90 degrees to the left (i.e., anti-clockwise direction).
"R": turn 90 degrees to the right (i.e., clockwise direction).
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

 

Example 1:

Input: instructions = "GGLLGG"
Output: true
Explanation: The robot is initially at (0, 0) facing the north direction.
"G": move one step. Position: (0, 1). Direction: North.
"G": move one step. Position: (0, 2). Direction: North.
"L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: West.
"L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: South.
"G": move one step. Position: (0, 1). Direction: South.
"G": move one step. Position: (0, 0). Direction: South.
Repeating the instructions, the robot goes into the cycle: (0, 0) --> (0, 1) --> (0, 2) --> (0, 1) --> (0, 0).
Based on that, we return true.
Example 2:

Input: instructions = "GG"
Output: false
Explanation: The robot is initially at (0, 0) facing the north direction.
"G": move one step. Position: (0, 1). Direction: North.
"G": move one step. Position: (0, 2). Direction: North.
Repeating the instructions, keeps advancing in the north direction and does not go into cycles.
Based on that, we return false.
Example 3:

Input: instructions = "GL"
Output: true
Explanation: The robot is initially at (0, 0) facing the north direction.
"G": move one step. Position: (0, 1). Direction: North.
"L": turn 90 degrees anti-clockwise. Position: (0, 1). Direction: West.
"G": move one step. Position: (-1, 1). Direction: West.
"L": turn 90 degrees anti-clockwise. Position: (-1, 1). Direction: South.
"G": move one step. Position: (-1, 0). Direction: South.
"L": turn 90 degrees anti-clockwise. Position: (-1, 0). Direction: East.
"G": move one step. Position: (0, 0). Direction: East.
"L": turn 90 degrees anti-clockwise. Position: (0, 0). Direction: North.
Repeating the instructions, the robot goes into the cycle: (0, 0) --> (0, 1) --> (-1, 1) --> (-1, 0) --> (0, 0).
Based on that, we return true.
 

Constraints:

1 <= instructions.length <= 100
instructions[i] is 'G', 'L' or, 'R'.

 */


 // /* Time Complexity :- BigO(N)

// Space Complexity :- BigO(1) */ 
// class Solution {
//     public boolean isRobotBounded(String instructions) {
//             int x =0;
//             int y =0;
//           int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};

//           int currDir = 0;

//           for(char c : instructions.toCharArray()) {
              
//               if(c == 'G') {
//                   // "G": go straight 1 unit.

//                    x += dir[currDir][0];
//                    y += dir[currDir][1];

//               }
//               else if(c == 'L') {
//                   // move 90 degree to the left in anti clock wise (dir: Intially we will on north so, we left only three dir to move) 
//                   currDir = (currDir + 3) %4;
//               }

//               else if(c == 'R') {
//                   // turn 90 degrees to the right (i.e., clockwise direction).
//                   currDir = (currDir + 1 ) %4;
//               }
//           }  
//           return ((x == 0 &&  y == 0) || (currDir != 0 ));
//     }
// }


// Method 2.

 class Solution {
    public boolean isRobotBounded(String instructions) {
        // axis are x and y which is intialize at (0,0)
        int x = 0;
        int y = 0;
        
        // intially direction will be north dir 
        int dir = 'N';

        for(char c : instructions.toCharArray()) {
            
            // case 1: simply go straight 1 unit on the x and y axis
            if(c == 'G') {
                switch(dir) {
                    case 'N': y++; break;
                    case 'S': y--; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }
            }
            
            // case 2: turn 90 degree to left dir (anti clock wise)
            else if(c == 'L')  {
                switch(dir) {
                    case 'N': dir = 'W'; break;
                    case 'W': dir = 'S'; break;
                    case 'S': dir = 'E'; break;
                    case 'E': dir = 'N'; break;

                }
            }
           
           // case 3: if dir then turn 90 degree to the clockwise
            else if(c == 'R') {
                switch(dir) {
                    case 'N': dir = 'E'; break;
                    case 'E': dir = 'S'; break;
                    case 'S': dir = 'W'; break;
                    case 'W': dir = 'N'; break;
                }
            }
        }
    
          if(x == 0 && y == 0) return true;
          if(dir == 'N') return false;
        return true;



    }
 }
