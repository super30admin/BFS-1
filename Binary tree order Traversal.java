// Time complexity 0(n)
// space complexity 0(1)
// code successfully executed in leetcode
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        //List<list<integer>> list = new ArrayList<>();
        Queue <TreeNode> q1 = new LinkedList();
        q1.add(root);
        while(!q1.isEmpty()){
            int size = q1.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node  = q1.poll();
                temp.add(node.val);
                if(node.left != null) q1.add(node.left);
                if(node.right != null) q1.add(node.right);
            }
            list.add(temp);
       }
        return list;
    }
}
