/*
On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.

Now, a move consists of removing a stone that shares a column or row with another stone on the grid.

What is the largest possible number of moves we can make?

Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Example 3:

Input: stones = [[0,0]]
Output: 0

*/    

class Solution {
    int[] unions = new int[4];
    public int removeStones(int[][] stones) {
        int len = stones.length;
        for (int i = 0; i < len; i++){
            unions[i] = i;
        }
        
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    union(i, j);
                }
            }
        }
        System.out.println(Arrays.toString(unions));
        int count = 0;
        for (int i = 0; i < len; i++){
            if (unions[i] == i) count++;
        }
        
        return len - count;
    }
    
    private void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x == y) return;
        unions[y] = x;
    }
    
    private int find(int x){
        if (unions[x] == x) return x;
        return find(unions[x]);
    }
}
