class LevelOrder{
    public List<List<Integer>> levelOrder(TreeNode root) {
        int size=0;
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
    //Time complexity : o(n) where n = number of nnodes
    //space complexity : o(n)  Maximum number of nodes in single level n/2
    //Keep size variable with BFS for each level and add nodes to list level by level
}