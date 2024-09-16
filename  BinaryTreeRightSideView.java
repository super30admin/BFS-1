class BinaryTreeRightSideView {
   
   // Approach 1 - using recursion
   // Time complexity O(n)
   // Space complexity O(logn)
   // Tested in leetcode
   
   // Driver function of approach 1
   public List<Integer> rightSideView(TreeNode root) {
       List<Integer> result  = new ArrayList<>();
       helper(result,1,root);
       return result;
   }
   
   // Helper function of approach 1
   public void helper(List<Integer> result, int level, TreeNode root){
       if(root == null)
           return;
       
       // this condition will rstrict to add any node value which are left to the rightmost node
       if(result.size() < level){
           result.add(root.val);
       }
       
       // call right and left node recursively. 
       // Calling right children will add node value into the result array.
       helper(result,level+1,root.right);
       helper(result,level+1,root.left);
   }
}    