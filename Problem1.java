// Time Complexity :O(n)
// Space Complexity :O(h) - height of tree
// Did this code successfully run on Leetcode :yes

// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //DFS solution
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root==null)return result;
        //dfs with root and its level 0
        dfs(root,0);
        return result;
    }
    public void dfs(TreeNode root, int level){
        //we need to stop after leaf nodes
        if(root==null)return;
        //if size is equal to level that means it is not in list so add a new list
        if(result.size()==level){
            result.add(new ArrayList<>());
        }
        //add the value to that list 
        result.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}