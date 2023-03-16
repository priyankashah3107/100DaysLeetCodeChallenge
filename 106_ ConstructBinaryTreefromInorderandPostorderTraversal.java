// 106. Construct Binary Tree from Inorder and Postorder Traversal
// Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

                //     3
                //    / \
                // 9     20
                //     /   \
                //     15   7
               
               
 // Example 1:
// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]


// Example 2:

// Input: inorder = [-1], postorder = [-1]
// Output: [-1]

// Solution 
// Approach DFS 

// inorder = left , root, right.
// postorder = left, right, root
// TC: O(n)
// SC ; O(n)

class Solution {
    private TreeNode buildTree(int[] inorder, int iS, int iE, int[] postorder, int ps, int pE) {
        if (ps>pE || iS>iE) {
            return null;
        }

        TreeNode root = new TreeNode (postorder[pE]);
        int rootI = iS;
        while(root.val != inorder[rootI]){
            rootI++;
        }
        
        root.left = buildTree(inorder, iS, rootI -1, postorder, ps , ps+rootI -iS-1);
        root.right = buildTree(inorder, rootI +1, iE, postorder, ps+rootI - iS, pE-1);
        return root;

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0 , inorder.length -1, postorder, 0, postorder.length -1);
    }
}


