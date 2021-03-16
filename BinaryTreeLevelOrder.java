// Time Complexity : O(n)
// Space Complexity : O(n) since we're using queue/recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Using BFS approach and queue
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> que = new LinkedList();
        que.add(root);
        while(!que.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            int size = que.size();
            for(int i=0;i<size;i++){
                TreeNode node = que.remove();
                tempList.add(node.val);
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
            result.add(tempList);
        }
        return result;
    }
}


/*
Recursive Approach 

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return result;
        dfs(root,0);
        return result;
    }
    public void dfs(TreeNode node, int level){
        if(level == result.size()) result.add(new ArrayList<Integer>());
        result.get(level).add(node.val);
        if(node.left != null) dfs(node.left, level+1);
        if(node.right != null) dfs(node.right,level+1);
    }
}
*/
