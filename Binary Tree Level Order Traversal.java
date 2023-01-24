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

// Time Complexity = O(N)
// Space Complexity = O(N)
// BFS

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue <TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for (int i = 0; i < size ; i++){
                TreeNode curr = q.poll();
                li.add(curr.val);
                if(curr.left!= null) q.add(curr.left);
                if(curr.right!= null) q.add(curr.right);
            }
            result.add(li);
        }
        return result;
    }
}


// DFS
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }
    
    private void dfs (TreeNode root, int depth){
        // base
        if(root == null) return;
        // logic
        if(result.size() == depth){
            result.add(new ArrayList<>());
        }
        
        result.get(depth).add(root.val);
        dfs(root.left, depth +1);
        dfs(root.right, depth +1);
    }
    
}
