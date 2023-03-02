//T.C- O(N)-each node is processed exactly once. 
//S.C-O(N)- O/P ds contains N nodes values
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        Queue<TreeNode> Queue= new LinkedList<>();
        if(root==null){
            return result;  //base case
        }
        
        Queue.add(root);
        while(!Queue.isEmpty()){
            int qsize= Queue.size();
            List<Integer> level = new ArrayList<>(); 
            for(int i=0; i<qsize;i++){
                
                TreeNode node= Queue.remove();
                level.add(node.val);
                if(node.left!=null){
                    Queue.add(node.left);
                }
                if(node.right!=null){
                    Queue.add(node.right);
                }
            }
            result.add(level); //Add every level to the result
        }
        return result;
    }
}
