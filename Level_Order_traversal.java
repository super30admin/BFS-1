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

/**
 * Time: O(n) n- nodes in the tree
 * Space: O(h) height of the tree --max stack space
 */
class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return res;
        dfs(root,0);
        return res;
    }
    public void dfs(TreeNode node, int level){
        if(node == null) return;
        if(res.size() == level) res.add(new ArrayList<Integer>());
        res.get(level).add(node.val);
        if(node.left != null)dfs(node.left,level+1);
        if(node.right != null)dfs(node.right,level+1);
    }
}

/**
 * Time COmpelxity: O(n)
 * Space: O(n) -max queue space
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            if(level == res.size()) res.add(new ArrayList<Integer>());
            int size = queue.size();
            while(size!=0){
                size--;
                TreeNode node = queue.poll();
                res.get(level).add(node.val);
                if(node.left != null)queue.offer(node.left);
                if(node.right != null)queue.offer(node.right);
            }
            level++;
        }
        return res;
    }
}

