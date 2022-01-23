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
    // Time Complexity : O(n), where n is no of nodes in the tree
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    // Approach: Using BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode n = q.remove();
                list.add(n.val);
                if(null != n.left) {
                    q.add(n.left);
                }
                if(null != n.right) {
                    q.add(n.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}




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
    // Time Complexity : O(n), where n is no of nodes in the tree
    // Space Complexity : O(h), where h is the height of the tree
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    // Approach: Using DFS
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        if(level == res.size()) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            res.add(list);
        } else {
            res.get(level).add(root.val);
        }
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }

}