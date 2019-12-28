 /**
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 * Accepted on Leetcode: Yes
 Approach: we use BFS and for every level, take the right-most node from the queue and add it to the resultant list
 */
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
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Integer temp = null;            
            for(int i=0; i< size; i++){
                TreeNode node = queue.poll();
                if(i == size - 1){
                    temp = node.val;
                }
                if(node.left!=null ){
                    queue.offer(node.left);
                }
                if(node.right!=null ){
                    queue.offer(node.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}