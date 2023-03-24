import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
*/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(h); h = height of binary tree
    // Did this code run on leetcode successfully? : Yes
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        if(root == null) {
            return new ArrayList<>(map.values());
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;

        while(!queue.isEmpty()) {
            int length = queue.size();
            for(int i = 0; i < length; i++) {
                TreeNode curr = queue.poll();

                map.putIfAbsent(level, new ArrayList<>());
                map.get(level).add(curr.val);

                if(curr.left != null) {
                    queue.offer(curr.left);
                }

                if(curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            level += 1;
        }

        return new ArrayList<>(map.values());
    }
}