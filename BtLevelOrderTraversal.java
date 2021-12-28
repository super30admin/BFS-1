// Time Complexity : O(n)
// Space Complexity: O(n/2)

// DFS
public class BtLevelOrderTraversal {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)
            return result;
        
        dfs(root, 0);
        return result;  
    }
    
    private void dfs(TreeNode root, int level)
    {
        if(root == null)
            return;
        
        if(result.size() == level)
        {
            result.add(new ArrayList<>());
        }
        
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}

// BFS
public class BtLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> lvl = new ArrayList<>();
            for(int i = 0 ; i < size; i ++)
            {
                TreeNode curr = q.poll();
                lvl.add(curr.val);
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
            }
            result.add(lvl);
        }
        return result;  
    }
}
