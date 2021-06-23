import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BTLevelOrderTraversal {
    public class TreeNode {
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
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int depth) {
        if (root == null)
            return;
        if (result.size() == depth) {
            result.add(new ArrayList());
        }
        result.get(depth).add(root.val);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}

//For DFS
//Time complexity is O(n)
//Space Complexity is O(h). Worst case is h=n;


//class Solution {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList();
//        if(root==null)
//            return result;
//        Queue<TreeNode> q = new LinkedList();
//        q.add(root);
//        while(!q.isEmpty())
//        {
//            int size = q.size();
//            List<Integer> li = new ArrayList();
//            for(int i=0;i< size ;i++)
//            {
//                TreeNode cur = q.poll();
//                li.add(cur.val);
//                if(cur.left!=null)
//                    q.add(cur.left);
//                if(cur.right!=null)
//                    q.add(cur.right);
//
//            }
//            result.add(li);
//        }
//        return result;
//    }
//}

//For BFS
//Time complexity is O(n)
//Space Complexity is O(width). Worst case is O(n).