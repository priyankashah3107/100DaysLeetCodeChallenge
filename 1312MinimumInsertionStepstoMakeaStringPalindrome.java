/*
 1312. Minimum Insertion Steps to Make a String Palindrome
 Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.

 

Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we do not need any insertions.
Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
Example 3:

Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 */

 class Solution {
        
    //Tabulation Bottom Up
public int lpstab(String a, String b){
int n=a.length(),m=b.length();
int[][] dp=new int[n+1][m+1];

for(int i=n-1;i>=0;i--){
  for(int j=m-1;j>=0;j--){
    int ans=0;
if(a.charAt(i)==b.charAt(j)){
  ans=1+dp[i+1][j+1];
}else{
  ans=Math.max(dp[i+1][j],dp[i][j+1]);
}
dp[i][j] = ans;
  }
}
return dp[0][0];
}
public int minInsertions(String s) {
StringBuilder sb=new StringBuilder(s);  
sb.reverse();  
return s.length()-lpstab(s,sb.toString());
}
}