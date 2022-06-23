
// approch 1
// Time Complexity : O(n) as we are visiting all the nodes
// Space Complexity : O(n) if there is complete binary tree then n/2 nodes at the
// last level so in queue there is n/2 nodes.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(n) as we are visiting all the nodes
// Space Complexity : O(n) recursion stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Main {
    // approach 1
    public static List<List<Integer>> levelOrder1(TreeNode root) {
        // for storing the result
        List<List<Integer>> result = new ArrayList<>();

        // null case
        if (root == null)
            return result;

        // using queue for BFS traversal
        Queue<TreeNode> q = new LinkedList<>();
        // add root to the queue
        q.add(root);
        // BFS traversal
        while (!q.isEmpty()) {
            // here I am storing size as I want to distinguish each level
            int size = q.size();
            // to store elements at particular level
            List<Integer> li = new ArrayList<>();
            // for loop traversal for every level to add elements in list then I am
            // adding this list into the result list
            for (int i = 0; i < size; i++) {
                // get first element from the queue
                TreeNode curr = q.poll();
                // add this element value in our temp list
                li.add(curr.val);
                // add childs into the queue
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            // add temp list at each level in the result;
            result.add(li);
        }
        // return result;
        return result;
    }

    // approach 2
    // to store result
    private static List<List<Integer>> res;

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        res = new ArrayList<>();
        // null case
        if (root == null)
            return res;
        // dfs
        dfs(root, 0);
        return res;
    }

    private static void dfs(TreeNode root, int level) {
        // base case
        if (root == null) {
            return;
        }
        // main logic
        // at every node I am checking that at that level there is some element in the
        // list or not
        // if not I am create new List and add it to the result else I am getting list
        // from the result
        // and add this node value in the list
        if (res.size() == level) {
            res.add(new ArrayList<>());
            res.get(level).add(root.val);
        } else {
            res.get(level).add(root.val);
        }
        // at each recursion I am increasing level by 1
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder1(root));
        System.out.println(levelOrder2(root));

    }
}