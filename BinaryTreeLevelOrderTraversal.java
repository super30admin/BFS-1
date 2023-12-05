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
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // *********************BFS****************************
        // TC:O(n) where n is number of nodes in binary tree
        // SC:O(n/2) number of elements at leaf nodes(max)
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                li.add(temp.val);
                if(temp.left!= null){
                    q.add(temp.left);
                }
                if(temp.right!= null){
                    q.add(temp.right);
                }

            }
            result.add(li);
        }
        return result;
    }
    //***************DFS***************
    List<List<Integer>> result; //we can pass this locally as well cz its a reference type
    public List<List<Integer>> levelOrder1(TreeNode root) {
        // TC:O(N)
        // SC:O(h) stack space
        result = new ArrayList<>();
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root, int height){
        //base
        if(root == null) return;
        if(height == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(height).add(root.val);
        helper(root.left, height+1);
        helper(root.right, height+1);
    }
}
