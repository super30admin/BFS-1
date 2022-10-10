/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//Time Complexity: O(n). where n is the number of the nodes in the tree
//Space Complexity: O(H). where H is the number of the leaf nodes in the tree. 

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    if(root == null) return new ArrayList<>();
        
        
    List<List<Integer>> result = new ArrayList<>();
    //Queue is used for level order traversal 
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
        
    while(!q.isEmpty()){
        int s = q.size();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0 ; i < s; i++){
            TreeNode curr = q.poll();
            temp.add(curr.val);
            if(curr.left != null){
              q.add(curr.left);  
            }
            if(curr.right != null){
              q.add(curr.right);
            }
          }
      result.add(temp);
    }
 return result;
}
}