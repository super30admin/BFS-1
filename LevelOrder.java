// Problem 102. Binary Tree Level Order Traversal
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }
    private static void dfs(TreeNode root, int depth, List<List<Integer>> list){
        // base
        if(root == null){
            return;
        }
        // first time visiting depth, add list
        if(list.size() == depth){
            list.add(new ArrayList<>());
        }
        // add current node value
        list.get(depth).add(root.val);
        // recursion for left and right value
        dfs(root.left, depth+1, list);
        dfs(root.right, depth+1, list);
    }
}
