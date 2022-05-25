using System;
using System.Collections.Generic;

namespace Algorithms
{
    public class BinaryTreeLevelOrder
    {
        /// Time Complexity : O(N) 
        // Space Complexity :O(N) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No 
        public IList<IList<int>> LevelOrder_BFS(TreeNode root)
        {
            List<IList<int>> result = new List<IList<int>>();
            if (root == null) return result;
            Queue<TreeNode> q = new Queue<TreeNode>();
            q.Enqueue(root);
            while (q.Count != 0)
            {
                List<int> level = new List<int>();
                int size = q.Count;
                for (int i = 0; i < size; i++)
                {
                    TreeNode currentNode = q.Dequeue();
                    level.Add(currentNode.val);
                    if (currentNode.left != null) q.Enqueue(currentNode.left);
                    if (currentNode.right != null) q.Enqueue(currentNode.right);
                }
                result.Add(level);
            }

            return result;
        }


        /// Time Complexity : O(N) 
        // Space Complexity :O(N) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No 
        List<IList<int>> result = new List<IList<int>>();
        public IList<IList<int>> LevelOrder_DFS(TreeNode root)
        {
            if (root == null) return result;
            dfs(root, 0);
            return result;
        }

        private void dfs(TreeNode root, int level)
        {
            //base
            if (root == null) return;
            //logic
            if (level == result.Count)
            {
                result.Add(new List<int>());
            }
            result[level].Add(root.val);
            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
        }
    }
}
