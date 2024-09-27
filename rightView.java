//time complexity: O(n)
//space complexity: O(n/2+1) : max size of any level
import java.util.*;

class RightViewSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if (root == null)
            return res;
        q.offer(root);
        while(!q.isEmpty())
        {
            int lvlSize = q.size();
            for (int i = 0; i < lvlSize; i++)
            {
                TreeNode t = q.poll();
                if (i == lvlSize-1)
                    res.add(t.val);
                if(t.left != null)
                    q.add(t.left);
                if(t.right != null)
                    q.add(t.right);
            }
            
        }
        return res;
        
    }
}