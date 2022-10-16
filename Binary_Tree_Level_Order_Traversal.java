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
// TC : O(n)
// SC : O(1)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        
        result = new ArrayList<>();

        if(root == null) return result;
        
        // method - 1 -->BFS
        /*Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        
        q.add(root);
        while(!q.isEmpty()) {
            
            int size = q.size();
            List<Integer> temp  = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                root = q.poll();
                temp.add(root.val);
                if(root.left != null)
                    q.add(root.left);
                if(root.right != null)
                    q.add(root.right);
             }
            
            result.add(temp);
        }
        return result;*/
        
        // Method -2 ---> dfs
        helper(root, 0);
        
        return result;
    }
    
    // dfs
    // TC : O(n)
    // SC : O(h)
    
    private void helper(TreeNode root, int curLevel) {
        
        
        if(root == null) return;
        
        if(curLevel == result.size()) {
            result.add(new ArrayList<>());
        }
        
            result.get(curLevel).add(root.val);
        
        helper(root.left, curLevel+1);
        helper(root.right, curLevel+1);
        
    }
}
