Time Complexity - O(N) where N is the number of nodes in the tree.
Space Complexity - O(N)

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


// Level Order Traversal Using BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i =0; i<size; i++){
                TreeNode current = q.poll();
                temp.add(current.val);
                if(current.left!=null) q.offer(current.left);
                if(current.right!=null) q.offer(current.right);
            }
            result.add(temp);
        }
        return result;
    }
}


// Level Order Traversal Using DFS
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        if(root == null) return;
        
        if(result.size() == level)
            result.add(new ArrayList<>());
        result.get(level).add(root.val);
        
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}