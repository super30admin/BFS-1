//-----------------USING BFS---------------------
// Time Complexity :o(N) where n is no of nodes
// Space Complexity :max no of width ie n/2 at worst case so O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//use a queue , at first only root element will be there in queue, then until queue is not empty,
// we'll make a temp list to store current level, calculate size as we need to store each level.
//then we'll put current level's all nodes in temp array and add it into result
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null) {
                    q.add(curr.right);
                }

            }
            result.add(temp);
        }
        return result;
    }
}
// ----------------------USING DFS-------------------------------------
// Time Complexity :O(n) where n is no of nodes
// Space Complexity :O(h) where h is max height of the tree
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// we'll use recursion here, we are taking level as parameter so that being at
// every node, we'll know
// on which level we are. if being at a particular level, result size is smaller
// or equal to level,
// that means current node is first to come at this level, so we'll add new list
// and call recursive method for left and right nodes increasing the level
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if (root == null)
            return result;
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int level) {
        // edge
        if (root == null)
            return;

        // logic
        if (result.size() <= level) {
            List<Integer> temp = new ArrayList<>();
            result.add(temp);
        }
        result.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}