// Time Complexity : O(n)
// Space Complexity : O(n) // for storing queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Take a queue add the root to it.
//Now in while loop till the queue is not empty poll from it and add children to the queue
//We will have another queue that will be used to transfer nodes when the level is over
//We will also keep creating a list in every level and add them to answer. 
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
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        q.add(root);
        List<Integer> ll1 = new ArrayList<>();
        if(root == null)
            return ans;
        ll1.add(root.val);
        ans.add(ll1);
        while(!q.isEmpty()){ 
            TreeNode cur = q.poll();
            if(cur.left != null)
                q1.add(cur.left);
            if(cur.right != null)
                q1.add(cur.right);
            if(q.isEmpty()){
                List<Integer> ll = new ArrayList<>();
                while(!q1.isEmpty()){
                    TreeNode x = q1.poll();
                    ll.add(x.val);
                    q.add(x);
                }
                if(!q.isEmpty())
                    ans.add(ll);
            }
        }
        return ans;
    }
}