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
 // Time Complexity o(n) Space complexity o(h);
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> li = new ArrayList<>();
        if(root == null) return li;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> a = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode ele = q.poll();
                a.add(ele.val);
                if(ele.left!=null) q.add(ele.left);
                if(ele.right!=null) q.add(ele.right);

            }
            li.add(a);
        }
        return li;
    }
}