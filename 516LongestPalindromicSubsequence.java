/*
 516. Longest Palindromic Subsequence

 Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".

 */

 // TC: O(n^2)
// SC: O(n^2)
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        return solve(s, 0, n-1, dp);

    }

    private int solve(String s, int i , int j , int[][] dp) {
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        if(i>j) {
            return 0;

        }
        if(i == j) {
            return 1;

        }
        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + solve(s, i+1, j-1, dp);

        } else {
            return dp[i][j] = Math.max(solve(s, i, j-1, dp) , solve(s, i+1, j, dp));

        }
    }
} 