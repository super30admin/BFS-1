//time complexity: O(n)
//space complexity: space complexity: O(n/2+1) : max size of any level
import java.util.*;
class LevelOrderSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0; i<size; i++)
            {
                TreeNode curr = q.poll();
                list.add(curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
                
            }
            result.add(list);
        }
        return result;
        
    }
}