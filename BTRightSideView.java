// Time Complexity :O(n). n is the number of nodes
// Space Complexity : O(L). L is the no of leaf nodes in a level
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


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
    
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList();
        List<Integer> list=new ArrayList();
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        list.add(root.val);
        
        while(!q.isEmpty()){
            
            int size=q.size();
            ArrayList<Integer> temp=new ArrayList();
            
            for(int i=0;i<size;i++){
                
                TreeNode top =q.poll();
                
                if(top.left!=null) {
                    q.add(top.left);
                    temp.add(top.left.val);
                }
                
                if(top.right!=null){
                    q.add(top.right);
                    temp.add(top.right.val);
                }
            }
            if(temp.size()>0)
            list.add(temp.get(temp.size()-1));
            
        }
        
        return list;
    }
    

}
