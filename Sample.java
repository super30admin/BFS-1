//# BFS-1
//# Problem 1
//Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this
// BFS approach

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> results = new ArrayList<>();
        if(root == null) return results;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                li.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            results.add(li);
        }
        return results;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this
// DFS approach
class Solution {
    List<List<Integer>> results;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.results = new ArrayList<>();
        helper(root, 0);
        return results;
    }
    private void helper(TreeNode root, int level){
        if(root == null) return;
        if(level == results.size()){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        helper(root.left, level+1);
        helper(root.right, level+1);
    }
}