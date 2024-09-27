// Time Complexity : O(n) 
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
       List<List<Integer>> output = new LinkedList(); 
        if(root==null){
            return output;
        }
        
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size  = queue.size();
            List<Integer> temp = new LinkedList<>();
            for(int x=0;x<size;x++){
                TreeNode front = queue.poll();
                 temp.add(front.val);
                
                if(front.left!=null){
                    queue.add(front.left);
                }
                 if(front.right!=null){
                    queue.add(front.right);
                }
            }
            output.add(temp);
        }
         return output;
    }
}