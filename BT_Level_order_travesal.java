//Method-1 - using BFS

//Time Complexity: O(n) because we are processing all the nodes of BT
//Space Complexity : O(n) ; maximum nodes in queue will at that time when we are processing leaf nodes and in complete binary tree  max leaf nodes can be n/2 =>O(n/2)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if (root == null)
            return result; // null case
        Queue<TreeNode> q = new LinkedList<>(); // maintaining a queue for BFS
        q.add(root); // adding root initially yo the queue
        while (!q.isEmpty()) {
            int size = q.size(); // to know size of queue at a particular level
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) { // processing all nodes of a particular level
                // removing a node and the processing its babies if it exists
                TreeNode curr = q.poll();
                levelList.add(curr.val); // once a node is removed , add it to the levellist
                // processing babies and adding them to queue
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            result.add(levelList);

        }
        return result;
    }
}

// Method-2 Using recursion / DFS

// Time Complexity :O(n) ;we are traversing all the nodes
// Space Complexity :O(h) ;h is height of the tree

// If we are hitting that level for the first time a new list will be created in
// result list . If list already exists at a particular level, then we will take
// the list and add the node in that list.

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, Integer level) {
        // base
        if (root == null)
            return;
        // logic
        if (result.size() == level) { // if size == level ,then no list exist for that level , so we need to make a
                                      // new list and add value of node in that list
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}