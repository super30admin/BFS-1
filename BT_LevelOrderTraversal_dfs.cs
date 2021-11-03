//Time: O(n)
//Space: O(h) - h can go upto n
//LeetCode: https://leetcode.com/submissions/detail/581246187/
//Approach: Using DFS

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    List<IList<int>> result = new List<IList<int>>();
    
    public IList<IList<int>> LevelOrder(TreeNode root) {
        if(root == null) {
            return result;
        }
        dfs(root, 1);
        return result;
    }
    
    private void dfs(TreeNode node, int level){
        if(node == null) {
            return;
        }
        
        if(level > result.Count) {
            result.Add(new List<int>());
        }
        result[level - 1].Add(node.val); 
        dfs(node.left, level+1);
        dfs(node.right, level+1);
    }
}