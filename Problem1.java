// Time Complexity : O(n)
// Space Complexity : O(n)
    // n is the number of nodes present in the tree.

// Your code here along with comments explaining your approach
    //We use a queue of treeNodes. The approach is called Breadth First search. We first add the root node to the queue.
    //At every iteration until queue is not empty, We first calculate the size of the queue, say "size1". The size indicates the number of nodes in the level. We add all the non-null children to the queue.
    //We do this as many times as the size first calculated (size1). Then, we are only having the nodes from a level below in the queue.
    
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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        if (root==null)
        {
            return ans;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(q.isEmpty()==false&&curr!=null)
        {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<size; i++)
            {
                TreeNode curr = q.poll();
                list.add(curr.val);
                if (curr.left!=null)
                {
                    q.offer(curr.left);
                }
                if (curr.right!=null)
                {
                    q.offer(curr.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}