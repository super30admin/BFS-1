/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
 */
class Solution 
{
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> output = new ArrayList<>();
        
        if(root == null)
            return output;
            
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty())
        {
        
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for(int i=0;i <size; i++)
            {
                TreeNode current = queue.poll();
                level.add(current.val);
                
                if(current.left != null)
                    queue.add(current.left);
                    
                if(current.right != null)
                    queue.add(current.right);
            }
            
            output.add(level);
        }
        
        
        return output;
    }
    List<List<Integer>> output;
    
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        output = new ArrayList<>();
        
        if(root == null)
            return output;
            
        preorder(root, 0);
        
        return output;
    }
    
    private void preorder(TreeNode root, int level)
    {
        if(root == null)
            return;
        
        if(output.size() == level)
        {
            List<Integer> newLevel = new ArrayList<>();
            output.add(newLevel);
        }
        
        output.get(level).add(root.val);
        
        if(root.left != null)
            preorder(root.left, level + 1);
        
        if(root.right != null)
            preorder(root.right, level + 1);
    }
}