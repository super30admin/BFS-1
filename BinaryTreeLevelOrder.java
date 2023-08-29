//TC = O(n)
//SC = O(n)
//Here we are using queue to keep track of levels from Tree. So will poll nodes from tree and and add its childer in queue.

class BinaryTreeLevelOrder{
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li= new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                li.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }if(curr.right != null){
                    q.add(curr.right);
                }
            }
            res.add(li);
        }
        
       return res; 
    }

}