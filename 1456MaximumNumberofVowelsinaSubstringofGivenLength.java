/*
 1456. Maximum Number of Vowels in a Substring of Given Length
 Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
 */

 // Approach Sliding Window
// TC: O(n) s.length = As we are iterating onevery character exactly once.
// SC:O(1)

class Solution {
    public int isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') 
        return 1;
        return 0;
    }
    public int maxVowels(String s, int k) {
        int max_vow = 0, cur_vow = 0;
        for(int i=0; i<s.length(); i++) {
            cur_vow += isVowel(s.charAt(i));
            if(i>=k) 
            cur_vow -= isVowel(s.charAt(i-k));
            max_vow = Math.max(max_vow, cur_vow);

        }
        return max_vow;
    }
}