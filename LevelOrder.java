//TC O(N)
//SC O(N)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            List<Integer> li = new ArrayList<>();
            int size = q.size();
            
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                li.add(node.val);
                
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                
            }
            result.add(li);                                    
        }
        
        return result;
        
        
        
    }
}