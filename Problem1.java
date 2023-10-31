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
//Problem - Binary Tree Level Order Traversal
//Time Compplexity - O(N)
//Space Complexity - O(N) 
//Run code succssfully on Leetcode - Yes
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        //Checking the condition for empty root
        if(root == null)
        return result;
        //Creating queue 
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            //Creating internal list for same level nodes
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                list.add(curr.val);
                //Checking left child
                if(curr.left != null){
                    q.add(curr.left);
                }
                //checking right child
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            result.add(list);
        }
        return result;          
    }
}