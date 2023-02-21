/*
Level Order Traversal of a tree
approach: using queues and dfs
time: O(n)
space: O(n)
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class Problem1 {
    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null ) return result;
        Queue<TreeNode> q = new LinkedList<>() {
        };
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            while(size-->0) {
                TreeNode popped = q.poll();
                temp.add(popped.val);
                if(popped.left!=null) q.add(popped.left);
                if(popped.right!=null) q.add(popped.right);
            }
            result.add(temp);
        }

        return result;
    }

    static List<List<Integer>> result;

    static List<List<Integer>> levelOrderDFS(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    static void dfs(TreeNode root, int depth) {
        if (root==null) return;

        if (depth==result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(depth).add(root.val);


        dfs(root.left, depth+1);
        dfs(root.right, depth+1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        root.left = n9;
        root.right = n20;
        n20.left = n15;
        n20.right = n7;
        levelOrderDFS(root);
    }
}
