// Time Complexity : O(n), would traverse all nodes
// Space Complexity : O(log n), for the call stack and also the right side view
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no, could think of the solution early taking recursing only the right children initially as the thought


// Your code here along with comments explaining your approach
// Idea is to recurse on right child and keep track of the level
// if no right child exists, need to look back on the left branch if deeper level exists
// then add its right child if exists else the left child 

class Solution {
    List<Integer> rightSideView = new ArrayList<Integer>();
    int maxLevel = -1;
    
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return rightSideView;
        
        helper(root, 0);
        
        return rightSideView;
    }
    
    private void helper(TreeNode node, int level){
        if(node==null) return;
        
        if(level>maxLevel){
            rightSideView.add(node.val);
            maxLevel++;
        } 

        helper(node.right, level+1);
        helper(node.left, level+1);
    }
}