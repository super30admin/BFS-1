/*
Desc : We can use DFS or BFS for this purpose. in case of DFS we have to maintain another variable i.e; level. While in BFS we would
be procuring the whole level in our queue. which will be pushed in the resultant list.
Time Complexity : DFS(O(n)) BFS(O(n))
Space Complexity : DFS(O(n)) BFS(O(h))
*/

/*class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right );
            }
            result.add(temp);
        }
        return result;
    }
}*/
class Solution{
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root){
        result = new ArrayList<>();
        //null check
        if(root==null) return result;
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        //base
        if(root==null) return;
        //logic
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
        
    }
}
