// Time Complexity : O(N) we are iterating all nodes of tree
// Space Complexity : O(N) used queue which will contain elements equal to height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't solve by own


// Your code here along with comments explaining your approach

//Use BFS like level order traversal. Only thing, add node value only if loop pointer (i) is less than queue size.


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new LinkedList<>();
        
        if(root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int countNodes = queue.size();
            
            for(int i = 0; i < countNodes; i++){
                System.out.println(i);
                TreeNode currNode = queue.poll();
                
                if(i == countNodes-1){
                    res.add(currNode.val);
                }
                
                if(currNode.left != null){
                    queue.add(currNode.left);
                }
            
            if(currNode.right != null){
                queue.add(currNode.right);
                }
            }
            
            
        }
        
        return res;
    }
}