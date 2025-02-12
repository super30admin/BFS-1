import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
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
        Queue<TreeNode> visited = new LinkedList<>();
        visited.add(root);
        while(!visited.isEmpty()){
            int size = visited.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreeNode index = visited.poll();
                level.add(index.val);
                if(index.left != null){
                visited.add(index.left);
                }
                if(index.right != null){
                visited.add(index.right);
                }
            }
            result.add(level);
        }

        return result;
    }
}