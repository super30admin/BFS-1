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
        
        List<Integer> result = new ArrayList<>();
        
        if (root == null){
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        
        while (!q.isEmpty()){
            
            int size = q.size();
                
            
            for (int x = 0; x < size; x++){
                
                TreeNode front = q.poll();
                
                if ( x == size-1){
                    result.add(front.val);
                }
                
                if (front.left != null){
                    q.add(front.left);
                }
                
                if (front.right != null){
                    q.add(front.right);
                }
            }
        }
        
        return result;
    }
}