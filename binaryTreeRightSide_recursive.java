// Time Complexity : O(n)
// Space Complexity : O(h) general .  for a skewed tree -> O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : DFS

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            
            if(root==null)
                return new ArrayList<>();
            
            List<Integer> result=new ArrayList<>();
            /* DFS */
            
            dfs(root,1,result);
            
            return result;   
        }
        
        private void dfs(TreeNode root, int level, List<Integer> result)
        {
            if(root==null) return;
            
            
            /* Action */
            
            if(result.size()<level)
                result.add(root.val);
            else
                result.set(level-1,root.val);
            
            /* Recurse */
            
            dfs(root.left,level+1,result);
            dfs(root.right,level+1,result);
        }
    }