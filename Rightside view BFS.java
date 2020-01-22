// Time complexity 0(n)
// space complexity 0(n) [size of the Queue, auxiliary space ]
// Code successfully executed in leetcode.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        //base case 
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()){
             int size = q1.size();
            // Contains last value of the node
             int temp =0;   
          for(int i=0;i<size;i++){
                  TreeNode node = q1.poll(); 
                  if(i==0){
                      temp = node.val;
                  }
                 if(node.right != null) q1.add(node.right);
                 if(node.left != null) q1.add(node.left);
            }
            result.add(temp);
        }
        return result;
    }
}