/*

A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

Now given an M x N matrix, return True if and only if the matrix is Toeplitz.

*/

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        int[] first = matrix[0];
        
        for(int i=1;i<matrix.length;i++)
        {
            int[] check = matrix[i];
            
            for(int j=1;j<check.length;j++)
            {
                if(check[j]!=first[j-1])
                    return false;
                first[j-1]=check[j-1];
            }
            first[check.length-1]=check[check.length-1];
        }
        return true;
    }
}
