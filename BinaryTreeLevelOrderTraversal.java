// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes			
// Any problem you faced while coding this : No


// Your code here along with comments explaining your 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
          return result;
        
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
       
        queue.add(root);
        while(!queue.isEmpty()){
            
            int levels = queue.size();
            
            for(int i = 0 ; i < levels; i++)
            {
                TreeNode node = queue.remove();
                temp.add(node.val);
               
                if(node.left != null)  queue.add(node.left);
                 if(node.right != null) queue.add(node.right);
                
            }            
            result.add(temp);
            temp = new ArrayList<>();
            
        }
        return result;
        
    }
}