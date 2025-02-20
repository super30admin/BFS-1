// Time Complexity : O(n) as we are traversing every node.
// Space Complexity : O(1) since we are using a queue.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
import java.util.*;
class TreeNode {
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
class Solution {
   //Plain level order traversal
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
       
        while(!que.isEmpty())
        {
            int len = que.size();
            List<Integer> tempRes = new ArrayList<Integer>();
            for(int i=0; i<len; i++)
            {
                TreeNode node = que.poll();
                tempRes.add(node.val);
                if(node.left != null)
                    que.offer(node.left);
                if(node.right != null)
                    que.offer(node.right);
            }
            result.add(tempRes);
        }
            return result;
    }
}