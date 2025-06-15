// Time Complexity : O(n) n is no. of nodes
// Space Complexity : O(n) , for the queue and result list.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : None



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
class BinaryTreeLevelOrderTraversal_LC102 {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return result;

        queue.offer(root);

        while(!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> subList = new ArrayList<>();
            
            for (int i = 0; i < level; i++) {
                TreeNode tempNode = queue.poll();
                subList.add(tempNode.val);

                if(tempNode.left != null) queue.offer(tempNode.left);                
                if(tempNode.right != null) queue.offer(tempNode.right);
            }
            result.add(subList);
        }

        return result;
    }

    
}