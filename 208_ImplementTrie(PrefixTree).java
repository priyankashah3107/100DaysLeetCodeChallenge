// 208. Implement Trie (Prefix Tree)

// A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
//  There are various applications of this data structure, such as autocomplete and spellchecker.

// Implement the Trie class:

// Trie() Initializes the trie object.
// void insert(String word) Inserts the string word into the trie.
// boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
// boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

// Example 1:

// Input
// ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
// [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
// Output
// [null, null, true, false, true, null, true]

// Explanation
// Trie trie = new Trie();
// trie.insert("apple");
// trie.search("apple");   // return True
// trie.search("app");     // return False
// trie.startsWith("app"); // return True
// trie.insert("app");
// trie.search("app");     // return True
 
/********************************* solution leetcode 208 trie**************************** */

class TriNode{
    TriNode[] children = new TriNode[26];
    boolean isEnd = false;
 
 }
 
 
 class Trie {
        TriNode root;
 
     public Trie() {
         root = new TriNode();
     }
     
     public void insert(String word) {
         TriNode node = root;
         for (int i = 0; i<word.length(); i++) {
             char ch = word.charAt(i);
             if(node.children[ch-'a']== null){
                 node.children[ch-'a'] = new TriNode();
             }
             node = node.children[ch-'a'];
         }
         node.isEnd = true;
     }
 
     
     public boolean search(String word) {
         TriNode node = root;
         for (int i =0; i<word.length(); i++) {
             char ch = word.charAt(i);
             if(node.children[ch-'a'] == null)
             return false;
             node = node.children[ch-'a'];
         }
         return node.isEnd;
     }
     
     public boolean startsWith(String prefix) {
         
         TriNode node = root;
         for (int i = 0; i<prefix.length(); i++) {
             char ch = prefix.charAt(i);
             if (node.children[ch-'a']== null)
             return false;
             node = node.children[ch-'a'];
         }
         return true;
     }
 }
 
 