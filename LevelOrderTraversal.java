// Approach 1: BFS
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Missed null check condition

// Your code here along with comments explaining your approach
// In BFS approach, use a queue to keep track of all the node's children, so we can come back to the queue and visit them
// We also keep track of size of queue because we need to differentiate between the levels in the tree

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
                li.add(temp.val);
            }
            result.add(li);
        }
        return result;
    }
}

// Approach 2: DFS
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// In DFS approach we keep track of the level(depth) at each node so that we know which list to add it to

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int depth){
        if(root==null)
            return;
        if(result.size()==depth)
            result.add(new ArrayList<>());
        result.get(depth).add(root.val);
        helper(root.left, depth+1);
        helper(root.right, depth+1);
    }
}