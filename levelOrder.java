// Time Complexity :O(n)// n is no. of nodes in the tree
// Space Complexity :O(N/2)-> O(N)asymptotically  where N/2 is the no. of children in the Tree
// Did this code successfully run on Leetcode 102:yes
/*we use size variable to determine the levels ie,for level distinction*/


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> l=new ArrayList<>();
        if(root==null)
            return l;
        List<Integer> li;
        q.add(root);
        int size;
        while(!q.isEmpty()){
        size=q.size();
            li=new ArrayList<>();
        for(int i=0;i<size;i++){
            TreeNode curr=q.poll();
             li.add(curr.val);
            if(curr.left!=null)
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);
        }
        l.add(li);
        }
        return l;
    }
}