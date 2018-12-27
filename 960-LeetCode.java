class Solution {
    public int minDeletionSize(String[] A) {
        
        int n = A.length;
        int len = A[0].length();
        int[] dp = new int[len];
        dp[0]=1;
        int result=0;
        
        for(int i=1;i<len;i++){
            
            int tmp = 0;
            
            for(int j=0;j<i;j++){
                int k;
                for(k=0;k<n;k++){
                    if(A[k].charAt(i)>=A[k].charAt(j))
                        continue;
                    break;
                }
                if(k==n)
                    tmp = Math.max(tmp, dp[j]);        
            }
            dp[i]=tmp+1;
            result = Math.max(result, dp[i]);
        }
        return len-result;
    }
}