// Time Complexity :O(n) 
// Space Complexity :O(n) it will number of leaf node in the bottom. Which will be maximum be n/2. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.*;
class Solution {
     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        //edge case
        if(root ==null) return output;
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        while(!bfs.isEmpty())
        {
            int size= bfs.size();
            TreeNode node = null;
            for(int i = 0; i <size;i++)
            {
                node = bfs.poll();
                if(node.left!=null) bfs.add(node.left);
                if(node.right!=null) bfs.add(node.right);
            }
            output.add(node.val);
        }
        return output;
    }
}