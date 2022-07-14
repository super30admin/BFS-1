// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

//Problem statement: https://leetcode.com/problems/binary-tree-level-order-traversal/


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

    List<List<Integer>> master = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        /* BFS
        List<List<Integer>> master = new ArrayList<>();

        if(root == null)
            return master;

        List<Integer> temp;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();
            temp = new ArrayList<>();

            for(int i=0;i<size;i++){

                TreeNode curr = q.poll();

                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                temp.add(curr.val);
            }

            master.add(temp);
        }
    return master;

    } */

        helper(root, 0);
        return master;

    }

    private void helper(TreeNode root, int level){

        if(root == null) return;

        if(level == master.size()){
            master.add(new ArrayList<>());
        }

        master.get(level).add(root.val);

        if(root.left!=null)
            helper(root.left, level + 1);

        if(root.right!=null)
            helper(root.right, level + 1);

    }

}





