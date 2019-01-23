/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    
    int maxheight=-1;
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> list = new ArrayList<Integer>();
        solution(root, 0, list);
        return list;
        
    }
    
    void solution(TreeNode root, int level, List<Integer> list)
    {
        if(root==null) return;
        if(level>maxheight)
        {
            list.add(root.val);
            maxheight=level;
        }
        solution(root.right, level+1, list);
        solution(root.left, level+1, list);
        
    }
    
}
