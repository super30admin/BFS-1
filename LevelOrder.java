// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

// Definition for a binary tree node.
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


class Solution {
    //DFS
    // O(n) time , O(h) space
    // private List<List<Integer>> result;
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     result = new ArrayList<>();
    //     if(root==null) return result;
    //     dfs(root,0);
    //     return result;
    // }

    // private void dfs(TreeNode root, int level){
    //     if(root==null) return;
    //     if(level==result.size()){
    //         result.add(new ArrayList<>());
    //     }
    //     result.get(level).add(root.val);
    //     dfs(root.left,level+1);
    //     dfs(root.right,level+1);
    // }
    //BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                list.add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}