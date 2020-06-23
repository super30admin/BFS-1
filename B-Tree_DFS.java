// Time Complexity : O(n) --> where n is number of nodes in the tree  
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode (102): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            // for level process
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            result.add(temp);
        }
        return result;
    }
}