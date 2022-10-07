
// TC: O(n)
// SC: O(n)
// Solved on Leetcode
// No problem faced
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        
        if (root == null) {
            return levels;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                level.add(curr.val);
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            levels.add(level);
        }
        return levels;
    }
}
