/*

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
Note:
You may assume that all inputs are consist of lowercase letters a-z.

*/

class Solution {
    
    class Node{
        boolean isword;
        Node[] arr = new Node[26];
    }
    List<String> list;
    int row;
    int col;
    HashSet<String> set;
    
    public List<String> findWords(char[][] board, String[] words) {
        
        list = new ArrayList<>();
        row=board.length;
        col=board[0].length;
        if(row==0) return list;
        set = new HashSet<>();
        
        Node root = new Node();
        for(String s:words)
            build(root, s, 0);
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                check(board, i, j, "", root);
            }
        }
        
        return list;
    }
    
    void check(char[][] matrix, int i, int j, String s, Node root){
        if(root.isword==true && !s.equals("") && set.add(s)){
            list.add(s);
        }
        if(i<0 || i>=row || j<0 || j>= col || matrix[i][j]=='A' || root.arr[matrix[i][j]-'a']==null) return;
        char c = matrix[i][j];
        String temp = s + String.valueOf(c);
        int index = matrix[i][j]-'a';
        matrix[i][j]='A';
        check(matrix, i-1, j, temp, root.arr[index]);
        check(matrix, i+1, j, temp, root.arr[index]);
        check(matrix, i, j-1, temp, root.arr[index]);
        check(matrix, i, j+1, temp, root.arr[index]);
        matrix[i][j]=c;
    }
    
    void build(Node root, String s, int index){
        if(s.length()==index){
            root.isword=true; return;   
        }
        int temp = s.charAt(index)-'a';
        if(root.arr[temp]==null)
            root.arr[temp] = new Node();
        build(root.arr[temp], s, index+1);
    }
    
}
