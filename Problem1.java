class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        if(root==null) return list ;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> l1=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr= q.poll();
                l1.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            list.add(l1);

        }
        return list;
    }
}
