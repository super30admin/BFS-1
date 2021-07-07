/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
LeetCode Submitted : YES
Space Complexity : O(height of the tree)
Time Complexity : O(N)
**/

class Solution {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        //System.out.println(calcHeight(root));
        if(root == null)
            return output;
        
        int height = calcHeight(root);
        
        for(int i = 1; i <= height; i++){
            List<Integer> temp = new ArrayList<>();
            addOutput(root, i,temp);
            output.add(temp);
        }
        
        return output;
        
    }
    
    private void addOutput(TreeNode root, int i,List<Integer> temp ){
        if(root == null)
            return;
        if(i == 1){
            System.out.println(root.val);
            temp.add(root.val);
            return; 
            
        }
            // temp.add(root.val);
        
        addOutput(root.left,i-1,temp);
        addOutput(root.right,i-1,temp);
        
        
    }
    
    private int calcHeight(TreeNode root){
        if(root == null)
            return 0;
        
        //if(root.left == null || root.right == null)
         //   return 0;
        
        int left  =  1 + calcHeight(root.left);
        int right =  1 + calcHeight(root.right); 
        
        if(left > right)
            return left;
        return right;
    }
}
