// Time Complexity : O(n) // number of nodes in tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english: in level order we traverse all nodes in one level of tree at once.
// W use queue to store all ndoes in a level at any given time.
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
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root==null){
            return res;
        }
        q.add(root);
        int size = 0;
        while(!q.isEmpty()){
            size = q.size();
            ArrayList<Integer> li = new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode curr = q.remove();
                li.add(curr.val);
                if(curr.left !=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                
            }
            res.add(li);
        }
        return res;   
    }
}