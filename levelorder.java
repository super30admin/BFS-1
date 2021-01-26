// Time Complexity : o(n) since each node is processes only once
// Space Complexity : o(n) because of the queue, it is not equal to n,queue zie differs
// Did this code successfully run on Leetcode : yes





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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>(); // [] for each level
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();  //depending upn the size of the queue which depends on the level. polling pout the elements. 
                temp.add(cur.val);
                if(cur.left != null)
                    q.add(cur.left); // current left node's children are added to the queue first before popping out the right queue and adding it's children
                if(cur.right != null)
                    q.add(cur.right);
            }
            result.add(temp);  
        }
        return result;
    }
}