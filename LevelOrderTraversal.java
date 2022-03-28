class LevelOrderTraversal {
  /**
   * Iterative approach:
   * 
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   *      ^ This is because, in the case of a Complete Binary Tree, we can have n/2 leaf nodes.
   * 
   * Were you able to solve this on Leetcode? Yes.
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>>  result = new ArrayList<>();
    
    if(root == null) { return result; }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    
    while(!queue.isEmpty()){
        int size = queue.size();
        
        List<Integer> levelList = new ArrayList<>();
        
        for(int i = 0; i < size; i++){
            TreeNode node = queue.remove();
            levelList.add(node.val);
            
            if(node.left != null) { queue.add(node.left); }
            if(node.right != null) { queue.add(node.right); }
        }
        
        result.add(levelList);
    }
    return result;
  }

  /**
   * Approach - 2:
   *      Try Recursive
   */
}
