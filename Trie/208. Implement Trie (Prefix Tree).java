/*

Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

*/

class Trie {

    boolean trace = false;
    Trie[] arr;
    /** Initialize your data structure here. */
    public Trie() {
        arr = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        Trie[] temp = arr;
        
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(temp[c-'a']==null){
                temp[c-'a'] = new Trie();
            }
            if(i==word.length()-1){
                temp[c-'a'].trace = true;
            }
            temp=temp[c-'a'].arr;
        }
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie[] temp = arr;
        return srh(word, temp, false);
    }
    
    boolean srh(String s, Trie[] temp, boolean flag){
        if(s.length()==0){
            return flag;
        }
        return temp[s.charAt(0)-'a']!=null && srh(s.substring(1), temp[s.charAt(0)-'a'].arr, temp[s.charAt(0)-'a'].trace);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie[] temp = arr;
        return sh(prefix, temp);
    }
    
    boolean sh(String prefix, Trie[] temp){
        if(prefix.length()==0) return true;
        return temp[prefix.charAt(0)-'a']!=null && sh(prefix.substring(1), temp[prefix.charAt(0)-'a'].arr);
    }
    
}
