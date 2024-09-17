// DFS solution
// Time complexity -> 0(n)  as many recursive calls as elements
// Space complexity -> 0(n) storing n elements in list
class Solution {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        // to know at which level in tree we are
        int level=0;
        dfs(level,root,result);    
        return result;
    }
    
    private void dfs(int level,TreeNode root, List<List<Integer>> result){
        if(root == null) return;
        // if list size is equal to level, means we need to create a new list we are on left side
        if(result.size() == level)
            result.add(new ArrayList<Integer>());
        // add at left level & while coming back we are on right side just to add at right level
        result.get(level).add(root.val);
        
        dfs(level+1,root.left,result);
        dfs(level+1,root.right,result);
        
    }
}