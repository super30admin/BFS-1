// S30 Big N Problem #58 {Medium}
// 199. Binary Tree Right Side View
// Time Complexity :O(n) where n is the number of nodes
// Space Complexity :O(n) n sized queue is maintained
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
// BFS solution
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
    List<Integer> result=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {

        //edge case
        if(root==null) return result;
        
        
        Queue <TreeNode> q =new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(i==0) result.add(node.val);
                if(node.right!=null) q.add(node.right);
                if(node.left!=null) q.add(node.left);
            }
        }
        return result;
    }
}