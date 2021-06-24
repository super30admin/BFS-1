class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        Queue<TreeNode>  q = new LinkedList<>();
        if(root == null){
            return res;
        }
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i< size; i++){
                TreeNode cur = q.poll();
                level.add(cur.val);
                if(cur.left != null){
                    q.add(cur.left);
                }
                
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
            res.add(level);
        }
        
        return res;
    }
}