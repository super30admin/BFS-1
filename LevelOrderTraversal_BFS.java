import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
# Problem 1
Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)
 
Time Complexity :   O (N) 
Space Complexity :  O(N) 
Did this code successfully run on Leetcode :    Yes (102. Binary Tree Level Order Traversal)
Any problem you faced while coding this :       No
 */

// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]

public class LevelOrderTraversal_BFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            for(int i=0; i< size; i++){
                TreeNode curr_Node = queue.remove();
                currentLevel.add(curr_Node.val);
                if(curr_Node.left != null){
                    queue.add(curr_Node.left);
                }
                if(curr_Node.right != null){
                    queue.add(curr_Node.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}
