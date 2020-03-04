// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class RightTreeOpt {
    public List<Integer> rightSideView(TreeNode root) {


        Queue <TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> res = new LinkedList<Integer>();
        if (root==null){
            return res;
        }
        if (root.right==null && root.left == null){
            res.add(root.val);
            return res;
        }
        q.add(root);
        while(!q.isEmpty()){
            int countNodes = q.size();
            for(int i = 0;i<countNodes;i++){
                TreeNode current = q.poll();
                if(i==countNodes-1){
                    res.add(current.val);
                }
                if(current.left!=null){
                    q.add(current.left);
                }
                if(current.right!=null){
                    q.add(current.right);
                }

            }

        }
        return res;
    }
}