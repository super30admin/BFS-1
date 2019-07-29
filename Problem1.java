//Time Complexity : O(n)
//Space Complexity : O(n)

//Code Explaination.
// used the queue approach as said in the basic video. 
// add the elements by the level into queue and remvoed at the level.
// initially we insert the rool level , 
// while q is not empty , we remove that element and check whether it is having the left and righ if we have them , then add it to queue.
// at each iteration , we add the level element and remove them.


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
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>(); // use deque as a queue
        queue.add(root);
        
        while (!queue.isEmpty()) {
            
            int numNodesInLevel = queue.size();
            
            List<Integer> level = new ArrayList<>(numNodesInLevel);
            for (int i = 0; i < numNodesInLevel; i++) {
                
                TreeNode n = queue.remove();
                level.add(n.val);
                
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }
            lists.add(level);
        }
        return lists;   
    }
}
