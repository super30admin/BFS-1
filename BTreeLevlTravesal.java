/*
Running Time Complexity: O(n)-> Searching through all the nodes
Space Complexity: O(2^logh)-> Number of leaves nodes
Successfully Run and Compiled on leetcode
/*
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
    List<List<Integer>> list;
    public List<List<Integer>> levelOrder(TreeNode root) {
        list = new ArrayList<>();
        dfs(root,0);
        return list;
    }
    private void dfs(TreeNode root, int level){
        //base case
        if (root==null) return;
        
        if(level == list.size()){
            //creating new level
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        dfs(root.left,level+1);
        //st.pop(); root and level are getting reset
        dfs(root.right,level+1);
        
    }
}