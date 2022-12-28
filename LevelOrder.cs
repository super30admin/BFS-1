# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public IList<IList<int>> LevelOrder(TreeNode root) {
        var result = new List<IList<int>>();
        if(root == null) return result;
        var q = new Queue<TreeNode>();
        q.Enqueue(root);
        while(q.Count > 0)
        {
            var count = q.Count;            
            var li = new List<int>();
            for(int i = 0; i < count; i++)
            {
                var node = q.Dequeue();
                li.Add(node.val);
                if(node.left != null)
                    q.Enqueue(node.left);
                if(node.right != null)
                    q.Enqueue(node.right);
            }
            result.Add(li);
        }
        return result;        
    }
}
