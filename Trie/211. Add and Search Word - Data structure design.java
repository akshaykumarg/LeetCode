/*

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

*/

class WordDictionary {

    class Node{
        boolean isword;
        Node[] arr = new Node[26];
    }
    
    Node root;
    
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        add(word, root, 0);
    }
    
    void add(String s, Node root, int index){
        if(s.length()==index){
            root.isword = true;
            return;
        }
        int temp = s.charAt(index)-'a';
        if(root.arr[temp]==null) root.arr[temp] = new Node();
        add(s, root.arr[temp], index+1);
    }
    
    public boolean search(String word) {
        return find(word, root, 0);
    }
    
    boolean find(String s, Node root, int index){
        if(s.length()==index){
            return root.isword;   
        }
        if(s.charAt(index)!='.'){
            int temp = s.charAt(index)-'a';
            return  root.arr[temp]!=null && find(s, root.arr[temp], index+1);
        }
        else{
            boolean flag = false;
            for(int i=0;i<26;i++){
                if(root.arr[i]!=null)
                    flag = flag || find(s, root.arr[i], index+1);
                    if(flag) return true;
            }
            return flag;
        }
    }
    
}
