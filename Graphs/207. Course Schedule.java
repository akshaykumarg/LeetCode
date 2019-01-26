/*

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should
also have finished course 1. So it is impossible.
             
*/

class Solution {
    
    public boolean canFinish(int n, int[][] arr) {
        
        //Khans Algorithm
        
        int[][] graph = new int[n][n];
        int[] incoming = new int[n];
        
        for(int i=0;i<arr.length;i++){
            graph[arr[i][1]][arr[i][0]]=1;
            incoming[arr[i][0]]++;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
            if(incoming[i]==0)
                q.offer(i);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int tmp = q.poll();
                list.add(tmp);
                for(int j=0;j<n;j++){
                    if(graph[tmp][j]==1){
                        incoming[j]--;
                        if(incoming[j]==0)
                            q.offer(j);
                    }
                }
            }
        }
        return list.size()==n;
    }

}
