// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// Maintian a queue to keep a track of treenodes at each level
// add the treenodes at each level to the result as we traverse them
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;      
        
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i =0; i<size; i++) {
                TreeNode rootNode = queue.remove();
                temp.add(rootNode.val);
                
                if(rootNode.left != null) 
                    queue.add(rootNode.left);
                if(rootNode.right != null) 
                    queue.add(rootNode.right);
            }
            result.add(temp);
        }
        return result;
    }

}