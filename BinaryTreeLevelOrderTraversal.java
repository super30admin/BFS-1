// BFS Solution
// Time Complexity-O(n)
// space Complexity-O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        q.add(root);
        if(root==null) return result;
        while(!q.isEmpty()){
            int size =q.size();
            List<Integer> li=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr =q.poll();
                li.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            result.add(li);
        }
        return result;
    }
}
// DFS solution

// Time Complexity :O(n)
// Space Complexity: O(h)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root,0,result);
        return result;
    }
    private void dfs(TreeNode root,int level,List<List<Integer>> result){
        if(root==null) return ;
        if(result.size()==level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left,level+1,result);
        dfs(root.right,level+1,result);
    }
}