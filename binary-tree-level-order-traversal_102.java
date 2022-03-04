// Time Complexity : O(N) where N is number of nodes in tree
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//push root ot queue, then take the count of nodes in queue and pop that many nodes to get the nodes of a particular level, push childs of poped nodes to queue
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int numOfNodes = q.size();
            for(int i=0; i<numOfNodes;i++) {
                TreeNode t = q.remove();
                if (t.left!=null) q.add(t.left);
                if (t.right!=null) q.add(t.right);
                level.add(t.val);
            }
            res.add(level);
        }
        return res;
    }
}
