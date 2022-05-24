// Time Complexity : O(n)
// Space Complexity : O(m) // number of nodes at one level
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        while(!queue1.isEmpty()){
            List<Integer> level = new LinkedList<>();
            while(!queue1.isEmpty()){
                TreeNode node = queue1.remove();
                if(node == null) continue;
                level.add(node.val);
                if(node.left != null) queue2.add(node.left);
                if(node.right != null) queue2.add(node.right);
            }
            if(level.size() >0)
                res.add(level);
            queue1 =(LinkedList<TreeNode>) queue2.clone();
            queue2.clear();
        }
        return res;
    }
    
}