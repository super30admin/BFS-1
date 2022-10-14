class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return result;
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> sublist = new ArrayList<>();
            
            for(int i=0; i<size; i++){
                TreeNode cur = queue.remove();
                sublist.add(cur.val);
                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
            }
            result.add(sublist);
        }
        return result;
    }
}

//Time Complexity : O(n)
//Space Complexity : O(n)