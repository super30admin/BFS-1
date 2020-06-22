// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
        
    public List<Integer> rightSideView(TreeNode root) {
      List<Integer> temp = new ArrayList<>();
        if(root == null)
          return temp;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            
            int levels = queue.size();
            int count  = 0;
            
            for(int i = 0 ; i < levels; i++)
            {
                TreeNode node = queue.remove();
                if(count == 0){
                    temp.add(node.val);
                    count++;
                }
                if(node.right != null ) {
                     queue.add(node.right);
    
                 }
                if(node.left != null)  
                {
                    queue.add(node.left);
    
                }
            }              
        }
        return temp;
    }

}