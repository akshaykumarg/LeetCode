/*

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

*/
 
class Solution {
    public int minimumTotal(List<List<Integer>> arr) {
        
        int size = arr.size();
        if(size==0) return 0;
        
        int min = arr.get(0).get(0);
        
        for(int i=1;i<size;i++){
            
            min = Integer.MAX_VALUE;
            
            for(int j=0;j<arr.get(i).size();j++){
                
                int temp = 0;
                if(j==0)
                    temp = arr.get(i-1).get(j);
                else if(j==arr.get(i).size()-1)
                    temp = arr.get(i-1).get(j-1);
                else
                    temp = Math.min(arr.get(i-1).get(j), arr.get(i-1).get(j-1));
                arr.get(i).set(j, arr.get(i).get(j)+temp);
                min = Math.min(min, arr.get(i).get(j));
            }
            
        }
        return min;
    }
}
