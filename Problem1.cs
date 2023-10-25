public class BTLevelOrderTraversal
    {
        // Time Complexity : O(n) - have to traverse all nodes
        // Space Complexity : O(n) - queue at most will have n/2 elements in the worst case so amortized will be O(n) 
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public IList<IList<int>> LevelOrder(TreeNode root)
        {
            IList<IList<int>> result = new List<IList<int>>();

            if (root == null)
                return result;

            Queue<TreeNode> q = new Queue<TreeNode>();
            q.Enqueue(root);
            while(q.Count > 0)
            {
                //start processing the level
                int size = q.Count;
                List<int> list = new List<int>();

                for(int i = 0; i < size; i++)
                {
                    TreeNode curr = q.Dequeue();
                    list.Add(curr.val);
                    if(curr.left != null)
                    {
                        q.Enqueue(curr.left);
                    }
                    if(curr.right != null)
                    {
                        q.Enqueue(curr.right);
                    }
                }
                result.Add(list);
            }
            return result;
         }
}
