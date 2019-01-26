/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses 
you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to 
finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. 
Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another 
correct ordering is [0,2,1,3] .
             
*/


class Solution {

    public int[] findOrder(int n, int[][] arr) {
        
    List<List<Integer>> list = new ArrayList<>();
		int len = n;
		while(len-->0)
			list.add(new ArrayList<Integer>());
		int[] degree = new int[n];
		
		for(int[] input: arr) {
			degree[input[0]]++;
			list.get(input[1]).add(input[0]);
		}
		Queue<Integer> queue = new ArrayDeque<Integer>();
		return khanalgo(degree, queue, list);
        
    }
    
    int[] khanalgo(int[] degree, Queue<Integer> queue, List<List<Integer>> list) {
		
		int[] result = new int[degree.length];
		
		for(int i=0;i<degree.length;i++)
		{
			if(degree[i]==0) {
				queue.offer(i);
			}
		}
		
		int start=0;
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
				result[start++]=tmp;
			Iterator<Integer> it = list.get(tmp).listIterator();
			while(it.hasNext()) {
				int link = it.next();
				degree[link]--;
				if(degree[link]==0)
					queue.offer(link);
			}
			 
		}
		return start==degree.length?result:new int[0];
	}
