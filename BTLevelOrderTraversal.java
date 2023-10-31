// Time Complexity : O(N) where N is number of nodes in tree.
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class BTLevelOrderTraversal
{
    // BFS solution
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> ans = new ArrayList();

        if(root == null)
            return ans;

        Queue<TreeNode> que = new LinkedList();
        que.add(root);

        while(!que.isEmpty())
        {
            int size = que.size();
            List<Integer> levelNodes = new ArrayList();
            for(int i = 0; i < size; i++)
            {
                TreeNode temp = que.poll();
                levelNodes.add(temp.val);
                if(temp.left != null)
                    que.add(temp.left);
                if(temp.right != null)
                    que.add(temp.right);
            }
            ans.add(levelNodes);
        }
        return ans;
    }

    // DFS solution
    List<List<Integer>> ans;
    public List<List<Integer>> levelOrderDfs(TreeNode root)
    {
        ans = new ArrayList();
        dfs(root, 0);
        return ans;
    }
    public void dfs(TreeNode root, int level)
    {
        if(root == null)
            return;
        if(ans.size() <= level)
            ans.add(new ArrayList());

        List<Integer> levelNodes = ans.get(level);
        levelNodes.add(root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
