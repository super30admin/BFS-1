// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**https://leetcode.com/problems/binary-tree-level-order-traversal/
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

class LevelOrderUsingBFS {
    //using bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<size;i++) {
                TreeNode currNode = q.poll();
                temp.add(currNode.val);
                if(currNode.left!=null) q.add(currNode.left);
                if(currNode.right!=null) q.add(currNode.right);
            }
            
            result.add(temp);
        }
        return result;
    }
}

class LevelOrderUsingDFS {
    List<List<Integer>> result = new ArrayList<>();
   
   //using dfs
   public List<List<Integer>> levelOrder(TreeNode root) {
     
       if(root == null) return result;
       dfs(root,0);
       
       return result;
   }
   
   private void dfs(TreeNode root, int level) {
       //base
       if(root == null) return;
       
       //logic
       if(result.size() == level) {
           result.add(new ArrayList<>());
       }
       result.get(level).add(root.val);
       dfs(root.left, level+1);
       dfs(root.right, level+1);
   }
   
}