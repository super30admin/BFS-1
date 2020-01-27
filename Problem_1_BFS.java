/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *  Time Complexity : O(n)
 * 	Space Complexity : O(n) 
 * 
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> resultList = new ArrayList<>();
        
        if(root == null){
            return resultList;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list;
        while(!queue.isEmpty()){
            int size = queue.size();
            list = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            
            resultList.add(list);
        }
        
        return resultList;
        
    }
}