/*

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4

*/

class Solution {
    public int longestConsecutive(int[] arr) {
        
        int len = arr.length;
        if(len==0) return 0;
        
        Arrays.sort(arr);
        
        int[] dp = new int[len];
        dp[0]=1;
        
        int result=1;
        
        for(int i=1;i<len;i++){
            
            if(arr[i]==arr[i-1])
                dp[i]=dp[i-1];
            else if(arr[i]==arr[i-1]+1)
                dp[i]=dp[i-1]+1;
            else
                dp[i]=1;
            result=Math.max(result, dp[i]);
        }
        
        return result;
    }
}
