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
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        if(root==null) return new ArrayList<>();
        while(!q.isEmpty()){
            int size=q.size(); //this to check nodes at every level
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll(); //poll-returns and removes the element at the front end of the container
                temp.add(cur.val); //adding nodes in temp to store diff level list
                if(cur.left!=null) q.add(cur.left); //add left baby of cur in queue
                if(cur.right!=null) q.add(cur.right); //add right baby of cur in queue
            }
            result.add(temp);
        }
        return result;
    }
}