import java.util.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
/**
* Time Complexity: O(N), it has to visit each node in the tree
* Space Complexity: O(D), where D is the tree's diameter
*
*/
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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        
        ArrayDeque<TreeNode> queue = new ArrayDeque() {{ offer(root);}};
        List<Integer> rightSide = new ArrayList();
        
        // while queue is not empty
        while (!queue.isEmpty()) {
            // length of current level
            int levelLength = queue.size();
            
            for (int i = 0; i < levelLength; ++i) {
                // returns and removes the front element
                TreeNode node = queue.poll();
                // If it's the rightmost element 
                if (i == levelLength - 1) {
                    rightSide.add(node.val);
                }
                
                // add child nodes in the queue
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return rightSide;
    }
}
