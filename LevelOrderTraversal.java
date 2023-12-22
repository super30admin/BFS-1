//T.C O(n)
//S.C O(n)
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
//Using BFS approach to create list of nodes at each level.
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q =  new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int count = q.size();
            for(int i=0; i< count; i++){
                TreeNode node = q.poll();
                temp.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            res.add(temp);

        }
        return res;
    }
}
