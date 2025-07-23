class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();
         res=new ArrayList<>();
        dfs(root,0);
        return res;
    }
    private void dfs(TreeNode root,int level){
        if(root==null)return;
        if(level==res.size()){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }

}