import java.util.ArrayList;
import java.util.List;
//102. Binary Tree Level Order Traversal using dfs
//TC:O(n)
//SC: O(h)
class binaryLevelOrderTraversal {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        result = new ArrayList<> ();
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int lvl){
        //base
        if(root == null){
            return;
        }
        //logic
        //add new list if lvlv is siz eof result list
        if(lvl == result.size()){
            result.add(new ArrayList<> ());
        }
        result.get(lvl).add(root.val);
        dfs(root.left,lvl+1);
        dfs(root.right,lvl+1);
    }
}