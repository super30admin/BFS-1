// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int idx = 0;
        while(!q.isEmpty()) {
            result.add(new ArrayList<>());
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                result.get(idx).add(node.val);
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            idx++;
        }
        return result;
    }
}