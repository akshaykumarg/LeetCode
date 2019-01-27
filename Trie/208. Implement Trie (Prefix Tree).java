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

    class Node{
        boolean isWord;
        Node[] arr = new Node[26];
    }
    
    public Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        add(word, root);
    }
    
    void add(String word, Node root){
        if(word.length()==0){
            root.isWord = true;
            return;
        }
        if(root.arr[word.charAt(0)-'a']==null)
            root.arr[word.charAt(0)-'a']= new Node();
        add(word.substring(1), root.arr[word.charAt(0)-'a']);
    }
    
    
    public boolean search(String word) {
        return find(word, root);
    }
    
    boolean find(String word, Node root){
        if(word.length()==0) return root.isWord;
        return root.arr[word.charAt(0)-'a']!=null && find(word.substring(1), root.arr[word.charAt(0)-'a']);
    }
    
    public boolean startsWith(String prefix) {
        return with(prefix,root);
    }
    
    boolean with(String s, Node root){
        if(s.length()==0) return true;
        return root.arr[s.charAt(0)-'a']!=null && with(s.substring(1), root.arr[s.charAt(0)-'a']);
    }
    
}
