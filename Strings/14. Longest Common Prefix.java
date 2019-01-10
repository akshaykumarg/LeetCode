//Write a function to find the longest common prefix string amongst an array of strings.

//If there is no common prefix, return an empty string "".

//Example 1:

//Input: ["flower","flow","flight"]
//Output: "fl"

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];
        
        StringBuilder result = new StringBuilder();
        
        int j=0;
        boolean flag = true;
        
        while(flag){
            int i=0;
            for(i=0;i<strs.length-1;i++){
                if(j==strs[i].length() || j==strs[i+1].length()) {
                    flag = false;
                    break;
                }
                if(strs[i].charAt(j)!=strs[i+1].charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(i==strs.length-1)
                result.append(strs[i].charAt(j++));
        }
        return result.toString();
    }
}
