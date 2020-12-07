// Time Complexity : O(n), since we add each node to the queue and remove it 
// Space Complexity : O(n), extra space for the queue which would store all the nodes at a particular level
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Looking up various queue classes, was surprise LinkedList could be used as a queue
// initial approach was to store List<TreeNode> in the queue like level by level but keeping track of queue size as we are about to remove all nodes from a level helps keep track

// Your code here along with comments explaining your approach
// this is a standard approach to first put root node in the queue, then remove(), check if left and right children exist, if yes then push
// now at next iteration we now #nodes at that level hence remove() all and follow above step to push next level children
// do while queue is not empty


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        List<Integer> level;
        int size;
        
        while(!queue.isEmpty()){
            size = queue.size();
            level = new ArrayList<Integer>();
            
            for(int i=0; i<size; i++){
                TreeNode node = queue.remove();
                level.add(node.val);
                
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            
            if(level.size()>0)
                result.add(level);
        }
        
        return result;
    }
}