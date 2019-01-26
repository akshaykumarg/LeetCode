/*

Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.

For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, 
but "star" is not similar to "tars", "rats", or "arts".

Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that 
"tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that 
a word is in the group if and only if it is similar to at least one other word in the group.

We are given a list A of strings.  Every string in A is an anagram of every other string in A.  How many groups are there?

Example 1:

Input: ["tars","rats","arts","star"]
Output: 2

*/

class Solution {
    public int numSimilarGroups(String[] A) {
        //Using DFS to find the number groups of similar Strings.
        int len = A.length;
        if(len==0 || len==1) return len;
        
        int count=0;
        
        for(int i=0;i<len;i++){
            if(A[i]==null)
                continue;
            String temp = A[i];
            A[i]=null;
            count++;
            dfs(A, temp);
        }
        return count;
    }
    void dfs(String[] arr, String s){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==null)
                continue;
            if(similar(arr[i], s)){
                String temp = arr[i];
                arr[i]=null;
                dfs(arr, temp);
            }
        }
    }
    boolean similar(String a, String b){
        int trace=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)==b.charAt(i))
                continue;
            trace++;
            if(trace>2) break;
        }
        return trace<=2;
    }
}
