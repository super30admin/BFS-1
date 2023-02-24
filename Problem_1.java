// Time Complexity : O(n) where n is the no of nodes in tree
// Space Complexity : O(n), size of queue
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use a queue and size variable. We add the root initially to the queue. Then we process root and push its children
   to the queue and get size of 2nd level. In this way we go level by level and keep on adding lists to 2d result list and 
   return it.
*/

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
        if(root == null)
            return new ArrayList<>();
            
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        List<List<Integer>> result = new ArrayList<>();
        int size;
        while(!q.isEmpty()) {
            size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; ++i) {
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            result.add(list);
        }
        return result;
    }
}