/*
 662. Maximum Width of Binary Tree

 Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

 

Example 1:

Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

Example 2:
Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
Example 3:

Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).
 */

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // Approach BFS
 // TC:O(n)
 // SC: O(n)
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
       Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
       queue.offer(new Pair<>(root,1));
       int maxWidth = 0;

       while (! queue.isEmpty()) {
           int startIdx = queue.peek().getValue();
        int endIdx = 1;
        int levelSize = queue.size();

        for (int i =0; i<levelSize; i++) {
            Pair<TreeNode, Integer> pair = queue.poll();
         endIdx = pair.getValue();
         TreeNode node = pair.getKey();
         if (node.left != null) {
             queue.offer(new Pair<> (node.left, 2* endIdx));

         }
         if(node.right != null) {
             queue.offer(new Pair<> (node.right, 2* endIdx +1));

         }
        }
        maxWidth =  Math.max(maxWidth, endIdx - startIdx +1);

       } 
       return maxWidth;
    }
}

























