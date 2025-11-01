// Time Complexity :O(N)
// Space Complexity :O(W) - weidth of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

/*
 * Approach
 * In this solution we are going the BFS route
 * we maintain the elements in the queue were start by adding the root
 * then we start a while loop until the queue is empty
 * we start is size of the queue so that we know how many nodes are there in the particular level,
 * then in the for loop we add the ele od the curr lvl to one list and also keep on adding the elements of the level to the queue
 * 
 * in the end we return the result 
 * 
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> lvl = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                lvl.add(cur.val);
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            result.add(new ArrayList<>(lvl));
        }
        return result;
    }
}