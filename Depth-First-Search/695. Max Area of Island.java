// Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
//connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

// Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

// Example 1:

// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
//  [0,0,0,0,0,0,0,1,1,1,0,0,0],
//  [0,1,1,0,1,0,0,0,0,0,0,0,0],
//  [0,1,0,0,1,1,0,0,1,0,1,0,0],
//  [0,1,0,0,1,1,0,0,1,1,1,0,0],
//  [0,0,0,0,0,0,0,0,0,0,1,0,0],
//  [0,0,0,0,0,0,0,1,1,1,0,0,0],
//  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
// Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
// Example 2:

// [[0,0,0,0,0,0,0,0]]
// Given the above grid, return 0.
// Note: The length of each dimension in the given grid does not exceed 50.

class Solution {
    
    boolean[][] test = new boolean[50][50];

    public int maxAreaOfIsland(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int max1=0;
    
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]==1 && test[i][j]==false)
                    max1 = Math.max(max1, area(grid, i, j));
            }
            
        }
        return max1;
    }
    
    int area(int[][] grid, int i, int j)
    {
        
	        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0 || test[i][j]==true)
	        {
	            return 0;
	        }
	        test[i][j] = true;
	        
	        return (1+area(grid, i, j-1)+area(grid, i, j+1)
	                +area(grid, i-1, j)+ area(grid, i+1, j));
    }
    
}
