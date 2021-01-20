// Time Complexity : O(n) n is number of nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No 


class Solution {
    
    Map<Integer,List<Integer>> map = new HashMap<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null) return new ArrayList<List<Integer>>();
        helper(root,0);
        return new ArrayList<>(map.values());
    }
    
    public void helper(TreeNode root, int level)
    {
        if(root == null) return ;
        if(!map.containsKey(level))
        {
            List<Integer> levelList = new ArrayList<>();
            levelList.add(root.val);
            map.put(level,levelList);
        }else{
            
            List<Integer> levelList = map.get(level);
            levelList.add(root.val);
            map.put(level,levelList);
        }
        helper(root.left,level+1);
        helper(root.right,level+1);
        
    }
}