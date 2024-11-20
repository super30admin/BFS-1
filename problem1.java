import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// Time and Space Compexity: 0(V+H)
// V=numCourses that is nodes in graph, H:number of prerequisites, edges in the graph

public class problem1 {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root==null)
        {
            return result;
        }

        Queue<TreeNode> q = new LinkedList(); //
        q.offer(root);

        while(!q.isEmpty())
        {
            int size=    q.size();
            List<Integer> level = new ArrayList();
            for(int i=0; i <size; i++)
            {
                TreeNode curr= q.poll();
                level.add(curr.val);
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
