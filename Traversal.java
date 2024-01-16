import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class Traversal {
    List<List<Integer>> result;


    /** BFS approach using queue */
    // Time Complexity : O(N) n is the number of nodes
// Space Complexity : O(W)  W is the max width of tree at any level
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return result;
        }
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i = 0; i<size ; i++)
            {
                TreeNode curr = q.poll();
                li.add(curr.val);
                if(curr.left != null)
                {
                    q.add(curr.left);
                }
                if(curr.right != null )
                {
                    q.add(curr.right);
                }
            }
            result.add(li);
        }
        return result;
    }
    /** DFS approach using recursion */
        // Time Complexity : O(N) n is the number of nodes
// Space Complexity : O(H)  H is the height of tree
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(root,0);
        return result;
        
    }
    private void helper(TreeNode root, int level)
    {
        //base
        if(root == null)
            return;
        
        //logic
        if(result.size() == level)
            {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            helper(root.left, level+1);
            helper(root.right,level+1);
    }

    public static void main(String[] args) {
        Traversal t = new Traversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);

        // Function call
        System.out.println(t.levelOrder(root).toString());
    }
}
