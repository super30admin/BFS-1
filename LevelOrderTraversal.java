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
//Space: O(n)
//Time: O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
         if(root==null){
            return result;
        }
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
            level=q.size();
            List<Integer> ns=new ArrayList<Integer>();
                for(int i=0;i<level;i++){
                    TreeNode curr=q.poll();
                    if(curr.left!=null ){
                        q.add(curr.left);  
                    }
                    if(curr.right!=null ){
                       q.add(curr.right); 
                    }
                    ns.add(curr.val);
                }
                if(ns.size()>0){
                    result.add(ns);   
                }         
        }
        return result;
    }
}