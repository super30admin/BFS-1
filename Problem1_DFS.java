//Time Complexity: O(n)
//Space Complexity: O(h), Recursion Stack Space, where h is height of the tree.
//Code run successfully on LeetCode.

public class Problem1_DFS {

    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null)
            return new ArrayList<>();
        
        result = new ArrayList<>();
        
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int lvl)
    {
        if(root == null)
            return;
        
        if(result.size() == lvl)
        {
            result.add(new ArrayList<>());
            result.get(lvl).add(root.val);
        }
        else
        {
           result.get(lvl).add(root.val); 
        }
        
        dfs(root.left, lvl +1);
        dfs(root.right, lvl +1);
    }
}
