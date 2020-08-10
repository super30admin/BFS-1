class RightSideView{
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size;

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

                if(i==size-1){
                    result.add(curr.val);
                }
            }
        }
        return result;

    }

    //TIme complexity : o(n)
    //space complexuity :o(n)
    //Level order BFS but add only last element to list in each level.

}