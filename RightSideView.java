package week5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
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

    public List<Integer> getRightSide(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null) return result;
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (i == size-1) {
                    result.add(curr.val);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return result;
    }



    public List<Integer>  getRightSideDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result, int level) {
        if(root == null) return;

        if(result.size() == level)
            result.add(root.val);
        helper(root.right, result,level+1);
        helper(root.left, result, level+1);

    }


}
