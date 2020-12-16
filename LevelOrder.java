/** Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
* TC O(N) SC O(N)
* Traverse using DFS and when you reach a level for the first time (list size == level) create a new inner list else
* Keep adding to the inner list
*/
class Solution {
    List<List<Integer>> order = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return order;
        dfs(root, 0);
        return order;
    }
    private void dfs(TreeNode root, int level) {
        if (root == null)
            return;
        if (order.size() == level) {
            order.add(new ArrayList<Integer>());
        }
        order.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}

/** Iterative level order
* TC O(N) SC O(N)
*/
class Solution {
    List<List<Integer>> order = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return order;
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        while(!level.isEmpty()) {
            int size = level.size();
            List<Integer> inner = new ArrayList<Integer>();
            for (int i = 0; i< size; i++) {
                TreeNode node = level.remove();
                inner.add(node.val);
                if (node.left != null) {
                    level.add(node.left);
                }
                if (node.right != null) {
                    level.add(node.right);
                } 
            }
            order.add(inner);
        }
             return order;
        }
       
    }

