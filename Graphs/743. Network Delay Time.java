/*

There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, 
v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? 
If it is impossible, return -1.

Note:
N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].

*/

class Solution {
    	
    int networkDelayTime(int[][] arr, int n, int k) {
		
		//Construct a graph using adjacency matrix
		int[][] graph = new int[n][n];
		int row = arr.length;
		for(int i=0;i<n;i++)
			Arrays.fill(graph[i], -1);
		for(int i=0;i<row;i++) {
			graph[arr[i][0]-1][arr[i][1]-1]=arr[i][2];
		}
		
		int[] distance = new int[n];
		boolean[] visited = new boolean[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[k-1]=0;
		int index = k-1;
		while(index!=-1) {
			visited[index] = true;
			for(int i=0;i<n;i++) {
				if(!visited[i] && graph[index][i]>-1) {
					distance[i]=Math.min(distance[i], distance[index]+graph[index][i]);
				}
			}
			index = getMin(distance, visited);
		}
		int result = 0;
		for(int i=0;i<n;i++) {
			result = Math.max(result, distance[i]);
		}
		return result==Integer.MAX_VALUE?-1:result;
	}
	
	int getMin(int[] distance, boolean[] visites) {
		int required = -1, dis = Integer.MAX_VALUE;
		
		for(int i=0;i<distance.length;i++) {
			if(distance[i]<dis && !visites[i]) {
				dis = distance[i];
				required = i;
			}
		}
		return required;
	}
		
}
