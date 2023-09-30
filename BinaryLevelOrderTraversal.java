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

//TC - O(n)
//SC -O(h)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        result = new ArrayList<>();
       
        dfs(root, 0);
    return result;
       
    }

    private void dfs(TreeNode root, int level){

        if(root == null){
            return;
        }

        if(level == result.size()){
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            result.add(temp);
        }else{
            result.get(level).add(root.val);
        }

        dfs(root.left, level+1);
        dfs(root.right, level+1);

    }
}