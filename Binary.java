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

 //Time Complexity : O(n) -> iterating over the nodes of the tree
 //Space Complexity : O(h) -> height of the tree

 // This solution performs a level order traversal (like BFS) using DFS recursion.
// It groups node values by their depth level in the binary tree.
// Each level's values are stored in a separate list within the final result list.


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(root,0,result);

        return result;
    }
    private void dfs(TreeNode root, int level, List<List<Integer>> result){
        //base
        if(root==null){
            return;
        }

        //logic
        if(result.size()==level){
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);

        dfs(root.left, level+1, result);
        dfs(root.right,level+1, result);
    }
}