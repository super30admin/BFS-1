// Time Complexity : O(h) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//102. Binary Tree Level Order Traversal
//https://leetcode.com/problems/binary-tree-level-order-traversal/

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
    //DFS approach
    //time: O(h) - where h is height of the tree; activation stack will not be more than height of the tree
    //space: O(1)
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        helper(root, 0);
        return result;
    }
    
    private void helper(TreeNode root, int level){
        //base
        if(root == null) return;
        
        //logic
        if(result.size() == level){
            List<Integer> list = new ArrayList<>();
            result.add(list);
            result.get(level).add(root.val);
        }else{
            result.get(level).add(root.val);
        }
        helper(root.left, level+1);
        
        helper(root.right, level+1);
    }
}
/*
//BFS approach:
//time:O(n)
//space:O(n) - approx n/2 nodes in the queue 
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int size = 0;
        int count = 0;
        if(root == null) return result;
        q.add(root);
        count = 1;
        size = count;
        count = 0;
        TreeNode temp = root;
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            
            for(int i=0; i< size; i++){
                
                if(temp.left != null){
                    q.add(temp.left); 
                    count ++;
                 }
                
                if(temp.right != null){
                    q.add(temp.right);
                    count ++;
                 }
                
              TreeNode t = q.remove();
              list.add(t.val);
              temp = q.peek();
            }
            
            size = count;
            count = 0;
            result.add(list);
        }
        
        
        return result;
    }
}
*/