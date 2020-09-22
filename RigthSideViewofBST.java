// Time Complexity : O(n) 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> output = new LinkedList<>();
        
        if (root==null){
            return output;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size= queue.size();
            
            for(int i=0;i<size;i++){
                TreeNode front = queue.poll();
                
                if(i==size-1){
                    output.add(front.val);
                }
                
                if(front.left!=null){
                    queue.add(front.left);
                }
                if(front.right!=null){
                    queue.add(front.right);
                }
            }
        }
        return output;
    }
}