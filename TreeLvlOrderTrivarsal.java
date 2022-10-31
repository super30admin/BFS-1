// Time Complexity : O(N) n is #of nodes
// Space Complexity : O(N) n is #of nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return list;

        //BFS
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int length = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i = 0; i<length; i++){
                TreeNode curr = q.poll();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                li.add(curr.val);
            }
            list.add(li);
        }
        return list;
    }
}


// Time Complexity : O(N) n is #of nodes
// Space Complexity : O(H) h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return list;

        //DFS based solution
        dfs(root, 0);
        return list;
    }

    private void dfs(TreeNode root, int lvl){
        //base
        if(root == null) return;

        //logic
        if(list.size() == lvl){
            list.add(new ArrayList());
        }
        list.get(lvl).add(root.val);

        dfs(root.left, lvl+1);
        dfs(root.right, lvl+1);
    }
}