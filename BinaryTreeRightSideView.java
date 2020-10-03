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
//DFS
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList();
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        if(root == null) return;
        
        if(level == result.size()){
            result.add(root.val);
        }
        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}

//DFS
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList();
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        if(root == null) return;
        
        if(level == result.size()){
            result.add(root.val);
        }
        else{
            result.add(level, root.val);
            result.remove(level+1);
        }
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}

//BFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size(); TreeNode curr = null;
            for(int i = 0; i < size; i++){
                curr = q.poll();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(curr.val);
        }
        return result;
    }
}
