/*
 211. Design Add and Search Words Data Structure
 Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 
 */

// Approach Using Tier DataStructure.
//tier datastrcture containes Key and Array.
// Time Complexity : O(n)
// Space Complexity : O(n)

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;

    }
}

class WordDictionary {
     TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if(curr.children[ch -'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch- 'a'];
        }
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0 , root);
    }
      

    private boolean searchHelper(String word, int idx, TrieNode curr) {
        if( idx == word.length()) {
            return curr.isEndOfWord;
        }
        
        if(word.charAt(idx) == '.') {
            for (TrieNode child : curr.children) {
                if (child != null && searchHelper(word, idx+1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode child = curr.children[word.charAt(idx) - 'a'];
            if (child == null) {
                return false;
            }
            return searchHelper(word, idx+1, child);
        }
    }  

}

