import java.util.ArrayList;
import java.util.List;

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
//TC: O(N), SC: O(H) DFS
class BinaryTreeOrderTraversal {
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int height) {
        //base
        if(root == null) return;
        //logic
        if(height == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);
        dfs(root.left, height+1);
        dfs(root.right, height+1);
    }
}

//TC: O(N), SC: O(N) BFS
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         if(root == null) return new ArrayList<>();
//         List<List<Integer>> res = new ArrayList<>();
//         Queue<TreeNode> myQueue = new LinkedList<>();
//         myQueue.add(root);
//         while(myQueue.size() != 0) {
//             int size = myQueue.size();
//             List<Integer> li = new ArrayList<>();
//             for(int i = 0; i < size; i++) {
//                 TreeNode curr = myQueue.poll();
//                 li.add(curr.val);
//                 if(curr.left != null) myQueue.add(curr.left);
//                 if(curr.right != null) myQueue.add(curr.right);
//             }
//             res.add(li);
//         }
//         return res;
//     }
// }