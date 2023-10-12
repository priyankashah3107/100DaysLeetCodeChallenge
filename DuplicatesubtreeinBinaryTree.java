package Graphs.Trees;

    // find the dubplicate in given tree
    // we can use the hashset to store the subtree and check if the subtree is already present in the set or not
    /*
    Given a binary tree, find out whether it contains a duplicate sub-tree of size two or more, or not.

Note: Two same leaf nodes are not considered as subtree as size of a leaf node is one. 

Example 1 :

Input : 
               1
             /   \ 
           2       3
         /   \       \    
        4     5       2     
                     /  \    
                    4    5
Output : 1
Explanation : 
    2     
  /   \    
 4     5
is the duplicate sub-tree.
Example 2 :

Input : 
               1
             /   \ 
           2       3
Output: 0
Explanation: There is no duplicate sub-tree 
in the given binary tree.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function dupSub() which takes root of the tree as the only argument and returns 1 if the binary tree contains a duplicate sub-tree of size two or more, else 0.

Expected Time Complexity: O(N)
Expected Space Complexity: O(N)

Constraints:
0 ≤ Data of nodes ≤ 9
1 ≤ Number of nodes ≤ 105 

*/ 
    



    class Solution {
    String mark = "$";
    HashSet<String> subtree = new HashSet<>();
    
    int dupSub(Node root) {
        // code here 
        String str = dup(root);
        
        if(str.equals("#"))
        return 1;
        else 
        return 0;
        
    }
    
    String dup(Node root) {
        StringBuilder s = new StringBuilder();
        s.append("");
        if(root == null) 
        return s.append(mark).toString(); // if root is null returing $ 
        
        String leftStr = dup(root.left);
        if(leftStr.equals("#"))
        return "#";
        
        String rightStr = dup(root.right);
        if(rightStr.equals("#"))
        return "#";
        
        s = s.append(root.data).append(leftStr).append(rightStr);
        
        if(s.length() > 3 && subtree.contains(s.toString()))
        return "#";
        subtree.add(s.toString());
        return s.toString();
    }
    
}
