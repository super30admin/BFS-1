/*
  Time complexity: O(n)
  Space complexity: O(n)

  Code ran successfully on Leetcode: Yes
*/

using System.Collections.Generic;

public class Solution {
    public IList<IList<int>> LevelOrder(TreeNode root) {
        IList<IList<int>> res = new List<IList<int>>();
        if (root == null) return res;
        
        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        
        while (queue.Count > 0) {
            int size = queue.Count;
            List<int> level = new List<int>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.Dequeue();
                level.Add(node.val);
                if (node.left != null) queue.Enqueue(node.left);
                if (node.right != null) queue.Enqueue(node.right);
            }
            
            res.Add(level);
        }
        
        return res;
    }
}
