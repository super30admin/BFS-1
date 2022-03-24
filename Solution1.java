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
/*
    Time Complexity : O(n)
    Space Complexity : O(n)
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        List<List<Integer>> list = new ArrayList<>();
        
        int counter = 0;
        while(queue.size() > 0){
            ArrayList<Integer> temp = new ArrayList<>();
            int size = queue.size();
            while(size > 0 ){
                TreeNode rm = queue.removeFirst();
                 
                temp.add(rm.val);
                
                if(rm!=null && rm.left!=null){
                    queue.addLast(rm.left);
                }
                if(rm!=null && rm.right!=null){
                    queue.addLast(rm.right);
                }
                size = size - 1;            
            }
            list.add(temp);
            counter = counter + 1;
        }
        
        return list;
    }
}
