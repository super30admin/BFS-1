
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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        
        while(!que.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int n = que.size();
            for(int i = 0; i < n;i++){
                TreeNode node = que.poll();
                list.add(node.val);
                
                if(node.left!=null){
                    que.add(node.left);
                }
                if(node.right != null){
                    que.add(node.right);
                }
            }
            result.add(list);    
        }
        
        return result;
    }
}

//TC : O(n)
//SC : O(n)