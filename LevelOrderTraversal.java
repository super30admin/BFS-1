import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//Leetcode - 102
public class LevelOrderTraversal {
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
    //BFS approach
    //TC - O(N)
    //SC - O(N/2) - max elements could be leaf nodes in the queue
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> li = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i< size; i++) {
                TreeNode curr = queue.poll();
                li.add(curr.val);
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            result.add(li);
        }
        return result;
    }

    //DFS approach
    //TC - O(N)
    //SC - O(H)
    /*List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int level) {
        //base
        if(root == null) return;
        //logic
        if(result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        helper(root.left, level+1);
        helper(root.right, level+1);
    }*/
}
