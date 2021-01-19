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

// bfs solution
// Time Complexity : O(n)
// Space Complexity : O(m) m is max no of nodes within a level
// Did this code successfully run on Leetcode : Yes
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
            result.add(temp);
        }
        return result;
    }
}

/*
// dfs solution
// Time Complexity : O(n)
// Space Complexity : O(h) h is height of tree
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)
            return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        //base
        if(root == null)
            return;
        //logic
        if(level == result.size())
            result.add(new ArrayList<>());
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
        return;
    }
}
*/