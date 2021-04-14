// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here  with comments explaining your approach

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        // Create a que to store the root node
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            // loop through the size of queue which is the no. of nodes in the current layer
            for (int i = 0; i < size; i++) {
                // pull the first node from queue
                TreeNode curr = q.poll();
                // add the pulled node to a temp list
                temp.add(curr.val);
                // check if the pulled node has left and right node
                // if present add them to the queue
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            // add temp list to result
            result.add(temp);
        }
        return result;
    }
}