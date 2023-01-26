// 102. Binary Tree Level Order Traversal
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// consider a queue for storing elements level by level at a time.
// have to add both left side children and right side children in the same iteration.
// until the counter reaches the size of queue, we have to process all elements of the queue and add them in the list.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                temp.add(curr.val);
                //put the children of curr node in the Queue
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(temp);
        }
        return result;
    }
}

/*
//DFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> depSt = new Stack<>();
        st.push(root);
        depSt.push(0); //this stack is used to track the elements are of same level

        while(!st.isEmpty()) {
            TreeNode curr = st.pop();
            int d = depSt.pop();
            if(d == result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(d).add(curr.val);
            if(curr.right != null) {
                st.push(curr.right);
                depSt.push(d+1);
            }
            if(curr.left != null) {
                st.push(curr.left);
                depSt.push(d+1);
            }
        }
        return result;
    }
}
*/