public class BTLevelOrderTraversal {
    List<List<Integer>> ansList = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return ansList;
        helper(root, 0);
        return ansList;
    }
    
    private void helper(TreeNode root, int level) {
        if(ansList.size() == level) {
            ansList.add(new ArrayList<Integer>());
        }
        
        //add the value to the list
        ansList.get(level).add(root.val);
        
        if(root.left != null)
            helper(root.left, level + 1);
        if(root.right != null)
            helper(root.right, level + 1);      
        
    }
}
