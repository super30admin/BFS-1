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
class Solution {
    List<List<TreeNode>> res = new ArrayList<>();
    List<List<Integer>> fin = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return fin;
        List<TreeNode> child = new ArrayList<>();
        child.add(root);
        res.add(child);
        helper(child);
        for(int i=0;i<res.size();i++){
            List<Integer> fin1 = new ArrayList<>();
            for(int j=0;j<res.get(i).size();j++){
                fin1.add(res.get(i).get(j).val);
            }
            fin.add(fin1);
        }
        return fin;
    }
    public void helper(List<TreeNode> child){
        List<TreeNode> res1 = new ArrayList<>();
        for(int i=0;i<child.size(); i++){
            if(child.get(i).left!=null){
                res1.add(child.get(i).left);
            }
            if(child.get(i).right!=null){
                res1.add(child.get(i).right);
            }
        }
        if(res1.size()==0)
            return;
        res.add(res1);
        helper(res1);
    }
}


//Time complexity : O(N) where N is the number of elements in the tree
//Space complexity : O(N) where N is the number of elemnts in the tree
