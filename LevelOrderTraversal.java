// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 102
//Type : BFS

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
        //Edge case
        if(root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        //Adding First element
        q.add(root);
        
    
        while(!q.isEmpty()){
            
        //Size to add elements in temp list    
        int size = q.size();
        List<Integer> temp = new ArrayList<>();
        
        for(int i = 0 ; i < size; i++){
            TreeNode curr = q.poll();
            temp.add(curr.val);
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null)q.add(curr.right);
            
        }
            result.add(temp);
        }
        return result;
    }
}

