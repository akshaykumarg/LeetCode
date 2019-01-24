/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

*/


class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> list = new ArrayList<>();
        if(digits.length()==0) return list;
        
        Queue<String> q = new LinkedList<>();
        
        String[][] add = {{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
        
        int temp = digits.charAt(0)-'0'-2;
        
        for(int i=0;i<add[temp].length;i++){
            q.add(add[temp][i]);
        }
        
        for(int i=1;i<digits.length();i++){
            int size = q.size();
            
            while(size-->0){
                String s = q.poll();
                int dupli = digits.charAt(i)-'0'-2;
                for(int j=0;j<add[dupli].length;j++){
                    q.add(s+add[dupli][j]);
                }       
                
            }
            
        }
        list = new ArrayList<>(q);
        return list;
    }
}
