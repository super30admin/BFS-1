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
 
 // TC - O(n), SC - O(n)
 
 // We take queue as we need to find level order nodes, FIFO.
 // first,we add root to queue, find size of queue, iterate through size. Add left and right nodes accordingly if left is not null and right is not null
 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curNode =  q.remove();
                subList.add(curNode.val);
                if(curNode.left != null){
                    q.add(curNode.left);
                }
                if(curNode.right != null){
                    q.add(curNode.right);
                }
            }
            result.add(subList);
        }
        return result;
    }
}


// class Solution {
//     List<List<Integer>> result = new ArrayList<>();
//     public List<List<Integer>> levelOrder(TreeNode root) {
        
//         if(root == null){
//             return result;
//         }
        
//         helper(root, 0);
//         return result;
        
//     }
    
//     private void helper(TreeNode node, int level){
        
//         if(result.size() == level){
//             result.add(new ArrayList<>());
//         }
        
//         result.get(level).add(node.val);
        
//         if(node.left != null){
//             helper(node.left, level+1);
//         }
//         if(node.right != null){
//             helper(node.right, level+1);
//         }
        
//     }
    
// }