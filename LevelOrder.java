import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class LevelOrder {
    List<List<Integer>> result = new ArrayList<>();
    //BFS: use size variable for each depth/level
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> vals = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode poll = q.poll();
                vals.add(poll.val);
                if(poll.left!=null) q.add(poll.left);
                if(poll.right!=null) q.add(poll.right);

            }
            result.add(vals);

        }
        return result;
    }
}

//DFS:
//class Solution {
//    List<List<Integer>> result;
//    //DFS:
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if(root == null) return new ArrayList<>();
//        result = new ArrayList<>();
//        dfs(root,0);
//        return result;
//    }
//    private void dfs(TreeNode root,int depth){
//        if(root==null)return;
//        if(depth == result.size()){
//            List<Integer> temp = new ArrayList<>();
//
//            temp.add(root.val);
//            result.add(temp);
//        }
//        else{
//            result.get(depth).add(root.val);
//        }
//        dfs(root.left,depth+1);
//        dfs(root.right,depth+1);
//    }
//}