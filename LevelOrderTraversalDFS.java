// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversalDFS {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        //dfs
        result = new ArrayList<>();
        if(root == null){
            return result;
        }

        dfs(root,0);
        return result;
    }

    private void dfs(TreeNode root, int level){

        //base
        if(root == null){
            return;
        }

        //logic
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);

        dfs(root.left, level+1);
        dfs(root.right, level+1);

    }
}
