public class Problem1 {
    //Level Order Traversal for BST - BFS
    //Space complexity : O(N)
    //Time complexity : O(N)
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){return new ArrayList<>();}
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> itr = new ArrayList<>();
            for(int i=0;i<size;i++){
                 TreeNode temp = q.poll();
                 if(temp.left!=null){
                     q.add(temp.left);
                 }  
                 if(temp.right!=null){
                     q.add(temp.right);
                 }
                itr.add(temp.val);
            }
            result.add(itr);
        }
        return result;
    }

    //Level Order Traversal for BST - DFS
    //Space complexity : O(N)
    //Time complexity : O(N)
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){return new ArrayList<>();}
        dfs(root,0);
        return result;
    }
    
    private void dfs(TreeNode root, int lvl){
        if(root==null){
            return;
        }
        if(result.size()==lvl){
            result.add(new ArrayList<>(Arrays.asList(root.val)));
        }else{
            result.get(lvl).add(root.val);
        }

         dfs(root.left,lvl+1);
         dfs(root.right,lvl+1);
    }
}
