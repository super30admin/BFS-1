//All tetscases passe
/*
Runtime: 1 ms, faster than 93.27% of Java online submissions for Binary Tree Level Order Traversal.
Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Binary Tree Level Order Traversal.
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            
            for(int i=0;i<size;i++){
                root = queue.poll();
                list.add(root.val);
                
            if(root!=null) {
                if(root.left!=null) queue.add(root.left); 
                if(root.right!=null) queue.add(root.right);
                }   
            }
        result.add(list);
        }
        return result;
    }
}
