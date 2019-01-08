// Given an array, rotate the array to the right by k steps, where k is non-negative.

// Example 1:

// Input: [1,2,3,4,5,6,7] and k = 3
// Output: [5,6,7,1,2,3,4]

class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        
        int[] result = new int[len];
        
        for(int i=0;i<len;i++){
            result[i]=nums[(i-k+len)%len];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
        // System.out.println(Arrays.toString(result));
        // nums = result;
        // System.out.println(Arrays.toString(nums));
    }
}
