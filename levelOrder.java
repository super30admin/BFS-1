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
        
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root==null) return res;
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        
        while(!que.isEmpty()){
            ArrayList temp = new ArrayList<>();
            int size = que.size();
            
            for(int i=0;i<size;i++){
                TreeNode node = que.poll();
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
                
                temp.add(node.val);
            }
            
            res.add(temp);
            
        }
        
        return res;
    }
}