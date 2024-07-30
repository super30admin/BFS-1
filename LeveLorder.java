import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTr {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
       List<List<Integer>> result = new ArrayList<>();
      
       if(root == null){
           return result;
       }
       q.add(root);
       int level =0;
       while (!q.isEmpty()) {
           result.add(new ArrayList<Integer>());
           int rowSize = q.size();
           for (int i = 0; i < rowSize; ++i) {
               TreeNode t = q.remove();
              result.get(level).add(t.val);
               if(t.left!=null) q.add(t.left);
               if(t.right !=null) q.add(t.right);
           }
           
           level++;

       }
       return result;
       
   }
}
