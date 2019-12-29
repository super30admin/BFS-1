// Time Complexity: O(n)
// Space Complexity: O(1)
// Solved on leetcode : Yes


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue <TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            Integer temp = null;
            
            for (int i=0; i< size; i++) {
                TreeNode node = q.poll();
                if (i==size-1) temp = node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);    
            }
            result.add(temp);
        }
        return result;
    }
}