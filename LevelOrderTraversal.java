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

//TimeComplexity: O(N)
//Space Complexity: O(N) ;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null){
            return result;
        }

        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while(queue.size()>0){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while(size-->0){
                TreeNode current = queue.poll();
                temp.add(current.val);
                if(current.left!=null)
                    queue.add(current.left);
                if(current.right!=null)
                    queue.add(current.right);
            }
            result.add(temp);
        }
        return result;
    }
}