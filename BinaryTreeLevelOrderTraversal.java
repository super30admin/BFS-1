import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //Using BFS Approach
    // TC = O(n)
    // SC = O(n) // maximum width of the tree
    class SolutionBFS {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            //using queue DS becz we need FIFO order
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            if(root == null) return result;
            while(!q.isEmpty()){
                int size = q.size();
                List<Integer> li = new ArrayList<>();
                for(int i =0; i<size; i++){
                    TreeNode node = q.poll();
                    li.add(node.val);
                    if(node.left!=null){
                        q.add(node.left);
                    }
                    if(node.right!=null){
                        q.add(node.right);
                    }
                }
                result.add(li);
            }
            return result;
        }
    }

    //Using DFS Approach
    // TC = O(n)
    // SC = O(n)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> levelOrder(TreeNode root) {
            dfs(root, 0);
            return result;
        }
        public void dfs(TreeNode root, int height){
            if(root==null) return;
            if(result.size()==height){
                result.add(new ArrayList<>());
            }
            result.get(height).add(root.val);
            dfs(root.left, height+1);
            dfs(root.right, height+1);
        }

    }
}
