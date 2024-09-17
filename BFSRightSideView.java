class Solution {
    public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
           int count = queue.size();
            TreeNode node=null;
           for(int i=0;i<count;i++){
               node = queue.poll();
               if(node.left!=null) queue.add(node.left);
               if(node.right!=null) queue.add(node.right);

           }
            result.add(node.val);
        }
        
        return result;
}
}