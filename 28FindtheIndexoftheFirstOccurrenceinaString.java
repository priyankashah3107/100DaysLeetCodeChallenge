/*
 28. Find the Index of the First Occurrence in a String
 
 Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */

 class Solution {
   
    public boolean compare(String haystack, String needle, int idx) {
        int n1 = haystack.length();
        int n2 = needle.length();
        for (int i = 0; i<n2; i++) {
            if(idx >= n1) return false;
            if(haystack.charAt(idx++) != needle.charAt(i)) 
            return false;
        }
        return true;
    }
 
     public int strStr(String haystack, String needle) {
         int n1 = haystack.length();
         for (int i = 0; i<n1; i++) {
             if(haystack.charAt(i) == needle.charAt(0)) {
                 if(compare(haystack, needle, i) == true)
                 return i;
             }
         }
         return -1;
 
     }
 }