/*
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
We will use Queue to store tree nodes .We push root node to queue.Pop the root node and add its left and right node
to queue.Keeping processing the nodes until queue is empty 
*/
*/ 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<List<Integer>>();
        if(root == null)
            return traversal;
        Queue<TreeNode> queue =new LinkedList<TreeNode>(); 
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> levelNodes = new ArrayList<Integer>();
            int nodeCount = queue.size();
            for(int i =0; i < nodeCount; i++){
                TreeNode front = queue.remove();
                if(front != null){
                    levelNodes.add(front.val);
                    if(front.left != null){
                        queue.add(front.left);
                    }
                    if(front.right != null){
                        queue.add(front.right);
                    }
                }
            }
            traversal.add(levelNodes);
        }
        return traversal;
    }
}