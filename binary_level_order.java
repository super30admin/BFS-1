// Time Complexity : O(N) each node is processed once
// Space Complexity : O(N) each node goes into queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't solve before class


// Your code here along with comments explaining your approach

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new LinkedList<>();
        
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int currentLevel = q.size();
            List<Integer> curr = new LinkedList<>();
            for(int i=0; i< currentLevel; i++){
                
                TreeNode currentNode = q.poll();
                curr.add(currentNode.val);
                
                if(currentNode.left != null){
                    q.add(currentNode.left);
                }
                
                if(currentNode.right != null){
                    q.add(currentNode.right);
                }
            }
            res.add(curr);
        }
        
        return res;
        
    }
}