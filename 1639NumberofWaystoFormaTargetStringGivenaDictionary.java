/*
 1639. Number of Ways to Form a Target String Given a Dictionary

 You are given a list of strings of the same length words and a string target.

Your task is to form target using the given words under the following rules:

target should be formed from left to right.
To form the ith character (0-indexed) of target, you can choose the kth character of the jth string in words if target[i] = words[j][k].
Once you use the kth character of the jth string of words, you can no longer use the xth character of any string in words where x <= k. In other words, all characters to the left of or at index k become unusuable for every string.
Repeat the process until you form the string target.
Notice that you can use multiple characters from the same string in words provided the conditions above are met.

Return the number of ways to form target from words. Since the answer may be too large, return it modulo 109 + 7.

 

Example 1:

Input: words = ["acca","bbbb","caca"], target = "aba"
Output: 6
Explanation: There are 6 ways to form target.
"aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("caca")
"aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("caca")
"aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("acca")
"aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("acca")
"aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("acca")
"aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("caca")
Example 2:

Input: words = ["abba","baab"], target = "bab"
Output: 4
Explanation: There are 4 ways to form target.
"bab" -> index 0 ("baab"), index 1 ("baab"), index 2 ("abba")
"bab" -> index 0 ("baab"), index 1 ("baab"), index 3 ("baab")
"bab" -> index 0 ("baab"), index 2 ("baab"), index 3 ("baab")
"bab" -> index 1 ("abba"), index 2 ("baab"), index 3 ("baab")
 */

 // TC : O(m(n+k))
// SC: O(n*m)

class Solution {
    int[][] charFreq;
    int m,n;
    String target;
    int mod = 1000000007;
    Long[][] dp;
    private long solve(int i , int j) {
        if(i==n) {
            return 1;

        }
        if(j == m) {
            return 0;

        }
        if (dp[i][j] != null)
        {
            return dp[i][j];
        }

        long ans = solve(i , j+1); // skip current col.
        int cIdx = target.charAt(i) - 'a';
        if(charFreq[cIdx][j] >0) {
            ans += charFreq[cIdx][j] * solve(i+1, j+1);

        }

        ans%= mod;
        return dp[i][j] = ans;

    }
    public int numWays(String[] words, String target) {
        this.target = target;
        m = words[0].length();
        n = target.length();
        dp = new Long[n][m];
        charFreq = new int[26][m];
        for (String word : words) {
            for(int i = 0; i < word.length(); i++) {
                charFreq[word.charAt(i) - 'a'][i]++;

            }
        }
        return (int) solve(0,0);

    }
}


