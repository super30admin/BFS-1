import java.util.ArrayList;
import java.util.List;

public class LevelOrder_dfs {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {

      dfs(root,0);
      return result;

    }

    private void dfs(TreeNode root, int height){
      if(root == null) return;
      if(height == result.size()){
        result.add(new ArrayList<Integer>());
      }
      result.get(height).add(root.val);
      dfs(root.left, height+1);
      dfs(root.right, height+1);

    }
  }
