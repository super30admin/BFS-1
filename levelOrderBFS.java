// https://leetcode.com/problems/binary-tree-level-order-traversal/
// Level Order problem solving using BFS

// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // null case
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> li = new ArrayList();
            
            // process this many nodes on this many levels
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                li.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(li);
        }
        return result;   
    }
}