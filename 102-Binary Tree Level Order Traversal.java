/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//Time complexity=O(n), as we are traversing all nodes ones
//Space Complexity=O(n), in worst case, in our queue we have all the leaf nodes, i.e. n/2 nodes
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//We are doing bfs traversal to solve this problem
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
	List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> st=new LinkedList<>();
        st.add(root);
        List<Integer> nodes; 
        while(!st.isEmpty())
        {
            int size=st.size();
            nodes = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode curr =st.poll();
                nodes.add(curr.val);
                if(curr.left!=null) st.add(curr.left);
                if(curr.right!=null) st.add(curr.right);
            }
            result.add(nodes);
        }
        return result;
	}
}



