// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach BFS

// Used a queue to store the root
// Based on the size of the queue traversed the queue and then popped the element added it to list
// added the elements children to the queue

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> t = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                t.add(temp.val);
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);

            }
            result.add(t);
        }
        return result;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach DFS

// Used a recursive approach
// took the level
// if the size of the result list was equal to the level
// added the root val to that level
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if (root == null)
            return result;
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int lvl) {
        if (root == null)
            return;
        if (result.size() == lvl)
            result.add(new ArrayList<>());
        result.get(lvl).add(root.val);
        dfs(root.left, lvl + 1);
        dfs(root.right, lvl + 1);

    }
}