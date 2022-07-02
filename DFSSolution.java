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
class DFSSolution {
    
     List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        int level = 0;
        
        dfs(root,level);
        
        return resultList;
        
    }
        
        private void dfs(TreeNode root,int level) {
            //base
            if (root==null) return;
            
            //logic
            if (resultList.size()==level) {
                List<Integer> li = new ArrayList<>();
                resultList.add(li);  
            }
            
            resultList.get(level).add(root.val);
   
            //logic
            dfs(root.left,level+1);
            dfs(root.right,level+1);
            
        }
        
        
        
     
}