// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are iterating through all the nodes
//Space Complexity: O(L) where L is total number of levels. At a time, the most number of nodes stored in the Queue is equal to the highest level
 class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
       //while taking out each element out of the queue check for child nodes if exist push them into queue
        while(!q.isEmpty()){
            List<Integer> levels = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size ; i++){
             TreeNode curr = q.poll();
                if(curr.left != null){
                    q.add(curr.left);
                }
                
                if(curr.right != null){
                    q.add(curr.right);
                }
                
                levels.add(curr.val);
            }
            res.add(levels);
        }
        
        return res;
    }
}