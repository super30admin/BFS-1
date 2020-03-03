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
class RightTree {
    public List<Integer> rightSideView(TreeNode root) {


        List <TreeNode> l = new LinkedList<TreeNode>();
        List<Integer> res = new LinkedList<Integer>();
        if (root==null){
            return res;
        }
        if (root.right==null && root.left == null){
            res.add(root.val);
            return res;
        }
        res.add(root.val);
        l.add(root);
        while(!l.isEmpty()){
            int level = l.size();

            for(int i = 0;i<level;i++){
                TreeNode current = l.get(0);
                if(current.left!=null){
                    l.add(current.left);
                }
                if(current.right!=null){
                    l.add(current.right);
                }
                if(i == level -1){
                    TreeNode last = l.get(l.size()-1);
                    res.add(last.val);
                }
                l.remove(0);


            }
        }
        res.remove(res.size()-1);
        return res;
    }
}
