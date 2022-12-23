// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        dfsIterative(root, 0);
        return result;
        
    }
    
    private void dfsIterative(TreeNode root, int depth){
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> dep = new Stack<>();
        //base
        if(root == null){
            return;
        }
        
        //logic
        stack.push(root);
        dep.push(depth);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            int d = dep.pop();
            if(d == result.size()){
                result.add(new ArrayList<Integer>());
            }
            result.get(d).add(current.val);
            if(current.right != null){
                stack.push(current.right);
                dep.push(d+1);
            }
            if(current.left != null){
                stack.push(current.left);
                dep.push(d+1);
            }
        }
    }
}