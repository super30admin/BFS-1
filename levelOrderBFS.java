/**
Time complexity: O(n)
Space complexity: O(n)
Execute successfully on Leetcode: Yes
Any problems faced: No
*/
class Solution {
    /**
    Approach using BFS:
    - We use a queue to keep track of the nodes at each level.
    - The queue size determines the level.
    - We first create a queue and add the root node into it.
    - In the while loop that runs till queue is empty:
      * We create a temp arraylist to add elements at each level into it.
      * Add the current.left to the queue if not empty.
      * Add the current.right to the queue if not empty.
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
